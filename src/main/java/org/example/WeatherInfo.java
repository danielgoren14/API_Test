package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {
    private String city;
    private String description;
    private double temperature;

    public WeatherInfo() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String apiUrl = "https://api.example.com/weather"; // Replace with your Weather API endpoint
            String response = Unirest.get(apiUrl).asString().getBody();

            WeatherInfo weatherInfo = objectMapper.readValue(response, WeatherInfo.class);

            System.out.println("City: " + weatherInfo.getCity());
            System.out.println("Description: " + weatherInfo.getDescription());
            System.out.println("Temperature: " + weatherInfo.getTemperature() + "°C");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello world!");
    }
}