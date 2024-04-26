package com.ifeanyi.note.note.controller;

import com.ifeanyi.note.exception.NotFountException;
import com.ifeanyi.note.note.entity.Note;
import com.ifeanyi.note.note.entity.model.NoteModel;
import com.ifeanyi.note.note.service.NoteService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/note")
@Data
public class NoteController  {

    private NoteService noteService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Note createNote(@RequestBody NoteModel noteModel) throws NotFountException {
        return noteService.createNote(noteModel);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Note updateNote(@RequestBody NoteModel noteModel,@RequestParam(name = "note_id") Long noteId) throws NotFountException {
        return noteService.updateNote(noteModel,noteId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Note getNote(@RequestParam(name = "note_id")Long noteId) throws NotFountException {
        return noteService.getNote(noteId);
    }

    @GetMapping("/query")
    @ResponseStatus(HttpStatus.OK)
    public List<Note> getNoteByOwnerId(@RequestParam(name = "user_id")Long userId, Pageable pageable) throws NotFountException {
        return noteService.getNoteByOwnerId(userId, pageable).toList();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteNote(@RequestParam(name = "note_id")Long noteId) {
        noteService.deleteNote(noteId);
    }
}
