package config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import sun.misc.Contended;

/**
 * Created by m-okumura on 2017/07/11.
 */
@Component
@ConfigurationProperties(prefix = "gurunavi")
@Data
public class GurunaviConfiguration {
    private String key;
    private String lat;
    private String lon;
    private String range;
    private String format;
    private String path;
    private String url;
}
