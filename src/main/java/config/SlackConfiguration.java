package config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by m-okumura on 2017/07/12.
 */
@Component
@ConfigurationProperties(prefix = "slack")
@Data
public class SlackConfiguration {
    private String token;
}

