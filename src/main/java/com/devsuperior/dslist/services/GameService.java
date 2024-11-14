package com.devsuperior.dslist.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;



@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game entity = gameRepository.findById(id).get();
        return new GameDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> list = gameRepository.findAll();
        return list.stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
    }

}
