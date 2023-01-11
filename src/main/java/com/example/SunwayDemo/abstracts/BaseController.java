package com.example.SunwayDemo.abstracts;


import com.example.SunwayDemo.config.CustomMessageSource;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    protected CustomMessageSource messageSource;
    protected String moduleName;
}
