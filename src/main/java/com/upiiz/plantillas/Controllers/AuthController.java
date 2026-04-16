package com.upiiz.plantillas.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
public class AuthController {
    //http://localhost:8080/auth/login
    //http://localhost:8080/auth/register
    //de las plantillas buscar
    //la carpeta CEE
    //la carpeta js
    //la carpeta de plugins
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @GetMapping("/forgot-password")
    public String forgotPassword(){
        return "forgot-password";
    }
}
