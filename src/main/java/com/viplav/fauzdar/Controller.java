package com.viplav.fauzdar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/hello")
    public String hello(){
        return "Hello Viplav!";
    }

    @GetMapping("/docker")
    public String docker(){return "Hello from Docker container again!";}

    @GetMapping("/docker1")
    public String docker1(){return "It has better work this time !!! And ti worked :)";}

    @GetMapping("/fun")
    public String fun(){return "Remote reloading is fun! This should reload too";}

}
