import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    //private WeatherResponse weatherResponse = (WeatherResponse) new AccuweatherModel();

    private Map<Integer, Period> variantResult = new HashMap<>();

    public Controller(){
        variantResult.put(1, Period.NOW);
        variantResult.put(0, Period.FIVE_DAYS);
    }

    public void getWeather(String commandInput, String selectedCity) throws IOException {
        Integer integerCommand = Integer.parseInt(commandInput);

        switch (variantResult.get(integerCommand)) {
            case NOW:
               // weatherResponse.getWeather(selectedCity,Period.NOW);
                break;
            case FIVE_DAYS:
                throw new IOException("Вывод погоды не реализован!");
        }
    }
}
