package com.example.parser.model;


public class Author {
    private String firstName;
    private String lastName;

    public String getFullName(){
        return (firstName + " " +lastName);
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}