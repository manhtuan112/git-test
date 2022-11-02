package WeatherServer.service.exception;

public class NotFoundCommand extends Exception{
    private static final long serialVersionUID = 1L;

    public NotFoundCommand(String message) {
        super(message);
    }
}
