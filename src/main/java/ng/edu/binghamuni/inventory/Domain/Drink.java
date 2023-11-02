package ng.edu.binghamuni.inventory.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name="drink")
public class Drink {public List<Ingredient> getIngredientList() {
    return ingredientList;
}

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public Drink(String name, int capacity, String colour, String type, String company, List<Ingredient> ingredientList, Long id) {
        this.name = name;
        this.capacity = capacity;
        this.colour = colour;
        this.type = type;
        this.company = company;
        this.ingredientList = ingredientList;
        this.id = id;
    }

    private String name;
    private int capacity;
    private String colour;
    private String type;
    private String company;

    @OneToMany
    private List<Ingredient> ingredientList;
    @Id
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public Drink() {

    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}