package com.example.SunwayDemo.Canteen.repository;

import com.example.SunwayDemo.Canteen.entity.foodEntity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM food fi inner join food_category fc on fc.id = fi.food_category_id where fc.short_name = ?1")
    List<Food> findByFoodCategoryShortName(String foodCategoryShortName);
}
