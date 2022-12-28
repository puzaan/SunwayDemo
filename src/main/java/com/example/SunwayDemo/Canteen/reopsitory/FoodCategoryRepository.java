package com.example.SunwayDemo.Canteen.reopsitory;

import com.example.SunwayDemo.Canteen.entity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Integer> {
}
