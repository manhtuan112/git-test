package WeatherServer.service.tcp;

import com.fasterxml.jackson.databind.ObjectMapper;
import WeatherServer.models.Weather;
import WeatherServer.service.api.WeatherServiceImpl;

import java.io.IOException;

public class WeatherCommand  {
    private String cityName;

    public WeatherCommand(String cityName) {
        this.cityName = cityName;
    }

    public Response execute() {
        return execute(false);
    }

    public Response execute(boolean isReturnJson) {
        WeatherServiceImpl service = new WeatherServiceImpl();
        Weather weather = service.getWeatherByCityName(cityName);
        String data;

        // ?? 4

        if (isReturnJson) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                data = mapper.writeValueAsString(weather);
            } catch (IOException e) {
                data = weather.toString();
            }
        } else {
            data = weather.toString();
        }

        return new Response(data);
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
