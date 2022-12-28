package com.example.SunwayDemo.Canteen.util;

public class RestApi {
    public static final String BASE_URL = "/api/v1";

    public static class FoodSection{
        public static final String FOOD_URL = RestApi.BASE_URL + "/food";
        public static final String FOOD_CATEGORY = FOOD_URL + "/category";

    }
}
