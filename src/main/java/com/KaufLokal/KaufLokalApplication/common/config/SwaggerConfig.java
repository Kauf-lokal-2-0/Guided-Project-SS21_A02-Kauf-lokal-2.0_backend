package com.KaufLokal.KaufLokalApplication.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.KaufLokal.KaufLokalApplication"))
                .build()
                .apiInfo(getAPIMetaData());
    }

    // API meta-data information
    private ApiInfo getAPIMetaData() {
        return new ApiInfo("KaufLokalApplication", "The backend of the KaufLokalApplication","1.0",
                "",
                new Contact(
                        "Prof. Dr. Dietlind Zühlke",
                        "https://www.th-koeln.de/personen/dietlind.zuehlke/",
                        "dietlind.zuehlke@th-koeln.de"),
                        "https://www.th-koeln.de/personen/dietlind.zuehlke/",
                        "https://www.th-koeln.de/personen/dietlind.zuehlke/");
    }
}
