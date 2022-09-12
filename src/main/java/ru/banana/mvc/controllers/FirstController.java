package ru.banana.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    /* доступ к параметрам через аннотацию */
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        /* Передаём параметры через Model в представление и отобразим их */

//        System.out.println("Hello, "+name +" "+surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        /* помещаем строку  "Hello, "+name +" "+surname в model. Ключ (любой) - message*/

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
