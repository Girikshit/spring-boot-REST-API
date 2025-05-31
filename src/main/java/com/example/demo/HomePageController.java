package com.example.demo;


import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
public class HomePageController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String getHomePage() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/index.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }
}
