package com.notekeepingapp.NoteKeepingAppDemo.service;

import com.notekeepingapp.NoteKeepingAppDemo.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class NoteService {

    private static List<Note> notes = new ArrayList<Note>();
    private static int noteCount = 3;

    static {
        notes.add(new Note(1, "test","Anju" ,"in28Minutes", new Date()));
        notes.add(new Note(2, "test","Anju","in28Minutes", new Date()));
        notes.add(new Note(3, "test","Hari", "in28Minutes", new Date()));
    }

    public List<Note> getNotes(String user) {
        System.out.println(user);
        List<Note> filteredNotes = new ArrayList<Note>();
        for (Note note : notes) {
            if (note.getUser().equals(user)) {
                filteredNotes.add(note);
            }
        }
        return filteredNotes;
    }

    public Note addNote(Note note){
        notes.add(note);
        return note;
    }

    public Note deleteNote(int id) {
        Iterator<Note> iterator = notes.iterator();
        while(iterator.hasNext()){
            Note note = iterator.next();
            if(note.getId()==id){
                iterator.remove();
                return note;
            }
        }
        return null;
    }
}
