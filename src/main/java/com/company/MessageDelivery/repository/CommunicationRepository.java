package com.company.MessageDelivery.repository;

import com.company.MessageDelivery.model.CommunicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationRepository extends JpaRepository<CommunicationEntity, Long> {
}
