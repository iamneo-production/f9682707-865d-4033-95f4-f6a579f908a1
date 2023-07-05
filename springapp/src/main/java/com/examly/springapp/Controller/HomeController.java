package com.examly.springapp.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
    @GetMapping("/hello")
    public String display()
    {
        return "hello";
    }
}
