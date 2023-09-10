package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockInfo {
    private String symbol;
    private String companyName;
    private double currentPrice;

    public StockInfo() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String apiUrl = "https://api.example.com/stock"; // Replace with your StockInfo API endpoint
            String response = Unirest.get(apiUrl).asString().getBody();

            StockInfo stockInfo = objectMapper.readValue(response, StockInfo.class);

            System.out.println("Symbol: " + stockInfo.getSymbol());
            System.out.println("Company Name: " + stockInfo.getCompanyName());
            System.out.println("Current Price: $" + stockInfo.getCurrentPrice());
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