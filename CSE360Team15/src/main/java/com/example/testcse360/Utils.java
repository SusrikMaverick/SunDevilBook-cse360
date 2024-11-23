package com.example.testcse360;

public class Utils {
    public static double calculateSellingPrice(String category, String condition, double originalPrice) {
        double conditionFactor;

        // Traditional switch-case to determine the condition factor
        switch (condition) {
            case "Used Like New":
                conditionFactor = 0.8;
                break;
            case "Moderately Used":
                conditionFactor = 0.5;
                break;
            case "Heavily Used":
                conditionFactor = 0.3;
                break;
            default:
                conditionFactor = 1.0;
                break;
        }

        return originalPrice * conditionFactor;
    }
}
