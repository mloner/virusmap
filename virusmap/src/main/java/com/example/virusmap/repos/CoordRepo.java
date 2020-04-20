package com.example.virusmap.repos;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.virusmap.domain.Coord;
import com.example.virusmap.domain.Message;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CoordRepo extends CrudRepository<Coord, Long> {

    Iterable<Coord> findAll(Sort createTime);
    
    @Transactional
    long deleteByLatlng(String latlng);
    
}