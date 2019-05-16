package com.notekeepingapp.NoteKeepingAppDemo.controller;

import com.notekeepingapp.NoteKeepingAppDemo.exception.NoteNotFoundException;
import com.notekeepingapp.NoteKeepingAppDemo.helloworld.HelloWorldBean;
import com.notekeepingapp.NoteKeepingAppDemo.model.Note;
import com.notekeepingapp.NoteKeepingAppDemo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class NoteController {

    @Autowired
    NoteService noteService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/list-notes/{name}")
    public List<Note> showNotes(@PathVariable String name) {
        return noteService.getNotes(name);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/list-notes/{name}")
    public ResponseEntity addNote(@PathVariable String name, @RequestBody Note note) {
        note.setUser(name);
        Note addedNote = noteService.addNote(note);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedNote.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/list-notes/{name}/{id}")
    public void deleteNote(@PathVariable int id){
        Note user = noteService.deleteNote(id);
        if(user==null){
            throw new NoteNotFoundException("id-"+id);
        }
    }
}
