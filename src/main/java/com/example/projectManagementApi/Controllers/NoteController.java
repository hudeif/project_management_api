package com.example.projectManagementApi.Controllers;

import com.example.projectManagementApi.Interfaces.INote;
import com.example.projectManagementApi.Models.Meeting;
import com.example.projectManagementApi.Models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("note")
@CrossOrigin(maxAge = 3600)
public class NoteController {
    @Autowired
    INote iNote;


    @GetMapping("/list")
    public List<Note> getAll() {return iNote.findAll();}

    @PostMapping("/add")
    public Note add(@RequestBody Note note) {return iNote.save(note);}

    @PutMapping("/update")
    public Note update(@RequestBody Note note) { return  iNote.save(note);}

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable Integer id){iNote.deleteById(id);}
}
