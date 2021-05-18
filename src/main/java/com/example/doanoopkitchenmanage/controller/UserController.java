package com.example.doanoopkitchenmanage.controller;

import com.example.doanoopkitchenmanage.model.Login;
import com.example.doanoopkitchenmanage.model.User;
import com.example.doanoopkitchenmanage.model.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login", "login", new Login());
        return modelAndView;
    }
    @PostMapping("/home")
    public ModelAndView home(@ModelAttribute("login") Login login){
        User user = UserDao.checkLogin(login);
        ModelAndView modelAndView;
        if(user == null){
            modelAndView = new ModelAndView("error");
        } else {
            modelAndView = new ModelAndView("home");
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }
}
