package pl.sda.openweather;


import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.openweather.model.Current;
import pl.sda.openweather.model.Weather;
import pl.sda.openweather.model.WeatherService;

import java.io.IOException;
import java.net.URL;

;


public class Main {
    public static void CityTemp(String city) {
        try {
            URL jsonURL = new URL("https://api.apixu.com/v1/current.json?key=d081446f4efd41a992a91031191002&q=" + city);
            ObjectMapper objectMapper = new ObjectMapper();
            Weather weather2 = objectMapper.readValue(jsonURL, Weather.class);
            System.out.println("Temperatura dla miasta "+city+" wynosi: "+weather2.getCurrent().getTemp_c());
//            weather2 = objectMapper.readValue(jsonURL, Weather.class);
        } catch (IOException e) {
            System.out.println("Nie można znaleźć wartości dla miasta "+city);;
        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {

        CityTemp("dsdd");


        WeatherService weatherService = new WeatherService(
                "http://api.apixu.com/v1/current.json",
                "?key=d081446f4efd41a992a91031191002&q="
        );

        weatherService.getCityWeather("Ketrzyn");

    }
}
