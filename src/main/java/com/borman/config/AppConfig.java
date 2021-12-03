package com.borman.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableOpenApi
@Configuration
@ComponentScan("com.borman")
@EnableJpaRepositories(basePackages = "com.borman.repository")
@EnableTransactionManagement
//@PropertySources({
//        @PropertySource("classpath:application.properties"),
//        @PropertySource("classpath:application-${MYENV:test}.properties")})
//        @PropertySource("classpath:application-1.properties")})
public class AppConfig implements WebMvcConfigurer {


//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.borman.resource"))
//                .paths(regex("/v1.*"))
//                .build();
//    }


//	@Bean
//	public WebMvcConfigurerAdapter adapter() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addResourceHandlers(ResourceHandlerRegistry registry) {
//				registry.addResourceHandler("swagger-ui.html")
//						.addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
//				registry.addResourceHandler("/webjars/**")
//						.addResourceLocations("classpath:/META-INF/resources/webjars/");
//				super.addResourceHandlers(registry);
//			}
//		};
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler( "api/swagger-ui.html" )
//				.addResourceLocations( "classpath:/META-INF/resources/" );
//	}
//	@Bean
//	public Docket swagger() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any())
//				.build();
//	}

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
}
