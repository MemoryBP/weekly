package com.example.demo.dao;


import com.example.demo.model.Weekly;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by CGQ-PC on 2017/7/7.
 */
public interface WeeklyDao extends JpaRepository<Weekly,Integer> {
    List<Weekly> findById(long id);
}
