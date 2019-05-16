package com.notekeepingapp.NoteKeepingAppDemo.service;

import com.notekeepingapp.NoteKeepingAppDemo.model.User;
import com.notekeepingapp.NoteKeepingAppDemo.DAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;
    public boolean isValidateUser(User user){
        String enteredPassword = user.getPassword();
        User registeredUser = userRepository.findByusername(user.getUser_name());
        String passwordFromDB = "";
        if(registeredUser!=null)
            passwordFromDB = registeredUser.getPassword();
        System.out.println(enteredPassword+" "+passwordFromDB);
        return enteredPassword==passwordFromDB;
    }

    public boolean isUserRegistered(User user){
        return userRepository.findByusername(user.getUser_name())!=null;
    }
}
