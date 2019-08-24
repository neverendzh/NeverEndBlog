package com.neverend.blog.config;

import com.neverend.blog.moudel.Msg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration//配置类
@EnableSwagger2//启用Swagger
public class SwaggerConfig {
    @Bean//加入到spring的容器中
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.neverend.blog.contoller"))//需要扫描的包路径
                .paths(PathSelectors.any())
                .build()
                .apiInfo(testApiInfo());
    }

    private ApiInfo testApiInfo() {
        return new ApiInfoBuilder()
                .title("neverend.blog-api文档")//标题
                .description("详细描述")//详细描述
                .version("1.0")//版本
                .termsOfServiceUrl("http://127.0.0.1:80/swagger-ui.html")
                .contact(
                        new Contact("neverend","http://127.0.0.1:80/swagger-ui.html",
                                "15936581373@163.com"))//作者的一些信息
                .license("The Apache License, Version 2.0")//发布遵循协议
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")//协议地址
                .build();
    }
}
