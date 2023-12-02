    package ng.edu.binghamuni.inventory.controller;
    
    import org.springframework.beans.BeanUtils;
    import org.springframework.stereotype.Controller;
    import ng.edu.binghamuni.inventory.Domain.Drink;
    import ng.edu.binghamuni.inventory.services.DrinkService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.Banner;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.servlet.mvc.support.RedirectAttributes;

    @Controller

    public class DrinkController {
        @Autowired
        DrinkService drinkService;


        @GetMapping("/")
        public String homePage(Model model){
            model.addAttribute("drinks", drinkService.getAllDrink());
            return "home";
        }

        @GetMapping("/showNewDrinkForm")
        public String showNewDrinkForm(Model model) {
            Drink drink = new Drink();
            model.addAttribute("drink", drink);
            model.addAttribute("pageTitle", "Add Drink");
            return "new_drink";
        }


        @PostMapping("/saveDrink")
        public String saveDrink(@ModelAttribute("drink") Drink drink, RedirectAttributes redirectAttributes){
            drinkService.saveDrink(drink);
            redirectAttributes.addFlashAttribute("message", "Drink updated successfully");

            return "redirect:/";
        }

        @GetMapping("/showEditDrinkForm/{id}")
        public String showEditDrinkForm(@PathVariable("id") Long id, Model model) {
            try {
                Drink drink = drinkService.getDrinkById(id);
                model.addAttribute("drink", drink);
                model.addAttribute("pageTitle", "Edit Drink Id:" + id);
                return "showEditDrinkForm";
            } catch (Exception e) {
                // Handle exception
                // You might want to add error handling logic or redirect to an error page
                return "redirect:/";
            }
        }



        @PostMapping("/updateDrink")
        public String updateDrink(@ModelAttribute("drink") Drink updatedDrink, RedirectAttributes redirectAttributes) {
            try {
                // Get the existing drink from the database by its ID
                Drink existingDrink = drinkService.getDrinkById(updatedDrink.getId());

                // Copy properties from updatedDrink to existingDrink
                BeanUtils.copyProperties(updatedDrink, existingDrink, "id", "created_at", "updated_at", "ingredients");

                // Save the updated drink
                drinkService.saveDrink(existingDrink);

                redirectAttributes.addFlashAttribute("message", "Drink updated successfully");
                return "redirect:/";
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("message", e.getMessage());
                return "redirect:/";
            }
        }




        @GetMapping("deleteDrink/{id}")
        public String deleteDrink(@PathVariable long id, RedirectAttributes redirectAttributes){
            drinkService.deleteDrinkById(id);
            redirectAttributes.addFlashAttribute("message", "Drink Deleted successfully");

            return "redirect:/";
        }
    }