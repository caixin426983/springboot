package com.example.controller;


import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userController")
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping("selectAll")
    @ResponseBody
    public Object selectAll() {
        return userService.selectAll();
    }

    @GetMapping("getEntityById")
    public Object getEntityById(@RequestParam Long id) {
        return userService.getEntityById(id);
    }


}
