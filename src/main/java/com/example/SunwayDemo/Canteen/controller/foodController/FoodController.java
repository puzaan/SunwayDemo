package com.example.SunwayDemo.Canteen.controller.foodController;

import com.example.SunwayDemo.Canteen.dto.foodDto.FoodDto;
import com.example.SunwayDemo.Canteen.service.foodService.FoodServiceImp;
import com.example.SunwayDemo.Canteen.util.RestApi;
import com.example.SunwayDemo.abstracts.BaseController;
import com.example.SunwayDemo.golbal.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = RestApi.FoodSection.FOOD_URL)
public class FoodController extends BaseController {
    @Autowired
    private final FoodServiceImp foodServiceImp;

    public FoodController(FoodServiceImp foodServiceImp) {
        this.foodServiceImp = foodServiceImp;
        this.moduleName = "Food Item";
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> CreateFoods(@Valid @RequestBody FoodDto foodDto) {
        foodDto = foodServiceImp.CreateFood(foodDto);
        return new ResponseEntity<>(new ApiResponse<>("Successfully created" + moduleName, true,foodDto ),HttpStatus.CREATED);
    }
    @GetMapping(path = "/list")
    public ResponseEntity<?> getAllFood(){
        ApiResponse<List<FoodDto>> foodItemsDtoApiResponse = new ApiResponse<>("successfully fetched food item's", true, foodServiceImp.getAllFood());
        return new  ResponseEntity<>(foodItemsDtoApiResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getFoodById(@PathVariable Integer id){
        return new ResponseEntity<>(new ApiResponse<>("successfully fetched  food Items", true, foodServiceImp.getFoodById(id)),HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<?> deleteFoodById(@PathVariable Integer id){
        foodServiceImp.deleteFoodById(id);
        return new ResponseEntity<>(new ApiResponse<>("Successfully deleted data of given id:  " + id, true), HttpStatus.OK);
    }
    @PutMapping(path = "{id}/update")
    public ResponseEntity<?> updateFoodById(@PathVariable Integer id, @RequestBody FoodDto foodDto){
        return new ResponseEntity<>(foodServiceImp.UpdateFoodById(id, foodDto), HttpStatus.OK);
    }
}
