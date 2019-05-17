package com.notekeepingapp.NoteKeepingAppDemo.service;

import com.notekeepingapp.NoteKeepingAppDemo.DAO.NoteRepository;
import com.notekeepingapp.NoteKeepingAppDemo.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public List<Note> getNotes(String user) {
        return noteRepository.findNoteByUser(user);
    }

    public Note addNote(Note note) {
        noteRepository.save(note);
        return note;
    }

    public void deleteNote(int id) {
        noteRepository.deleteById(id);
    }

    public boolean isNoteExists(int id) {
        return noteRepository.findNoteById(id) != null;
    }

    public void updateNote(Note note) {
        noteRepository.updatenoteTitle(note.getId(), note.getNoteTitle());
        noteRepository.updatenoteContent(note.getId(), note.getNoteContent());
    }
}
