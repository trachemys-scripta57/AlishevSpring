package ru.banana.MVC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.banana.MVC.DAO.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonDAO personDAO;
//внедряем зависимость через конструктор
    @Autowired
    public PeopleController(PersonDAO personDAO) {

        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        //получим всех людей из DAO и передадим на отображение в представление
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }
    @GetMapping("/id")
    public String show(@PathVariable("id") int id, Model model) {
        //получим одного человека по id из DAO и передадим на отображение в представление
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
}

