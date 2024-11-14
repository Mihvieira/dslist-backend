package com.devsuperior.dslist.dto;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.devsuperior.dslist.entities.Game;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

public class GameDTO {

    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO() {
    }

    public GameDTO(Game entity){
        BeanUtils.copyProperties(entity, entity, getClass());
    }
        
}
