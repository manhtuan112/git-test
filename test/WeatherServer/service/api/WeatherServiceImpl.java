package WeatherServer.service.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import WeatherServer.models.Weather;
import WeatherServer.service.https.HttpResponse;
import WeatherServer.service.https.SimpleHTTPHelper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class WeatherServiceImpl {
    String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    String API_KEY = "7e4d9db4d524205a796bd533fb467938";

    public Weather getWeatherByCityName(String cityName){
        ObjectMapper mapper = new ObjectMapper();

        String requestQuery = "q=" +cityName+ "&appid=" + API_KEY +"&units=metric";

        SimpleHTTPHelper http = new SimpleHTTPHelper();
        try{
            URI uri = new URI("https","api.openweathermap.org", "/data/2.5/weather", requestQuery, null); // ?? 3

            HttpResponse res = http.get(uri.toASCIIString());

            JsonNode root = mapper.readTree(res.getBody());
            JsonNode main = root.path("main");
            JsonNode wind = root.path("wind");



            // Get Data
            final int _temp = main.path("temp").asInt();
            final double _windSpeed = wind.path("speed").asDouble();
            final int _humidity = main.path("humidity").asInt();
            final String _cityName = root.path("name").asText();

            return new Weather(_cityName, _temp, _humidity, _windSpeed);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }


        return null;

    }
}
