package com.sy.world;

//import com.sy.world.entity.Staff;
//import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
//@EnableConfigurationProperties({Staff.class})
@PropertySource("application.yml")
//@EnableEurekaClient
//@EnableHystrixDashboard
//@EnableCircuitBreaker
public class WorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorldApplication.class, args);
    }

//    @Bean
//    public MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName) {
//        return registry -> registry.config().commonTags("application", applicationName);
//    }
}


