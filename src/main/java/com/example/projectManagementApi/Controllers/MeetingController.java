package com.example.projectManagementApi.Controllers;

import com.example.projectManagementApi.Custom.MeetingRequest;
import com.example.projectManagementApi.Interfaces.IMeeting;
import com.example.projectManagementApi.Models.Meeting;
import com.example.projectManagementApi.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("meeting")
@CrossOrigin(maxAge = 3600)
public class MeetingController {

    @Autowired
    IMeeting iMeeting;

    @GetMapping("/list")
    public List<Meeting> getAll() {return iMeeting.findAll();}

    @PostMapping("/add")
    public Meeting add(@RequestBody MeetingRequest Request) {
        Meeting meeting =new Meeting();
        meeting.setId(Request.id);
        meeting.setMeetingTitle(Request.meetingTitle);
        meeting.setStartingDate(Request.startingDate);
        meeting.setEndingDate(Request.endingDate);
        meeting.setAgenda(Request.agenda);
        meeting.setDiscussionResult("");
        meeting.setProject(Request.project);
        Request.users.forEach(m ->{
            meeting.getUsers().add(m);
        });

        return iMeeting.save(meeting);}

    @PutMapping("/update")
    public Meeting update(@RequestBody Meeting meeting) { return  iMeeting.save(meeting);}

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable Integer id){iMeeting.deleteById(id);}
}
