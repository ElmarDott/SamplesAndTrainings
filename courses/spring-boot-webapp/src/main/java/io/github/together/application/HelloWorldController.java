package io.github.together.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloWorldController {

    @RequestMapping("/sample")
    public ModelAndView hello() {

        String helloWorldMessage = "Hello world from java2blog!";
        return new ModelAndView("hello", "message", helloWorldMessage);
    }
}
