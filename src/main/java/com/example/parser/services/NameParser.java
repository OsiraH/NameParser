package com.example.parser.services;

import com.example.parser.services.INameParser;
import com.example.parser.model.Author;

public class NameParser implements INameParser {

    @Override
    public Author parseFullName(String name) {
        String lastName;
        String firstName;

        if (name.isBlank()) {
            throw new IllegalArgumentException ("No name to parse was provided.");
        }

        //Handle cases where the last name listed first
        var commaSplit = name.split(",");

        if (commaSplit.length > 2){
            throw new RuntimeException ("More than one comma was found in the provided name.");
        }
        else if (commaSplit.length == 2) {
            lastName = commaSplit[0].replace(",","");
            firstName = commaSplit[1];

            return new Author(firstName, lastName);
        }

        //Handle other cases
        var spaceSplit = name.split("\\s+");

        if (spaceSplit.length == 1){
            throw new RuntimeException ("An author needs a first and a last name.");
        }

        lastName = spaceSplit[spaceSplit.length - 1];
        firstName = spaceSplit[0];

        for (int i = 1; i < spaceSplit.length -1; i++) {
            String.join(firstName, " ", spaceSplit[i]);
        }


        return new Author(firstName, lastName);
    }
}