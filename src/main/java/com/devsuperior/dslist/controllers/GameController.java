package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findAll(@PathVariable Long id){
        GameDTO list = gameService.findById(id);
        return list;
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> list = gameService.findAll();
        return list;
    }
    
}
