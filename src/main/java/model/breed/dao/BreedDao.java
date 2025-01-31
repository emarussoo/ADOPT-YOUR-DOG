package model.breed.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.DogNotFoundException;
import exceptions.GenericSystemException;
import exceptions.InvalidBreedTestInput;
import model.breed.Breed;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.TestQuestions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

//this dao is used to get a dog Breed from Ninjas API
public class BreedDao {
    private static final Logger debugLogger = LogManager.getLogger("debugLogger");

    public Breed getBreedByAnswers(List<String> answers) throws URISyntaxException, IOException, InterruptedException, InvalidBreedTestInput, DogNotFoundException {

        Properties prop = new Properties();
        String apiKey;
        if(answers.size() != TestQuestions.values().length){
            throw new InvalidBreedTestInput("Please answer all the questions of the breed test!");
        }

        String jsonResponse;
        HttpClient client = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();


        String baseUrl = "https://api.api-ninjas.com/v1/dogs?";
        List<String> params = List.of(
                TestQuestions.DOMANDA_1.getApiValue() + "=" + URLEncoder.encode(answers.get(0), StandardCharsets.UTF_8),
                TestQuestions.DOMANDA_2.getApiValue() + "=" + URLEncoder.encode(answers.get(1), StandardCharsets.UTF_8),
                TestQuestions.DOMANDA_3.getApiValue() + "=" + URLEncoder.encode(answers.get(2), StandardCharsets.UTF_8),
                TestQuestions.DOMANDA_4.getApiValue() + "=" + URLEncoder.encode(answers.get(3), StandardCharsets.UTF_8),
                TestQuestions.DOMANDA_5.getApiValue() + "=" + URLEncoder.encode(answers.get(4), StandardCharsets.UTF_8),
                TestQuestions.DOMANDA_6.getApiValue() + "=" + URLEncoder.encode(answers.get(5), StandardCharsets.UTF_8)
        );

        String uri = baseUrl + String.join("&", params);

        try(FileInputStream config = new FileInputStream("src/main/resources/config.properties")){
            prop.load(config);
            apiKey = prop.getProperty("API-KEY");
        } catch (FileNotFoundException e) {
            throw new GenericSystemException(e.getMessage());
        } catch (IOException e) {
            throw new GenericSystemException(e.getMessage());
        }

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(uri)
                )
                .header("X-Api-Key", apiKey)
                .GET()
                .build();

        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        jsonResponse = httpResponse.body();

        debugLogger.debug(uri);
        debugLogger.debug(jsonResponse);

        try{
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            if(rootNode.isArray() && rootNode.size()>0){
                rootNode = rootNode.get(0);
            }

            String imageLink = rootNode.get("image_link").asText();
            String name = rootNode.get("name").asText();
            String coatLength = rootNode.get("coat_length").asText();
            String playfulness = rootNode.get("playfulness").asText();
            String protectiveness = rootNode.get("protectiveness").asText();
            String energy = rootNode.get("energy").asText();
            String barking = rootNode.get("barking").asText();

            return new Breed(imageLink, name, coatLength, playfulness, protectiveness, energy, barking);

        } catch (Exception e) {
            throw new DogNotFoundException("A dog who meets your needs does not exists");
        }
    }
}
