package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
            SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
            tb_game.short_description AS shortDescription, tb_belonging.position
            FROM tb_game
            INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
            WHERE tb_belonging.list_id = :listId
            ORDER BY tb_belonging.position
                """)
    List<GameMinProjection> searchByList(Long listId);

    @Modifying
    @Query(nativeQuery = true,
    value = "DELETE FROM tb_game WHERE id = :id")
    void deleteGameById(Long id);

    @Modifying
    @Query(nativeQuery = true,
    value = "UPDATE tb_game SET title = :title, game_year = :gameYear, score = :score, img_url = :imgUrl, short_description = :shortDescription, genre = :genre, long_description = :long_description, platforms = :platforms WHERE id = :id")
    void updateGame(Long id, String title, Integer year, String genre, String platform, Double score, String imgUrl,
    String shortDescription, String longDescription);
}

