package ug.proj.warframe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class EndpointLogger {

	private final RequestMappingHandlerMapping requestMappingHandlerMapping;

	@Autowired
	public EndpointLogger(ApplicationContext context) {
		this.requestMappingHandlerMapping = context.getBean("requestMappingHandlerMapping",
				RequestMappingHandlerMapping.class);

		System.out.println("📌 Listing all registered endpoints:");
		requestMappingHandlerMapping.getHandlerMethods().forEach((key, value) -> {
			System.out.println("🔹 " + key + " => " + value);
		});
	}
}
