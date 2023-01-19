package com.example.SunwayDemo.Canteen.util;

public class RestApi {
    public static final String BASE_URL = "/api/v1";

    public static class FoodSection{
        public static final String FOOD_URL = RestApi.BASE_URL + "/food";
        public static final String FOOD_CATEGORY = FOOD_URL + "/category";

        public static final String FOD_ORDER = FOOD_URL+"/order";

    }
    public static class UserSection{
        public static final String FACULTY_URL = RestApi.BASE_URL + "/faculty";
        public static final String STUDENT_URL = RestApi.BASE_URL + "/student";

    }
    public static class FacultySection{
        public static final String FACULTY_URL = RestApi.BASE_URL + "/faculty";
        public static final String SUBJECT_URL = RestApi.BASE_URL + "/subject";

    }
}
