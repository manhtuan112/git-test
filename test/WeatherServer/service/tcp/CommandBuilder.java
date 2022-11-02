package WeatherServer.service.tcp;

import WeatherServer.service.exception.InvalidCommand;

public class CommandBuilder {
    public static WeatherCommand parseWeatherCommand(String cmd) throws InvalidCommand {
        return WeatherCommandParser.parse(cmd);
    };
}
