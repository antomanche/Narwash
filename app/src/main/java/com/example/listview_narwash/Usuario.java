package com.example.listview_narwash;

public class Usuario {

    String Email,Password;

    public Usuario(String email, String password) {
        Email = email;
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }
}
