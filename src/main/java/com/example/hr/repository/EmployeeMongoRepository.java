package com.example.hr.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.example.hr.document.EmployeeDocument;

@Service
public interface EmployeeMongoRepository extends MongoRepository<EmployeeDocument, String> {
	
}
