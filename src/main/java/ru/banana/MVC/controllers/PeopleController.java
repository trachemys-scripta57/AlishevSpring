package ru.banana.MVC.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.banana.MVC.DAO.PersonDAO;
import ru.banana.MVC.models.Person;

import javax.validation.Valid;



@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

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

    @GetMapping("{id}") //@PathVariable извлекает значение id из URL запроса
    public String show(@PathVariable("id") int id, Model model) {
        //получим одного человека по id из DAO и передадим на отображение в представление
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) { //все ошибки валидации здесь
        if (bindingResult.hasErrors())
            return "people/new";

        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
        /*  */
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "people/edit"; //если есть ошибки валидации возвращаем к редактированию
        personDAO.update(id, person);
        return "redirect:/people";
        /* ищем человека с id, меняем на значения полученные из формы с помощью
         * @ModelAttribute */
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}

