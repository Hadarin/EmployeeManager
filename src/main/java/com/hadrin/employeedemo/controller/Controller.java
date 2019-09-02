package com.hadrin.employeedemo.controller;

import com.hadrin.employeedemo.Service.UserService;
import com.hadrin.employeedemo.dao.EmployeeRepository;
import com.hadrin.employeedemo.dao.LanguageRepository;
import com.hadrin.employeedemo.dao.RoleRepository;
import com.hadrin.employeedemo.dao.UserRepository;
import com.hadrin.employeedemo.entity.Employee;
import com.hadrin.employeedemo.entity.Language;
import com.hadrin.employeedemo.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Igor Hadarin
 * @version 1.0
 */
@org.springframework.stereotype.Controller
@RequestMapping("/employees")
public class Controller {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/users")
    public String findRoles(Model model) {

        //Retrieve users with 'USER' roles
        List<User> users = userRepository.findAll().stream().filter(p->p.getRoles().contains(roleRepository.findByRole("USER"))).collect(Collectors.toList());

        model.addAttribute("users", users);

        return "users";

    }


    @GetMapping("/list")
    public  String findEmployees(Model model, Principal principal) {

        // get all employees from database
        List<Employee> page = employeeRepository.findAllByOrderByLastNameAsc();

        // retrieve logged user to display fistName and lastName of the logged user in the list of employees page
        String email  = principal.getName();
        User loggedUser = userService.findUserByEmail(email);

        //add logged user and list of employees into the model
        model.addAttribute("user", loggedUser);
        model.addAttribute("page", page);

        return "employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        // create a new Employee object and add it to the Model for the next filling out in the form
        Employee employee = new Employee();

        // create Language object and add it to the Model for te next filling out in the form
        Language language = new Language();

        model.addAttribute("employee", employee);
        model.addAttribute("language", language);

        return "employee-form";

    }

    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, @ModelAttribute("language") Language language) {


        // Checking filled fields in the form and return form in case of validation errors
        // or return list of employees page after employee saving
        if (bindingResult.hasErrors()) {
            return "employee-form";
        } else {

           Language languageObject = languageRepository.findByLanguageName(language.getLanguageName());

           employee.setLanguages(new HashSet<Language>(Arrays.asList(languageObject)));

           employeeRepository.save(employee);

            return "redirect:/employees/list";
        }

    }

    @GetMapping("/showFormForUpdate")
    public String saveEmployee(@RequestParam("employeeId") Long theId, Model model) {

        //take the employee from the db by id as request parameter
        Optional<Employee> employee = employeeRepository.findById(theId);

        Language language = new Language();

        //save this employee into the model
        model.addAttribute("employee", employee);
        model.addAttribute("language", language);

        //use redirect to prevent duplicate submissions
        return "employee-form";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") Long theId) {

        //delete the employee from the db by id as request parameter
        employeeRepository.deleteById(theId);

        //use redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") Long theId) {

        userRepository.deleteById(theId);

        return "redirect:/employees/users";

    }

}
