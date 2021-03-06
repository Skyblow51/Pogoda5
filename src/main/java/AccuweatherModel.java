
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


public class AccuweatherModel {
    private static final String PROTOCOL = "http";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static  final String CURRENT_CONDITIONS = "currentconditions";
    private static final String VERSION = "v1";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final String API_KEY = "n7KbqJbsIiPwUJPsqtU1pFUmxUHBUGRs";
    static OkHttpClient okHttpClient = new  OkHttpClient();
    static ObjectMapper objectMapper = new ObjectMapper();

    public static void getWeather(String selectedCity, Period period) throws IOException {
      HttpUrl httpUrl = new HttpUrl.Builder()
               .scheme(PROTOCOL)
               .host(BASE_HOST)
               .addPathSegments(CURRENT_CONDITIONS)
                .addPathSegments(VERSION)
              .addPathSegments(getCityKey(selectedCity))
              .addQueryParameter("apikey", API_KEY)
              .build();

      Request request = new Request.Builder()
              .url(httpUrl)
              .build();

      Response response = okHttpClient.newCall(request).execute();
      System.out.println(response.body().string());

    }

    public static String getCityKey(String city) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegments(LOCATIONS)
                .addPathSegments(VERSION)
                .addPathSegments(CITIES)
                .addPathSegments(AUTOCOMPLETE)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", city)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseBody = response.body().string();

        String cityKey = objectMapper.readTree(responseBody).get(0).at("/Key").asText();
        System.out.println(cityKey);
        return responseBody;
    }


        public static void main(String[] args) throws IOException {
        getWeather("Saint Petersburg", Period.NOW);
        }
}



