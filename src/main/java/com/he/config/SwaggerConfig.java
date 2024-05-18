package com.he.config;




import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Value("${spring.application.name:我的应用}")
    private String applicationName;

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("云智和后端swagger文档")
                        .description("这里文档有大致的接口信息，入参出参等")
                        .contact(new Contact().name("hehsiwei").email("heshiweiol@outlook.com").url("null"))
                        .version("v2.0"));
    }

}

