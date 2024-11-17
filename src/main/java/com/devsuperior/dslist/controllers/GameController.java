package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;


@RestController
@RequestMapping(value = "/games")
public class GameController {

/**
 * GameController é responsável por gerenciar as requisições HTTP relacionadas aos jogos.
 * Ele fornece endpoints para buscar informações detalhadas de um jogo específico e para listar todos os jogos.
 */

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

    @PostMapping
    public ResponseEntity<GameDTO> create(@RequestBody GameDTO gameDTO, UriComponentsBuilder uriBuilder) {
        GameDTO createdGame = gameService.create(gameDTO);
        var uri = uriBuilder.path("/games/{id}").buildAndExpand(createdGame.getId()).toUri();
        return ResponseEntity.created(uri).body(createdGame);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GameDTO> update(@PathVariable Long id, @RequestBody GameDTO gameDTO) {
        GameDTO updatedGame = gameService.update(id, gameDTO);
        return ResponseEntity.ok(updatedGame);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        gameService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
