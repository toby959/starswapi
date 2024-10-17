import com.google.gson.Gson;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MovieQuery {

    public Movie searchMovie(int movieNumber) {

        URI address = URI.create("https://swapi.py4e.com/api/films/" + movieNumber+ "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();
        try {
            HttpResponse<String> response = response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Movie.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa Pelicula");
        }
    }
}





