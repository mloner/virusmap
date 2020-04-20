package com.example.virusmap.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class Coord {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String latlng;
    private LocalDateTime createTime;

    public Coord() {
    }

    public Coord(String latlng, LocalDateTime createTime){
        this.latlng = latlng;
        this.createTime = createTime;
    }

    public String getLatlng() {
        return latlng;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }


}
