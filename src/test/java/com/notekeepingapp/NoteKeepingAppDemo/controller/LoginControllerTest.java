package com.notekeepingapp.NoteKeepingAppDemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.notekeepingapp.NoteKeepingAppDemo.DAO.UserRepository;
import com.notekeepingapp.NoteKeepingAppDemo.model.User;
import com.notekeepingapp.NoteKeepingAppDemo.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LoginController.class, secure = false)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserRepository userRepository;

    @MockBean
    LoginService loginService;

    @Test
    public void showLoginPage() throws Exception {
        String uri = "/";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void isValidUser() throws Exception{
        String uri="/login";
        User mockUser = new User("Anju", "admin");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String mockUserJSON = ow.writeValueAsString(mockUser);
        Mockito.when(loginService.isUserRegistered(mockUser)).thenReturn(true);
        Mockito.when(loginService.isValidCredentials(mockUser)).thenReturn(true);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .accept(MediaType.APPLICATION_JSON).content(mockUserJSON)
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        assertEquals(200,result.getResponse().getStatus());
        assertEquals("true", result.getResponse().getContentAsString());
    }
}
