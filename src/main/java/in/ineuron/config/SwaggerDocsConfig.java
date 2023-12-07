package in.ineuron.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {
	
	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("in.ineuron.restController"))
				.paths(PathSelectors.regex("/api/tourist.*"))
				.build()
				.useDefaultResponseMessages(true).apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		
		Contact contact = new Contact("Parth", "www.http//ineuron.ai", "parth@learn.com");
		return new ApiInfo("TouristInfo",
				"Tourist Ticket Mgmt info",
				"1.1.0","http:",
				contact,"TOUR11.2"
				,"http//tourist.lisc",
				Collections.emptyList());
	}

}
