package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {
    public static void main(String[] args) {


        ObjectMapper objectMapper = new ObjectMapper();
        try {

            String response = Unirest.get("https://official-joke-api.appspot.com/random_joke").asString().getBody();
            Joke joke = objectMapper.readValue(response,Joke.class);
            System.out.println(joke.getId() + "\n");
            System.out.println(joke.getType() + "\n");
            System.out.println(joke.getSetup() + "\n" + joke.getPunchline());

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello world!");
    }
}