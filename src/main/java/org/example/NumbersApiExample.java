package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.NumberInfoAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NumbersApiExample {
    public static void main(String[] args) {
        try {
            // Specify the URL of the Numbers API
            String apiUrl = "http://numbersapi.com/42";

            // Create a URL object from the API URL string
            URL url = new URL(apiUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // If the response code is 200 (HTTP OK), read the response data
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the JSON response using Jackson ObjectMapper
                ObjectMapper objectMapper = new ObjectMapper();
                NumberInfoAPI numberInfo = objectMapper.readValue(response.toString(), NumberInfoAPI.class);

                // Print the NumberInfoAPI object
                System.out.println("API Response: " + numberInfo.getText());
            } else {
                System.err.println("HTTP GET request failed with response code: " + responseCode);
            }

            // Close the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}