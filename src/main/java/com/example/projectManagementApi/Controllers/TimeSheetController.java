package com.example.projectManagementApi.Controllers;

import com.example.projectManagementApi.Interfaces.ITimeSheet;
import com.example.projectManagementApi.Models.Note;
import com.example.projectManagementApi.Models.TimeSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("time_sheet")
@CrossOrigin(maxAge = 3600)
public class TimeSheetController {
    @Autowired
    ITimeSheet iTimeSheet;

    @GetMapping("/list")
    public List<TimeSheet> getAll() {return iTimeSheet.findAll();}

    @PostMapping("/add")
    public TimeSheet add(@RequestBody TimeSheet timeSheet) {return iTimeSheet.save(timeSheet);}

    @PutMapping("/update")
    public TimeSheet update(@RequestBody TimeSheet timeSheet) { return  iTimeSheet.save(timeSheet);}

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable Integer id){iTimeSheet.deleteById(id);}
}
