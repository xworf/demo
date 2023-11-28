//package cl.prueba.demo.config;
//
//import java.util.Collections;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//
//@Configuration
//@EnableSwagger2
//@EnableWebMvc
//public class SwaggerConfig {
//	@Bean
//	public Docket apiDocket() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("cl.prueba.demo.endpoint"))
//				.paths(PathSelectors.any())
//				.build()
//				.apiInfo(getApiInfo())
//				;
//	}
//	
//	private ApiInfo getApiInfo() {
//		return new ApiInfo(
//				"Ejercicio Java Especialista",
//				"Servicios Rest Expuestos",
//				"1.0",
//				"http://willy.com/terms",
//				new Contact("Willy Ramirez", "https://www.linkedin.com/in/willy-ramirez-fonseca/", "xworf75@gmail.com"),
//				"LICENSE",
//				"LICENSE URL",
//				Collections.emptyList()
//				);
//	}
//}
