package com.example.simpleviralgames.crud.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.simpleviralgames.crud.model.GameModel;

/**
 * This interface defines the CRUD operations for GameModel in MongoDB database.
 * It extends the MongoRepository interface to inherit the default
 * implementation.
 * for CRUD operations provided by Spring Data MongoDB.
 */
public interface GameRepository extends MongoRepository<GameModel, String> {
}
