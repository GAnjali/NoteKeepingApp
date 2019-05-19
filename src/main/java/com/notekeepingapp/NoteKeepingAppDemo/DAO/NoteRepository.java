package com.notekeepingapp.NoteKeepingAppDemo.DAO;

import com.notekeepingapp.NoteKeepingAppDemo.model.Note;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {

    List<Note> findNoteByUser(@Param("username") String username);

    Note findNoteById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("Update Note t SET t.noteTitle=:title WHERE t.id=:id")
    void updatenoteTitle(@Param("id") int id, @Param("title") String title);

    @Transactional
    @Modifying
    @Query("Update Note t SET t.noteContent=:content WHERE t.id=:id")
    void updatenoteContent(@Param("id") int id, @Param("content") String content);
}