package ug.proj.warframe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class EndpointLogger {
	@Autowired
	public EndpointLogger(ApplicationContext context) {
		RequestMappingHandlerMapping requestMappingHandlerMapping = context
				.getBean(RequestMappingHandlerMapping.class);

		System.out.println("📌 Lista zarejestrowanych endpointów:");
		requestMappingHandlerMapping.getHandlerMethods().forEach((key, value) -> {
			System.out.println("🔹 " + key + " => " + value);
		});
	}
}
