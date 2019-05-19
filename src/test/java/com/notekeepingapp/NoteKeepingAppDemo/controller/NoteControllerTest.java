package com.notekeepingapp.NoteKeepingAppDemo.controller;

import com.notekeepingapp.NoteKeepingAppDemo.model.Note;
import com.notekeepingapp.NoteKeepingAppDemo.service.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = NoteController.class, secure = false)
public class NoteControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    NoteService noteService;

    List<Note> mockNotesList = Arrays.asList(new Note(1, "test", "Anju", "in28Minutes", new Date()));

    @Test
    public void getNotesResponseStatus() throws Exception {
        Mockito.when(noteService.getNotes(Mockito.anyString())).thenReturn(mockNotesList);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/list-notes/Anju").accept(MediaType.APPLICATION_JSON)).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void getNotesResponseContent() throws Exception {
        Mockito.when(noteService.getNotes(Mockito.anyString())).thenReturn(mockNotesList);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/list-notes/Anju").accept(MediaType.APPLICATION_JSON)).andReturn();
        assertEquals(true, result.getResponse().getContentAsString().contains("Anju"));
    }

}
