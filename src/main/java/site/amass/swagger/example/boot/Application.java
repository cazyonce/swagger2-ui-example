package site.amass.swagger.example.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import site.amass.swagger.example.consts.Const;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan({ Const.PACKAGE_SITE_AMASS_SWAGGER_EXAMPLE_CONTROLLER, Const.PACKAGE_SITE_AMASS_SWAGGER_EXAMPLE_CONFIG ,"site.amass.swagger.example.boot"})
@Configuration
@SpringBootApplication
@EnableSwagger2 // 开启api 文档
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}