package com.inspur.medical.repository;

import com.inspur.medical.entity.HospitalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalInfoRepository extends JpaRepository<HospitalInfo, Long> {
}
