package site.amass.swagger.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.amass.swagger.example.consts.Const;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {

	@Bean
	public Docket restApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("example").select()
				.apis(RequestHandlerSelectors.basePackage(Const.PACKAGE_SITE_AMASS_SWAGGER_EXAMPLE_CONTROLLER))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger接口文档示例").description("文档示例符合RESTful API规范").version(Const.VERSION)
				.build();
	}

}
