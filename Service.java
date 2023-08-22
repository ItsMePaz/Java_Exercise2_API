import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class Service {

  private static final String API_KEY =
    "bb84485de7msh31c59ad058f8672p144493jsn75355a5deb40";

  public static JSONArray movieService()
    throws IOException, InterruptedException { //This retrieves the data from the api in json format
    HttpRequest request = HttpRequest
      .newBuilder()
      .uri(
        URI.create(
          "https://online-movie-database.p.rapidapi.com/auto-complete?q=game%20of%20thr"
        )
      )
      .header("X-RapidAPI-Key", API_KEY)
      .header("X-RapidAPI-Host", "online-movie-database.p.rapidapi.com")
      .method("GET", HttpRequest.BodyPublishers.noBody())
      .build();
    HttpResponse<String> response = HttpClient
      .newHttpClient()
      .send(request, HttpResponse.BodyHandlers.ofString());

    /* System.out.println(response.body()); */
    JSONObject moviesParent = new JSONObject(response.body());
    JSONArray moviesArray = moviesParent.optJSONArray("d");
    return moviesArray;
  }
}
