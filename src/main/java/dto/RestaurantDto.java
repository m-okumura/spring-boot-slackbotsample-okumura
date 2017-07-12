package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m-okumura on 2017/07/06.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class RestaurantDto {

    int total_hit_count;
    int hit_per_page;
    int page_offset;
    List<RestaurantDataDto> rest = new ArrayList<>();

}

