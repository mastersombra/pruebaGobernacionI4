package com.gobernacion.pruebai4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gobernacion.pruebai4.models.User;
import com.gobernacion.pruebai4.services.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/v1/users")

public class UserController {
    
    @Autowired
    UserService userService;

    @Operation(summary = "Servicio para guardar un usuario")
    @PostMapping()
    public User saveUser(@RequestBody User user){
        return this.userService.saveUser(user);
    }

    @Operation(summary = "Servicio para obtener la información de un usuario dado el tipo y número de identificación")
    @GetMapping("/query")
    public List<User> findByIdentificationTypeAndIdentificationNumber(@RequestParam("identificationType") String identificationType, @RequestParam("identificationNumber") Integer identificationNumber){
        return this.userService.findByIdentificationTypeAndIdentificationNumber(identificationType,identificationNumber);
    }
}
