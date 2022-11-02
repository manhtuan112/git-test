package WeatherServer.service.api;

import WeatherServer.models.Weather;

public interface WeatherService {
    Weather getWeatherByCityName(String cityName);
}
