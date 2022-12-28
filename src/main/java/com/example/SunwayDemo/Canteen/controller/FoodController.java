package com.example.SunwayDemo.Canteen.controller;

import com.example.SunwayDemo.Canteen.common.FoodDto;
import com.example.SunwayDemo.Canteen.entity.Food;
import com.example.SunwayDemo.Canteen.service.FoodService;
import com.example.SunwayDemo.Canteen.util.RestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = RestApi.FoodSection.FOOD_URL)
public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> CreateFoods(@Valid @RequestBody FoodDto foodDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(foodService.CreateFood(foodDto));
    }
    @GetMapping(path = "/list")
    public ResponseEntity<?> getAllFood(){
        return new  ResponseEntity<>(foodService.getAllFood(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getFoodById(@PathVariable Integer id){
        return new ResponseEntity<>(foodService.getFoodById(id),HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<?> deleteFoodById(@PathVariable Integer id){
        return new ResponseEntity<>(foodService.deleteFoodById(id), HttpStatus.OK);
    }
    @PutMapping(path = "{id}/update")
    public ResponseEntity<?> updateFoodById(@PathVariable Integer id, @RequestBody FoodDto foodDto){
        return new ResponseEntity<>(foodService.UpdateFoodById(id, foodDto), HttpStatus.OK);
    }
}
