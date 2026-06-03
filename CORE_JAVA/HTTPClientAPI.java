import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPClientAPI {
    public static void main(String[] args) {
        try {
            // Create an HttpClient
            HttpClient client = HttpClient.newHttpClient();
            
            // Create an HttpRequest to fetch GitHub API data
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.github.com/users/github"))
                    .header("Accept", "application/json")
                    .GET()
                    .build();
            
            System.out.println("Fetching data from GitHub API...\n");
            
            // Send the request and receive the response
            HttpResponse<String> response = client.send(request, 
                    HttpResponse.BodyHandlers.ofString());
            
            // Print response status
            System.out.println("Response Status: " + response.statusCode());
            System.out.println("Response Headers: " + response.headers());
            
            // Print response body
            System.out.println("\nResponse Body:");
            System.out.println(response.body());
            
            // Basic JSON parsing (without external library)
            String body = response.body();
            if (body.contains("\"login\"")) {
                int startIndex = body.indexOf("\"login\":\"") + 9;
                int endIndex = body.indexOf("\"", startIndex);
                String login = body.substring(startIndex, endIndex);
                System.out.println("\nExtracted GitHub username: " + login);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
