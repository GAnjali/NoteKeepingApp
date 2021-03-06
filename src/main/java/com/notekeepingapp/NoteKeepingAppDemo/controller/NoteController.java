package com.notekeepingapp.NoteKeepingAppDemo.controller;

import com.notekeepingapp.NoteKeepingAppDemo.exception.NoteNotFoundException;
import com.notekeepingapp.NoteKeepingAppDemo.model.Note;
import com.notekeepingapp.NoteKeepingAppDemo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class NoteController {

    @Autowired
    NoteService noteService;

    @GetMapping("/list-notes/{name}")
    public ResponseEntity<List<Note>> getNotes(@PathVariable String name) {
        return new ResponseEntity<>(noteService.getNotes(name), HttpStatus.OK);
    }

    @PostMapping("/list-notes/{name}")
    public ResponseEntity<Note> addNote(@PathVariable String name, @RequestBody Note note) {
        note.setUser(name);
        return new ResponseEntity<>(noteService.addNote(note), HttpStatus.OK);
    }

    @PostMapping("list-notes/{name}/{id}")
    public ResponseEntity updateNote(@PathVariable String name, @PathVariable int id, @RequestBody Note note) {
        note.setId(id);
        note.setUser(name);
        noteService.updateNote(note);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/list-notes/{name}/{id}")
    public void deleteNote(@PathVariable int id) {
        if ((noteService.isNoteExists(id))) {
            noteService.deleteNote(id);
        } else {
            throw new NoteNotFoundException("id-" + id);
        }
    }
}
