package model.breed.dao;

import model.breed.Breed;
import utils.TestQuestions;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class BreedDao {
    public Breed getBreedByAnswers(List<String> answers) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        String uri = "https://api.api-ninjas.com/v1/dogs?"
                //+ TestQuestions.DOMANDA_1.getApiValue() + "=" + answers.get(0)
                +TestQuestions.DOMANDA_2.getApiValue() + "=" + answers.get(1)
                +"&"+TestQuestions.DOMANDA_3.getApiValue() + "=" + answers.get(2)
                +"&"+TestQuestions.DOMANDA_4.getApiValue() + "=" + answers.get(3)
                +"&"+TestQuestions.DOMANDA_5.getApiValue() + "=" + answers.get(4)
                +"&"+TestQuestions.DOMANDA_6.getApiValue() + "=" + answers.get(5)
                +"&"+TestQuestions.DOMANDA_7.getApiValue() + "=" + answers.get(6)
                +"&"+TestQuestions.DOMANDA_8.getApiValue() + "=" + answers.get(7);

        System.out.println("URI: " + uri);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(uri)
                )
                .header("X-Api-Key", System.getenv("NINJAS-API-KEY"))
                .GET()
                .build();

        HttpResponse httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body().toString());
    return null;
    }
}
