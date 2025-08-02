package com.example.parser.services;

import com.example.parser.services.INameParser;
import com.example.parser.model.Author;

public class NameParser implements INameParser {

    @Override
    public Author parseFullName(String name) {
        Author newAuthor = new Author();

        if (name == null) {
            throw new RuntimeException ("No name to parse was provided.");
        }

        var splitName = name.split("\\s+");

        //Handle special case where last name is first in the provided string
        if (splitName[0].contains(",")){
            newAuthor.lastName = splitName[0].replace(",", "");
            newAuthor.firstName = splitName[1];

            if (splitName.length > 2) {
                for (int i = 2; i < splitName.length; i++) {
                    newAuthor.firstName += " " + splitName[i];
                }
            }
        }
        else {
            newAuthor.lastName = splitName[splitName.length - 1];
            newAuthor.firstName = splitName[0];

            if (splitName.length > 2){
                for (int i = 1; i < splitName.length -1; i++) {
                    newAuthor.firstName += " " + splitName[i];
                }
            }
        }

        return newAuthor;
    }
}