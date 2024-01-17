package com.wasanabag.serverAPI.controller;

import com.wasanabag.serverAPI.model.Attendance;
import com.wasanabag.serverAPI.servicer.AttendentService;
import com.wasanabag.serverAPI.types.Month;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/api/v1/attendant")
public class AttendentController {
    private final AttendentService attendentService;

    @GetMapping("/all")
    public List<Attendance> getAllAttendants(){
        return attendentService.getAllAttendants();
    }

    @PostMapping("/")
    public Attendance addAttendant(@RequestBody Attendance attendance){
        return attendentService.addAttendant(attendance);
    }

    @GetMapping("/{id}")
    public Attendance getAttendantById(@PathVariable String id){
        return attendentService.getAttendantById(id);
    }

    @GetMapping("/date/{search}")
    public List<Attendance> getAttendantByDate(@PathVariable String search){
        return attendentService.getAttendantByDate(search);
    }

    @GetMapping("/lastmonth/{id}")
    public List<Attendance> getAttendantByLastMonth(@PathVariable LastMonth data){
        return attendentService.getAttendantByLastMonth(data.id, data.lastMonth);
    }


}

class LastMonth{
    String id;
    Month lastMonth;
}
