package com.test.employee.config;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport{

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(metaData());
    }
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry){
    	registry.addResourceHandler("swagger-ui.html")
    			.addResourceLocations("classpath:META-INF/resources/");
    	
    	registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:META-INF/resources/webjars/");
    }
    
    private ApiInfo metaData(){

        Contact contact = new Contact("Salman Baig", "Senior Associate",
                "salman.baig.8@gmail.com");

        return new ApiInfo(
                "Employee Competency Service",
                "Displays Employee details and Competency matrix",
                "1.0",
                "Terms of Service: blah",
                contact,
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }

}