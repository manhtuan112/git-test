package WeatherServer.client;

import WeatherServer.service.tcp.WeatherTCPService;
import WeatherServer.service.tcp.WeatherTCPServiceImpl;

public class StartTCPClient {
    public static void main(String[] args) {
        WeatherTCPService weatherService = new WeatherTCPServiceImpl();
        String weatherInfo = weatherService.getWeatherInfoByCityName("Hanoi");
        System.out.println(weatherInfo);
    }
}
