package com.sudhanshu.notesapi.controller;

import com.sudhanshu.notesapi.model.Notes;
import com.sudhanshu.notesapi.model.User;
import com.sudhanshu.notesapi.repository.NotesRepository;
import com.sudhanshu.notesapi.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class NotesController {
    private UserRepository userRepository;
    private NotesRepository notesRepository;
    public NotesController(UserRepository userRepository, NotesRepository notesRepository) {
        this.userRepository = userRepository;
        this.notesRepository = notesRepository;
    }
    @GetMapping("/{userId}/notes")
    public List<Notes> getallnotes(@PathVariable String userId){
        return notesRepository.findByUsername(userId);
    }
    @PostMapping("/{userId}/notes")
    public void addNote(@PathVariable String userId, @RequestBody String noteRequest){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Notes notes = new Notes();
        notes.setId("1");
        notes.setNote(noteRequest);
        notesRepository.save(notes);
        userRepository.save(user);
    }
    @DeleteMapping("{userId}/notes/{noteId}")
    public void deleteNote(@PathVariable String userId,@PathVariable String noteId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Notes notes = notesRepository.findById(noteId).orElseThrow(() -> new NoSuchElementException());
        notesRepository.delete(notes);
    }
    @PutMapping("/{userId}/notes/{noteId}")
    public void updateNote( @PathVariable String userId,@PathVariable String noteId, @RequestBody String note){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Notes notes = notesRepository.findById(noteId).orElseThrow(() -> new NoSuchElementException());
        notes.setNote(note);
        notesRepository.save(notes);
    }
}
