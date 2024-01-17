package com.wasanabag.serverAPI.servicer;

import com.wasanabag.serverAPI.model.Attendance;
import com.wasanabag.serverAPI.repository.AttendanceRepository;
import com.wasanabag.serverAPI.types.Month;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class AttendentService {
    private final AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendants() {
        return attendanceRepository.findAll();
    }

    public Attendance addAttendant(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance getAttendantById(String id) {
        return attendanceRepository.findById(id).orElseThrow(() -> new RuntimeException("Attendant not found"));
    }

    public List<Attendance> getAttendantByDate(String search) {
        return attendanceRepository.findByDate(search);
    }

    public List<Attendance> getAttendantByLastMonth(String id, Month lastMonth) {
        List<Attendance> list_of_last_month = attendanceRepository.findByLastMonth(lastMonth);
        List<Attendance> list_of_employee = null;
        if (!list_of_last_month.isEmpty()) {
            for (Attendance attendance : list_of_last_month) {
                if (attendance.getId().equals(id)) {
                    list_of_employee.add(attendance);
                }
            }
        }
        return list_of_employee;
    }
}
