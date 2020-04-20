package com.example.virusmap;

import com.example.virusmap.domain.Coord;
import com.example.virusmap.repos.CoordRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CoordRepo coordRepo;
//    @PostMapping("filter")
//    public String filter(@RequestParam String filter, Map<String, Object> model){
//        Iterable<Message> messages;
//        if(filter != null && !filter.isEmpty())
//            messages = messageRepo.findByTag(filter);
//        else
//            messages = messageRepo.findAll();
//        model.put("messages", messages);
//        return "main.html";
//    }

    @GetMapping("api/allcoords")
    public String allCoords(Map<String, Object> model){
        Iterable<Coord> coords = coordRepo.findAll();
        model.put("coords", coords);
        return "coords";
    }
/*
//    @RequestMapping("api/allcoords_ajax")
//    @ResponseBody
//    public String allCoords_ajax(Map<String, Object> model){
//        Iterable<Coord> coords = coordRepo.findAll();
//
//        model.put("coords", coords);
//        //List<String> vals = new List<String>()
//
//        return "allcoords_ajax";
//    }
    */

    @GetMapping("api/allcoords2")
    public String allCoordsFormated(Map<String, Object> model){
        Iterable<Coord> coords = coordRepo.findAll(Sort.by(Sort.Direction.DESC, "createTime"));
        model.put("coords", coords);
        return "coordsFormated";
    }

//    @GetMapping("api/addCoord")
//    public String addCoord(
//    		@RequestParam(name="latlng",
//    				      required=false,
//    					  defaultValue="48.00000000000000;44.00000000000000")
//    		String latlng,Map<String, Object> model){
//        LocalDateTime today = LocalDateTime.now();
//        Coord coord = new Coord(latlng, today);
//        coordRepo.save(coord);
//        return "success";
//    }


    @GetMapping("map")
    public String test(Map<String, Object> model){
        Iterable<Coord> coords = coordRepo.findAll();

        model.put("coords", coords);
        return "map";
    }

    @GetMapping("api/clear")
    public String clear(Map<String, Object> model){
        coordRepo.deleteAll();
        return "success";
    }
    
    @GetMapping("api/addCoord")
    public String addCoord(
    		@RequestParam(name="latlng",
    				      required=false,
    					  defaultValue="48.00000000000000;44.00000000000000")
    		String latlng,Map<String, Object> model){
        LocalDateTime today = LocalDateTime.now();
        long n = coordRepo.deleteByLatlng(latlng);
        Coord coord = new Coord(latlng, today);  
        coordRepo.save(coord);
        return "success";
    }
}




