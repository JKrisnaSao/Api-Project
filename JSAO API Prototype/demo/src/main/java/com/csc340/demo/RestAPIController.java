package com.csc340.demo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;
import java.util.logging.Level;
@RestController
public class RestAPIController {

    @GetMapping("/Poke")
    public Object getPokemon (@RequestParam(value = "name", defaultValue = "bulbasaur") String Pokemon){
        try{
            String url = "https://pokeapi.co/api/v2/pokemon" + Pokemon;
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            Poke x = new Poke(root.get("forms").get("0").get("name").asText(), root.get("id").asInt(),
                    root.get("weight").asInt());
            return x;
        }catch (JsonProcessingException ex){
            Logger.getLogger(RestAPIController.class.getName()).log(Level.SEVERE,null,ex);
            return "error in /Pokemon";
        }
    }
}
