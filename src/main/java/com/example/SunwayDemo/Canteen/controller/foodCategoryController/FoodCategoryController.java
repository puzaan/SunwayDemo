package com.example.SunwayDemo.Canteen.controller.foodCategoryController;

import com.example.SunwayDemo.Canteen.dto.foodCategoryDto.FoodCategoryDto;
import com.example.SunwayDemo.Canteen.service.foodCetogaryService.FoodCategoryServiceImp;
import com.example.SunwayDemo.Canteen.util.RestApi;
import com.example.SunwayDemo.abstracts.BaseController;
import com.example.SunwayDemo.golbal.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = RestApi.FoodSection.FOOD_CATEGORY)
public class FoodCategoryController extends BaseController {
    @Autowired
    private final FoodCategoryServiceImp foodCategoryServiceImp;

    public FoodCategoryController(FoodCategoryServiceImp foodCategoryServiceImp) {
        this.foodCategoryServiceImp = foodCategoryServiceImp;
        this.moduleName = "Food Category";
    }


    @PostMapping(path = "/create")
    public ResponseEntity<?> CreateFoodCategory(@RequestBody FoodCategoryDto foodCategoryDto){
        foodCategoryDto = foodCategoryServiceImp.CreateFoodCategory(foodCategoryDto);
        return new ResponseEntity<>(new ApiResponse<>("Successfully created food",true,foodCategoryDto),
                HttpStatus.CREATED);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> getAllFoodCategory(){
        ApiResponse<List<FoodCategoryDto>> FoodCategoryDto = new ApiResponse<>("Successfully fetched food category items", true,foodCategoryServiceImp.getAllFoodCategory() );
        return new ResponseEntity<>(FoodCategoryDto, HttpStatus.OK);}

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getFoodCategoryById(@PathVariable Integer id){
        return new ResponseEntity<>(new ApiResponse<>("Successfully fetched data of given id: " + id, true,foodCategoryServiceImp.getFoodCategoryById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete")
    public ResponseEntity<?> deleteFoodCategoryById(@PathVariable Integer id){
        foodCategoryServiceImp.deleteFoodCategoryById(id);
        return new ResponseEntity<>(new ApiResponse<>("Successfully deleted data of given id: " + id, true), HttpStatus.OK);
    }

    @PostMapping(path = "/{id}/update")
    public ResponseEntity<?> updateFoodCategory(@PathVariable Integer id, @RequestBody FoodCategoryDto foodCategoryDto){
        return new ResponseEntity<>(new ApiResponse<>("Successfully data updated  of given id: " + id, true, foodCategoryServiceImp.updateFoodCategoryById(id, foodCategoryDto)) , HttpStatus.OK);
    }

}
