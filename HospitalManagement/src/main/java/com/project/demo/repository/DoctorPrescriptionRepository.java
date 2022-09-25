package com.project.demo.repository;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.demo.model.*;

public interface DoctorPrescriptionRepository extends JpaRepository<DoctorPrescription, Integer> {
@Query(value="select * from doctor_prescription dp LEFT JOIN appointment p ON p.patientname=dp.patientname and p.patientname=?1",nativeQuery =true)
DoctorPrescription findbyPatientname(String name); 
}
//SELECT *
//FROM categories
//LEFT JOIN user_category_subscriptions ON 
//    user_category_subscriptions.category_id = categories.category_id
//    and user_category_subscriptions.user_id =1