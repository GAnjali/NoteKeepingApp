package com.notekeepingapp.NoteKeepingAppDemo.model;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min = 2)
    private String user;

    @Size(min = 2)
    private String noteTitle;

    @Size(min = 10)
    private String noteContent;

    private Date createdAt;

    public Note() {
    }

    public Note(int id, String user, String noteTitle, String noteContent, Date createdAt) {
        this.id = id;
        this.noteTitle = noteTitle;
        this.user = user;
        this.noteContent = noteContent;
        this.createdAt = createdAt;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Note{" + "id=" + id + ", user='" + user + '\'' + ", noteTitle='" + noteTitle + '\'' + ", noteContent='"
                + noteContent + '\'' + ", createdAt=" + createdAt + '}';
    }
}
