package org.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class QuickChartAPIClient {
    private static final String QUICK_CHART_API_URL = "https://quickchart.io/chart";

    public ChartResponse generateBarChart(String chartData) {
        try {
            HttpResponse<JsonNode> response = Unirest.get(QUICK_CHART_API_URL)
                    .queryString("c", chartData)
                    .asJson();

            if (response.getStatus() == 200) {
                JsonNode responseBody = response.getBody();
                String chartUrl = responseBody.getObject().getString("url");
                return new ChartResponse(true, chartUrl);
            } else {
                return new ChartResponse(false, null);
            }
        } catch (UnirestException e) {
            e.printStackTrace();
            return new ChartResponse(false, null);
        }
    }
}