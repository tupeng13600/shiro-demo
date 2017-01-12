package com.tp.shiro.swagger;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
public class DemoDocket extends Docket {

    public DemoDocket(DocumentationType documentationType) {
        super(documentationType);
        init();
    }

    private void init() {
        this.select()
                .apis(RequestHandlerSelectors.basePackage("com.tp.shiro.controller"))
                .build()
                .directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("shiro-demo API Center")
                .description("这是一个demo的API展示")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("涂鹏", "http://blog.csdn.net/u010199513", "2267026134@qq.com"))
                .build();
    }
}
