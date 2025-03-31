package com.company.MessageDelivery.repository.directory;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface FileRepository {

    List<String> saveFiles(MultipartFile[] files);
}
