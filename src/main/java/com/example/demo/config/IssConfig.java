package com.example.demo.config;

import com.example.demo.webclient.IssWebClient;
import com.example.demo.webclient.IssWebClientInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableScheduling
public class IssConfig {
    @Bean
    public IssWebClientInterface issWebClient(){
        return new IssWebClient();
    }

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                    .baseUrl("https://api.wheretheiss.at/v1/satellites")
                    .build();
    }


}
