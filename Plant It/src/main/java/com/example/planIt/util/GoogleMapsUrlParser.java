package com.example.planIt.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleMapsUrlParser {

    private static final Pattern COORDINATES_PATTERN = Pattern.compile("@(-?\\d+\\.\\d+),(-?\\d+\\.\\d+),");

        public static double[] extractCoordinates(String url) {
        Matcher matcher = COORDINATES_PATTERN.matcher(url);
        if (matcher.find()) {
            double lat = Double.parseDouble(matcher.group(1));
            double lon = Double.parseDouble(matcher.group(2));
            return new double[]{lat, lon};
        }
        throw new IllegalArgumentException("Invalid Google Maps URL");
    }
//    private static final Logger logger = LoggerFactory.getLogger(GoogleMapsUrlParser.class);
//    //private static final Pattern COORDINATES_PATTERN = Pattern.compile("@(-?\\d+\\.\\d+),(-?\\d+\\.\\d+),\\d+z");

//    public static double[] extractCoordinates(String url) {
//        if (url == null || url.isEmpty()) {
//            throw new IllegalArgumentException("URL cannot be null or empty");
//        }
//
//        logger.info("Extracting coordinates from URL: {}", url);
//
//        Matcher matcher = COORDINATES_PATTERN.matcher(url);
//        if (matcher.find()) {
//            try {
//                double lat = Double.parseDouble(matcher.group(1));
//                double lon = Double.parseDouble(matcher.group(2));
//                return new double[]{lat, lon};
//            } catch (NumberFormatException e) {
//                throw new IllegalArgumentException("Invalid coordinates in URL: " + url, e);
//            }
//        }
//        throw new IllegalArgumentException("Invalid Google Maps URL: " + url);
//    }
}