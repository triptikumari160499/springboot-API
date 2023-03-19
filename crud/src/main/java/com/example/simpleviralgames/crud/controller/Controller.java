package com.example.simpleviralgames.crud.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleviralgames.crud.model.GameModel;
import com.example.simpleviralgames.crud.respository.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/**
 * The Controller class defines REST endpoints for the "game" resource and use
 * the database to perform CRUD operations on the "game" collection.
 * This class also defines exception handling methods for handling different
 * types of exceptions that may occur during API requests.
 */

@RestController
@RequestMapping("/api/games")
public class Controller {

    /**
     * The GameRepository interface is used to interact with the database and
     * perform CRUD operations on the "game" collection.
     */
    @Autowired
    private GameRepository gameRepository;

    /**
     * This method handles HTTP GET requests for retrieving all games.
     * 
     * @return a ResponseEntity with a list of GameModel objects in the body.
     */
    @GetMapping
    public ResponseEntity<List<GameModel>> getAllGames() {
        List<GameModel> games = gameRepository.findAll();
        if (games.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(games);
    }

    /**
     * This method handles HTTP GET requests for retrieving a game by id .
     * 
     * @param id The id of the game to retrieve
     * @return a ResponseEntity with a GameModel object in the body
     */
    @GetMapping("/{id}")
    public ResponseEntity<GameModel> getGameById(@PathVariable String id) {
        Optional<GameModel> game = gameRepository.findById(id);
        if (!game.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(game.get());
    }

    /**
     * This method handles HTTP POST requests for creating a new game.
     * 
     * @param game The GameModel object to create
     * @return a ResponseEntity with the created GameModel object in the body
     */

    @PostMapping
    public ResponseEntity<GameModel> createGame(@RequestBody GameModel game) {
        if (game.getId() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(gameRepository.save(game));
    }

    /**
     * This method handles HTTP PUT requests to Update a game with the specified ID.
     * 
     * @param id   The ID of the game to update.
     * @param game The new game data to replace the old game data.
     * @return
     */

    @PutMapping("/{id}")
    public ResponseEntity<GameModel> updateGame(@PathVariable String id, @RequestBody GameModel game) {
        Optional<GameModel> existingGame = gameRepository.findById(id);
        if (!existingGame.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        game.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(gameRepository.save(game));
    }

    /**
     * Deletes a game with the specified ID.
     * 
     * @param id The ID of the game for delete.
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable String id) {
        Optional<GameModel> game = gameRepository.findById(id);
        if (!game.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        gameRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted id successfully: " + id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private void handleBadRequest(Exception ex) {
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private void handleInternalServerError(Exception ex) {
    }
}
