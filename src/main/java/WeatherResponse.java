import java.io.IOException;

public interface WeatherResponse {
    void getWeather(String selectedCity, Period period) throws IOException;
}
