package com.yidong.yun.config;


import com.google.common.base.Predicates;


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

@Configuration
@EnableSwagger2
public class SwaggerConfig {


        @Bean
        public Docket webApiConfig(){

                Docket docket = new Docket(DocumentationType.SWAGGER_2)
                        .groupName("webApi")
                        .apiInfo(webApiInfo())
                        .select()
                        .apis(RequestHandlerSelectors.basePackage("com"))
                        //过滤掉admin路径下的所有页面
                        .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                        //过滤掉所有error或error.*页面
                        .paths(Predicates.not(PathSelectors.regex("/error.*")))
                        .build();

return docket;

        }


        @Bean
        public ApiInfo webApiInfo(){

                ApiInfo build = new ApiInfoBuilder().title("网站-课程中心API文档")
                        .description("本文档描述了课程中心微服务接口定义")
                        .version("1.0")
                        .contact(new Contact("sun", "http://atguigu.com", "1416412681@qq.com"))
                        .build();


                return build;
        }


}
