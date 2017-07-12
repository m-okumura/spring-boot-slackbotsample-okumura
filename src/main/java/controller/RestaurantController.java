package controller;


import dto.RestaurantDataDto;
import dto.RestaurantDto;
import service.GurunaviAPIService;

/**
 * Created by m-okumura on 2017/07/06.
 */
public class RestaurantController {

    public static RestaurantDataDto getReccomendRestaurant() {

        GurunaviAPIService service = new GurunaviAPIService();

        RestaurantDto restaurantDto = service.getRecommend();
        RestaurantDataDto data = restaurantDto.getRest().stream()
                .skip((int)(Math.random()*10))
                .limit(1)
                .findAny()
                .orElse(new RestaurantDataDto());

        //System.out.println(restaurantDto.getName());
        System.out.print(data.getId() + " : " + data.getName()  + " : " + data.getUrl());

        return data;
    }

}
