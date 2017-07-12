package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created by m-okumura on 2017/07/07.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class RestaurantDataDto {

    String id;
    String name;
    String url;
}
