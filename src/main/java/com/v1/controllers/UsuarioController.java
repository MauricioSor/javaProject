package com.v1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/session")
public class UsuarioController {
    @GetMapping("/")
    public String inicio(){
        return "Api de inicio de sesion";
    }
}