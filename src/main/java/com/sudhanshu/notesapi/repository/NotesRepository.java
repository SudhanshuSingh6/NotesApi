package com.sudhanshu.notesapi.repository;

import com.sudhanshu.notesapi.model.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotesRepository extends MongoRepository<Notes,String> {
     List<Notes> findByUsername(String username);
}