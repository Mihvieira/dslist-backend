package com.devsuperior.dslist.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

import jakarta.persistence.EntityNotFoundException;



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

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        return list.stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByTitle(String title) {
        List<GameMinProjection> list = gameRepository.findByTitle(title);
        return list.stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        gameRepository.deleteById(id);
    }

    
    @Transactional
    public GameDTO create(GameDTO gameDTO) {
        Game game = new Game();
        game.setTitle(gameDTO.getTitle());
        game.setGenre(gameDTO.getGenre());
        game.setPlatforms(gameDTO.getPlatforms());
        game.setYear(gameDTO.getYear());
        game.setGenre(gameDTO.getGenre());
        game.setImgUrl(gameDTO.getImgUrl());
        game.setLongDescription(gameDTO.getLongDescription());
        game.setScore(gameDTO.getScore());
        game.setShortDescription(gameDTO.getShortDescription());
        game = gameRepository.save(game);
        return new GameDTO(game);
    }

    @Transactional
    public GameDTO update(Long id, GameDTO gameDTO) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            game.setTitle(gameDTO.getTitle());
            game.setGenre(gameDTO.getGenre());
            game.setPlatforms(gameDTO.getPlatforms());
            game.setYear(gameDTO.getYear());
            game.setImgUrl(gameDTO.getImgUrl());
            game.setLongDescription(gameDTO.getLongDescription());
            game.setScore(gameDTO.getScore());
            game.setShortDescription(gameDTO.getShortDescription());
            game = gameRepository.save(game);
            return new GameDTO(game);
        } else {
            // Lidar com o caso onde o jogo não foi encontrado
            throw new EntityNotFoundException("Game not found with id " + id);
            }
        }
    
    
}
