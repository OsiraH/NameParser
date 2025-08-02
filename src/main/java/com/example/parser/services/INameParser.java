package com.example.parser.services;

import com.example.parser.model.Author;

public interface INameParser {
    Author parseFullName(String name);

}