package org.example;

public class ChartResponse {
    private boolean success;
    private String chartUrl;

    public ChartResponse(boolean success, String chartUrl) {
        this.success = success;
        this.chartUrl = chartUrl;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getChartUrl() {
        return chartUrl;
    }
}

