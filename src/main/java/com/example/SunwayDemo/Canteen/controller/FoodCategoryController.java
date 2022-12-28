package com.example.SunwayDemo.Canteen.controller;

import com.example.SunwayDemo.Canteen.entity.FoodCategory;
import com.example.SunwayDemo.Canteen.service.FoodCategoryService;
import com.example.SunwayDemo.Canteen.util.RestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = RestApi.FoodSection.FOOD_CATEGORY)
public class FoodCategoryController {
    @Autowired
    private FoodCategoryService foodCategoryService;


    @PostMapping(path = "/create")
    public ResponseEntity<?> CreateFoodCategory(@RequestBody FoodCategory foodCategory){
        return new ResponseEntity<>(foodCategoryService.CreateFoodCategory(foodCategory), HttpStatus.OK);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> getAllFoodCategory(){return new ResponseEntity<>(foodCategoryService.getAllFoodCategory(), HttpStatus.OK);}

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getFoodCategoryById(@PathVariable Integer id){
        return new ResponseEntity<>(foodCategoryService.getFoodCategoryById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<?> deleteFoodCategoryById(@PathVariable Integer id){
        return new ResponseEntity<>(foodCategoryService.deleteFoodCategoryById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/{id}/update")
    public ResponseEntity<?> updateFoodCategory(@PathVariable Integer id, @RequestBody FoodCategory foodCategory){
        return new ResponseEntity<>(foodCategoryService.updateFoodCategoryById(id, foodCategory), HttpStatus.OK);
    }

}
