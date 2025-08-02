package com.example.parser.model;


public class Author {
    public String firstName;
    public String lastName;

    public String getFullName(){
        return (firstName + " " +lastName);
    }

    public void setFullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}