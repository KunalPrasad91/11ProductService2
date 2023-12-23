package com.scaler.productservice2dec23.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Hey Spring there are some important things you need to take care of
@Configuration
public class ApplicationConfiguration {

    // RestTemplate class helps to connect to Third Party API
    @Bean
  public RestTemplate createRestTemplate()
  {
      return new RestTemplateBuilder().build();
  }

}
