package github.akanemiku.springbootcacheredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringbootCacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCacheRedisApplication.class, args);
    }

}
