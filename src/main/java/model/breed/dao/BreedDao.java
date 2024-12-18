package model.breed.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.breed.Breed;
import utils.TestQuestions;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.logging.Logger;

public class BreedDao {
    public Breed getBreedByAnswers(List<String> answers) throws URISyntaxException, IOException, InterruptedException {
        String jsonResponse;
        HttpClient client = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        String uri = "https://api.api-ninjas.com/v1/dogs?"
                + TestQuestions.DOMANDA_1.getApiValue() + "=" + answers.get(0)
                +"&"+TestQuestions.DOMANDA_2.getApiValue() + "=" + answers.get(1)
                +"&"+TestQuestions.DOMANDA_3.getApiValue() + "=" + answers.get(2)
                +"&"+TestQuestions.DOMANDA_4.getApiValue() + "=" + answers.get(3)
                +"&"+TestQuestions.DOMANDA_5.getApiValue() + "=" + answers.get(4)
                +"&"+TestQuestions.DOMANDA_6.getApiValue() + "=" + answers.get(5);
                //+"&"+TestQuestions.DOMANDA_7.getApiValue() + "=" + answers.get(6);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(uri)
                )
                .header("X-Api-Key", System.getenv("NINJAS-API-KEY"))
                .GET()
                .build();

        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        jsonResponse = httpResponse.body();
        System.out.println(uri);
        System.out.println(jsonResponse);

        if(jsonResponse.startsWith("[")){
            jsonResponse = jsonResponse.substring(1, jsonResponse.length());

        }
        if(jsonResponse.endsWith("{")){
            jsonResponse = jsonResponse.substring(0, jsonResponse.length()-1);
        }

        try{
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            String imageLink = rootNode.get("image_link").asText();
            String name = rootNode.get("name").asText();
            String coatLength = rootNode.get("coat_length").asText();
            String playfulness = rootNode.get("playfulness").asText();
            String energy = rootNode.get("energy").asText();
            String barking = rootNode.get("barking").asText();
            //String maxHeightMale = rootNode.get("max_height_male").asText();

            return new Breed(imageLink, name, coatLength, playfulness, energy, barking);

        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }
}
