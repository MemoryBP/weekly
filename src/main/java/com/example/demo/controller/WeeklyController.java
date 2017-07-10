package com.example.demo.controller;

import com.example.demo.dao.WeeklyDao;
import com.example.demo.model.Weekly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by CGQ-PC on 2017/7/7.
 */
@RestController
public class WeeklyController {
    @Autowired
    private WeeklyDao weeklyDao;
    @GetMapping(value = "/get/{id}")
    public Object getMsg(@PathVariable("id") Long id){
        Object object= weeklyDao.findById(id);
        return object;
    }
}
