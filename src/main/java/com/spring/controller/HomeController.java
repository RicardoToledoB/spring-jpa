package com.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("homeController")
public class HomeController {
    @RequestMapping("/")
    public String root(){
        return "/home"; 
    }
    @RequestMapping("/home")
    public String home(){
        return "/home";
    }
    @RequestMapping("/usuario/home")
    public String homeUsuario(){
        return "/usuario/home";
    }
   
    
}
