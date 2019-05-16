package com.notekeepingapp.NoteKeepingAppDemo.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

//    @TableGenerator(name = "Users_Gen", table = "users", pkColumnName = "user_id", initialValue = 100, allocationSize = 100)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;

    private String user_name;

    private String password;

    public User(){

    }

//    public User(String user_name, String password) {
//        this.user_name = user_name;
//        this.password = password;
//    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUser_ame(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
