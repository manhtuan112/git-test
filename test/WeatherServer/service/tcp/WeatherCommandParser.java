package WeatherServer.service.tcp;

import WeatherServer.service.exception.InvalidCommand;

public class WeatherCommandParser {
    static WeatherCommand parse(String cmd) throws InvalidCommand {
        int cityNameIndex = cmd.indexOf("--city=\""); // get index start of --city
        String cityName;

        if (cityNameIndex != -1) {
            //get cityName from string weather --city="cityName"
            cityName = cmd.substring(cityNameIndex + 8, cmd.indexOf("\"", cityNameIndex + 8));
        } else {
            throw new InvalidCommand("Argument --city not found.");
        }

        System.out.println(cityName);

        return new WeatherCommand(cityName);
    }
}
