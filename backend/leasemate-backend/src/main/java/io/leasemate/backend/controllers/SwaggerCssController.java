/*
 * 
 * This Controllers sole purpose is to connect the CSS code for a Swagger
 * UI theme change but the CSS code needs improvements, thus not ready yet.
 * 
 * 
 * package io.leasemate.backend.controllers;
 * 
 * import org.springframework.core.io.ClassPathResource;
 * import org.springframework.http.HttpHeaders;
 * import org.springframework.http.MediaType;
 * import org.springframework.http.ResponseEntity;
 * import org.springframework.stereotype.Controller;
 * import org.springframework.util.StreamUtils;
 * import org.springframework.web.bind.annotation.GetMapping;
 * 
 * import java.io.IOException;
 * import java.nio.charset.StandardCharsets;
 * 
 * @Controller
 * public class SwaggerCssController {
 * 
 * @GetMapping(value = "/swagger-ui/swagger-ui.css", produces = "text/css")
 * public ResponseEntity<String> getSwaggerCss() {
 * try {
 * ClassPathResource darkCss = new ClassPathResource("static/swagger-dark.css");
 * String customCss = StreamUtils.copyToString(darkCss.getInputStream(),
 * StandardCharsets.UTF_8);
 * 
 * HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.valueOf("text/css"));
 * headers.setCacheControl("no-cache, no-store, must-revalidate");
 * headers.setPragma("no-cache");
 * headers.setExpires(0);
 * 
 * return ResponseEntity.ok()
 * .headers(headers)
 * .body(customCss);
 * } catch (IOException e) {
 * e.printStackTrace();
 * return ResponseEntity.notFound().build();
 * }
 * }
 * }
 */