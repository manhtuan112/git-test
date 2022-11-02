package WeatherServer.service.tcp;

public interface Command {
    Response execute();
    Response execute(boolean isReturnJson);
}
