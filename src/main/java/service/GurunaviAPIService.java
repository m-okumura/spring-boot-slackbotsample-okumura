package service;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.GurunaviConfiguration;
import dto.RestaurantDto;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;

/**
 * Created by m-okumura on 2017/07/06.
 */
@Component
public class GurunaviAPIService {

    @Autowired
    GurunaviConfiguration gurunaviConfiguration;

    public RestaurantDto getRecommend() {

                /*
        URI targetUrl = UriComponentsBuilder
                .fromUriString(gurunaviConfiguration.getUrl())
                .path(gurunaviConfiguration.getPath())
                .queryParam("keyid",  gurunaviConfiguration.getKey())
                .queryParam("latitude", gurunaviConfiguration.getLat())
                .queryParam("longitude", gurunaviConfiguration.getLon())
                .queryParam("range", gurunaviConfiguration.getRange())
                .queryParam("format", gurunaviConfiguration.getFormat())
                .build()
                .toUri();
                */

        URI targetUrl = UriComponentsBuilder
                .fromUriString("https://api.gnavi.co.jp/")
                .path("RestSearchAPI/20150630/")
                .queryParam("keyid",  "d91f1161b8aab1bc019f14d7c9439be7")
                .queryParam("latitude", "35.640466")
                .queryParam("longitude", "139.750939")
                .queryParam("range", "1")
                .queryParam("format", "json")
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(targetUrl.toString(),  String.class );
        RestaurantDto restaurantDto = new RestaurantDto();

        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Json文字列" + responseEntity.getBody());
            restaurantDto = mapper.readValue(responseEntity.getBody(), RestaurantDto.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return restaurantDto;
    }
}
