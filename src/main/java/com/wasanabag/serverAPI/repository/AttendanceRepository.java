package com.wasanabag.serverAPI.repository;

import com.wasanabag.serverAPI.model.Attendance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {
}
