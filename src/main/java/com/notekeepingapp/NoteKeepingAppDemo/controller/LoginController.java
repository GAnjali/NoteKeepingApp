package com.notekeepingapp.NoteKeepingAppDemo.controller;

import com.notekeepingapp.NoteKeepingAppDemo.model.User;
import com.notekeepingapp.NoteKeepingAppDemo.DAO.UserRepository;
import com.notekeepingapp.NoteKeepingAppDemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    LoginService loginService;


    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage(){
        return "redirect:/login";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLogin(){
        return "login";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Boolean> showWelComePage(@RequestBody  User user){
        if(loginService.isUserRegistered(user)){
            if(loginService.isValidateUser(user))
                return new ResponseEntity<>(true, HttpStatus.OK);
            else
                return new ResponseEntity<>(false, HttpStatus.OK);
        }
        userRepository.save(user);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}