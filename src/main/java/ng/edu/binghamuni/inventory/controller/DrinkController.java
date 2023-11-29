package ng.edu.binghamuni.inventory.controller;

import org.springframework.stereotype.Controller;
import ng.edu.binghamuni.inventory.Domain.Drink;
import ng.edu.binghamuni.inventory.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DrinkController {
    @Autowired
    DrinkService drinksService;

    @GetMapping("/")
    public String homepage(Model model){
        model.addAttribute("drinks", drinksService.getAllDrink());
        return "index";
    }

    @GetMapping("/showNewDrinkForm")
    public String showNewDrinkForm(Model model){
        Drink drink = new Drink();
        model.addAttribute("drink",drink);

        return "new drinks";
    }


    @PostMapping ("/saveDrink")
    public String saveDrink(@ModelAttribute("drink") Drink drink){
        drinksService.saveDrink(drink);
        return "redirect:/";
    }
}
