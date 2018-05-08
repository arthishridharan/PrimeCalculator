package com.arthi.prime.calculator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Class to configure multiple media type responses for web service request
 * @author arthi.shridharan
 *
 */
@Configuration
@EnableWebMvc
public class WebConfigurer implements WebMvcConfigurer {

    /**
     * enabled both path extension and url parameter.
     * Defaults to JSON response type
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true).favorParameter(true).parameterName("mediaType").ignoreAcceptHeader(true)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml",
                        MediaType.APPLICATION_XML)
                .mediaType("json", MediaType.APPLICATION_JSON);
    }

}
