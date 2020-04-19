package com.example.sweater.repos;

import com.example.sweater.domain.Coord;
import com.example.sweater.domain.Message;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CoordRepo extends CrudRepository<Coord, Long> {

    Iterable<Coord> findAll(Sort createTime);
    
//    @Query("DELETE FROM coord WHERE NOT IN(" + 
//    		"  SELECT MAX(id) FROM coord GROUP BY create_time" + 
//    		")")
//    void deleteDublicates();


}