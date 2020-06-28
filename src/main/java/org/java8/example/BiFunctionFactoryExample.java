package org.java8.example;

import java.sql.SQLOutput;
import java.util.function.BiFunction;

public class BiFunctionFactoryExample {

    public static void main(String[] args) {
        GPS gps = factory("13.803433", "-86.9776656", (x1, x2) -> new GPS(x1, x2));
        GPS gps1 = factory("13.803433", "-86.9776656", GPS::new);
        System.out.println(gps1);
    }

    public static <R> R factory(String latitude, String longitude, BiFunction<String, String, R> biFunction){
        return biFunction.apply(latitude, longitude);
    }
}

class GPS{
    String latitude;
    String longitude;

    public GPS(String latitude, String longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString(){
        return "GPS {" +
                "Latitude=" + latitude
                +"Longitude=" + longitude
                +"}";
    }
}
