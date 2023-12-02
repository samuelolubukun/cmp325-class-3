package ng.edu.binghamuni.inventory.repository;

import ng.edu.binghamuni.inventory.Domain.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink,Long> {
//    Drink(type); Long(id type)
//    you can also write your own custom query using: @Query("")
//    List<Drink> findDrinkByPriceGreaterThan(int price);

//    this repositpry helps us interact with our database
}
