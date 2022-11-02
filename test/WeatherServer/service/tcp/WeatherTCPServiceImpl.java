package WeatherServer.service.tcp;

import java.io.*;
import java.net.Socket;

public class WeatherTCPServiceImpl implements WeatherTCPService{
    public String getWeatherInfoByCityName(String cityName) {
        StringBuilder sb = new StringBuilder();
        DataInputStream is = null;
        DataOutputStream out = null;


        String serverName = "26.211.4.0";
        int port = 8000;

        try {
            // Step 1. Connect to TCP server
            Socket client = new Socket(serverName, port);

            // Step 2. Write message to server, in this case it write city name
            OutputStream outToServer = client.getOutputStream();
            out = new DataOutputStream(outToServer);

            String data = "weather --city=\"" + cityName + "\"";
            out.write(data.getBytes()); // fix thì out.writeUTF

            // Step 3. Get response from server
            is = new DataInputStream(client.getInputStream());
            String responseLine;

            while ((responseLine = is.readUTF()) != null) {
                sb.append(responseLine);
            }

            // Step 4. Close connection
            is.close();
            client.close();
        } catch (EOFException e) {
            System.out.println("Done:: Recived all response data from server.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return string data get from server.
        return sb.toString();
    }
}
