package ng.edu.binghamuni.inventory.controller.api;

import ng.edu.binghamuni.inventory.repository.DrinkRepository;
import ng.edu.binghamuni.inventory.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ng.edu.binghamuni.inventory.Domain.Drink;

import java.util.List;

@Controller
public class DrinkAPIController {
    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    DrinkService drinkService;

    @RequestMapping("/drinks")
    @GetMapping("/drinks")
    public ResponseEntity<List<Drink>> getAlldrinks(){
        return ResponseEntity.ok().body(drinkService.getAllDrink());
    };

    @RequestMapping("drinks/{id}")
    @GetMapping
    public ResponseEntity<Drink>getDrinkId(@PathVariable long id){
        return  ResponseEntity.ok().body(drinkService.getDrinkById(id));
    }
    @PostMapping("/drink")
    public ResponseEntity<Drink>createDrink(@RequestBody Drink drink){
        return ResponseEntity.ok().body(drinkService.saveDrink(drink));
    }

    @PutMapping("/drink/{id}")
    public ResponseEntity<Drink>updateDrink(@PathVariable long id, @RequestBody Drink drink){
        return ResponseEntity.ok().body(drinkService.updateDrink(drink));
    }
    @DeleteMapping("/drinks")
    public HttpStatus deleteDrink (@PathVariable long id){
        drinkService.deleteDrink(id);
        return HttpStatus.OK;
    }

}
