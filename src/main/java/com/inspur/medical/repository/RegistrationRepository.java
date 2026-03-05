package com.inspur.medical.repository;

import com.inspur.medical.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    Optional<Registration> findByLockQueueNo(String lockQueueNo);
    Optional<Registration> findByTransactionId(String transactionId);
}
