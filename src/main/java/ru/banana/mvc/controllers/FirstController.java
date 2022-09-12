package ru.banana.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first") // меняет путь с http://localhost:8080/goodbye на
//http://localhost:8080/first/goodbye ...ломает все ранее прописанные пути
public class FirstController {

    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request) {
//        /* внедряем через Spring объект в котором содержатся все
//        сведения от Пользователя в виде http-запроса */
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        /* получаем из объекта параметры запроса */


    /* доступ к параметрам через аннотацию */
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname) {
/* в отличии от HttpServletRequest запрос без параметров выдаст ошибку
* required = false убирает эту ошибку*/

        System.out.println("Hello, "+name +" "+surname);

        return"first/hello";
}

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
