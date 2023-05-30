package com.example.wow.Controller;

import com.example.wow.Entity.WowCharacterEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/character")
public class WowApiRestController {

    private final RestTemplate restTemplate;

    public WowApiRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/drril")
    public WowCharacterEntity getWowCharacter() throws JsonProcessingException {

        String apiUrl = "https://eu.api.blizzard.com/profile/wow/character/ravencrest/drril?namespace=profile-eu&locale=en_GB&access_token=EUJn5871gJMdkXodxRrrbSMca3zT63mDr4";

        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            String jsonResponse = response.getBody();

            Gson gson = new Gson();

            JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

            JsonElement raceNameElement = jsonObject.getAsJsonObject("race").get("name");
            JsonElement classNameElement = jsonObject.getAsJsonObject("character_class").get("name");
            JsonElement specNameElement = jsonObject.getAsJsonObject("active_spec").get("name");

            String raceElement = raceNameElement.getAsString();
            String clazzElement = classNameElement.getAsString();
            String specElement = specNameElement.getAsString();

            WowCharacterEntity wowCharacterEntity = new WowCharacterEntity();

            wowCharacterEntity.setId(jsonObject.get("id").getAsInt());
            wowCharacterEntity.setName(jsonObject.get("name").getAsString());
            wowCharacterEntity.setLevel(jsonObject.get("level").getAsInt());
            wowCharacterEntity.setRace(raceElement);
            wowCharacterEntity.setClazz(clazzElement);
            wowCharacterEntity.setSpecialization(specElement);

            return wowCharacterEntity;
        }
        else return null;
    }
}
