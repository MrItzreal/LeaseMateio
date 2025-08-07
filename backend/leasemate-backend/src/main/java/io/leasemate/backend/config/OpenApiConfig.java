package io.leasemate.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "LeaseMateIO API", version = "1.0", description = "This API exposes endpoints to managed properties, apartments, and tenants.", contact = @Contact(name = "Call Me Izzy!", email = "[No Personal Email]", url = "https://x.com/fullstackizzy"), license = @License(name = "MIT License", url = "https://choosealicense.com/licenses/mit/"), termsOfService = "https://x.com/fullstackizzy"), servers = @Server(url = "http://localhost:8080", description = "Server URL in Local development environment"))

public class OpenApiConfig {
  // OpenApiConfig class is just a holder for the above configuration.
}
