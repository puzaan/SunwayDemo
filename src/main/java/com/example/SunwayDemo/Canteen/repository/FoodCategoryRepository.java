package com.example.SunwayDemo.Canteen.repository;

import com.example.SunwayDemo.Canteen.entity.foodCategoryEntity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Integer> {

    //@Query(value = "SELECT fc FROM FoodCategory fc WHERE fc.isActive = true")
            //@Query(nativeQuery = true, value = "SELECT  * from food_category where is_active = true")
    //function name query
    List<FoodCategory> findFoodCategoriesByIsActive(Boolean isActive);
}
