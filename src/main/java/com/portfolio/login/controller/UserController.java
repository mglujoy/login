package com.portfolio.login.controller;
import com.portfolio.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private UserService userservice;
    
    /*@GetMapping("user/{username}/{password}")
    public UserLogin(@PathVariable("username") String username1, 
                     @PathVariable("password") String password1) {
        int flag = userservice.loginValidation(username1, password1);
        
        if(flag == 0) {
            return 0;
        }
        return flag;
    }*/
}
