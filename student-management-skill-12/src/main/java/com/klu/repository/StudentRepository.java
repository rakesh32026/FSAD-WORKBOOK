package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.model.*;
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
