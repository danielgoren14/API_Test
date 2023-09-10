package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CatFactsExample {
    public static void main(String[] args) {
        try {
            // Make an HTTP GET request to the Cat facts API
            String response = Unirest.get(Cat.PATH).asString().getBody();

            // Use Jackson ObjectMapper to deserialize the response
            ObjectMapper objectMapper = new ObjectMapper();
            Cat catFact = objectMapper.readValue(response, Cat.class);

            // Print the fields of the Cat fact
            System.out.println("Cat Fact:");
            System.out.println("Fact: " + catFact.getFact());
            System.out.println("Length: " + catFact.getLength());

        } catch (UnirestException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}