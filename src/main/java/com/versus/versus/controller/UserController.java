package com.versus.versus.controller;

import com.versus.versus.domain.entity.User;
import com.versus.versus.domain.service.UserService;
import com.versus.versus.domain.valueObject.enums.BloodType;
import com.versus.versus.domain.valueObject.enums.Gender;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping()
    public String registerUser(
            @RequestParam Map<String, String> allRequestParams,
            HttpSession session
    ) {
        User user = new User(
                Gender.valueOf(allRequestParams.get("gender")),
                BloodType.valueOf(allRequestParams.get("bloodType")),
                Integer.valueOf(allRequestParams.get("age"))
        );
        user.setUserId(1); // TODO
        session.setAttribute("user", user);
        return "redirect:/versus/1";
    }
}
