package com.skh;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("openshift-demo API")
                                .description("APIs for the openshift-demo Spring Boot WebFlux application. Exposes OCP demo endpoints such as welcome and fullName.")
                                .version("1.0.0")
                                .contact(new Contact()
                                        .name("Tech Learn")
                                        .email("techlearn508@gmail.com")
                                        .url("https://github.com/techlearn-skh/all-practice-projects")
                                )
                                .license(new License()
                                        .name("Apache 2.0")
                                        .url("https://www.apache.org/licenses/LICENSE-2.0")
                                )
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Project repository and docs")
                        .url("https://github.com/techlearn-skh/all-practice-projects")
                )
                .tags(Arrays.asList(
                        new Tag().name("OCPDemoController API").description("Operations for welcome and fullName endpoints exposed by OCPDemoController")
                ));
    }
}
