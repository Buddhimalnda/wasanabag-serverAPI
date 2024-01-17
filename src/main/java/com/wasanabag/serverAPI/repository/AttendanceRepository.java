package com.wasanabag.serverAPI.repository;

import com.wasanabag.serverAPI.model.Attendance;
import com.wasanabag.serverAPI.types.Month;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {
    List<Attendance> findByDate(String search);

    List<Attendance> findByLastMonth(Month lastMonth);
}
