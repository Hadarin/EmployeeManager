package com.hadrin.employeedemo.controller;

import com.hadrin.employeedemo.Service.UserService;
import com.hadrin.employeedemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Igor Hadarin
 * @version 1.0
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

   @GetMapping ("/login")
    public String Login () {

        // return the login page
        return "login2";

    }

  @GetMapping ("/registration")
  public String getRegistration (Model model) {

       // creating new User object and save it into the model
       User newUser = new User();
       model.addAttribute("user", newUser);

       return "registration2";
  }

    @PostMapping ("/registration")
    public String registerUser (@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        //Checking the email of the Employee (It must be unique)
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }

        //Checking validation from the User entity
        if (bindingResult.hasErrors()) {
            return "registration2";
        } else {
            userService.saveUser(user);
            model.addAttribute("successMessage", "User has been registered successfully");
            return "registration2";
        }

    }
}
