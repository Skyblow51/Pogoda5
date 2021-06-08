import java.io.IOException;
import java.time.Period;

public interface WeatherResponse {
    void getWeather(String selectedCity, Period period) throws IOException;
}
