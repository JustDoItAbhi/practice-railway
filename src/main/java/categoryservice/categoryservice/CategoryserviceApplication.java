package categoryservice.categoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class CategoryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryserviceApplication.class, args);
	}
@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
}
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("categories");
	}
}
