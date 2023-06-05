package com.kashish.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    //defines controller for hello world message in spring boot

    @GetMapping("/world")
    public String print(){
        return "Hello world";
    }
    @GetMapping("/name")
    public  String name(@RequestParam("p") String name){
        String s;
        s = "hello " + name;
        return s;


    }

}
