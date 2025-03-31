package com.company.MessageDelivery.repository.directory;

import com.company.MessageDelivery.exception.TransferFileException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileRepositoryHandler implements FileRepository {

    private final String COMMUNICATION_PATH;

    public FileRepositoryHandler(String COMMUNICATION_PATH) {
        this.COMMUNICATION_PATH = COMMUNICATION_PATH;
    }

    @Override
    public List<String> saveFiles(MultipartFile[] files) {

        File directory = new File(COMMUNICATION_PATH);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        return Arrays.stream(files)
                .map(this::transferFile)
                .collect(Collectors.toList());
    }

    private String transferFile(MultipartFile multipartFile) {

        String fileName = multipartFile.getOriginalFilename();
        File destinationFile = new File(COMMUNICATION_PATH + fileName);
        try {
            multipartFile.transferTo(destinationFile);
        } catch (IOException e) {
            throw new TransferFileException("Can't transfer file: " + fileName);
        }
        return fileName;
    }
}
