package com.ifeanyi.note.note.service;

import com.ifeanyi.note.exception.NotFountException;
import com.ifeanyi.note.note.entity.Note;
import com.ifeanyi.note.note.entity.model.NoteModel;
import com.ifeanyi.note.note.repository.NoteRepository;
import com.ifeanyi.note.user.entity.User;
import com.ifeanyi.note.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
@Data
public class NoteServiceImpl implements NoteService{

    private NoteRepository noteRepository;
    private UserService userService;

    @Override
    public Note createNote(NoteModel noteModel) throws NotFountException {
        Note note = new Note();
        BeanUtils.copyProperties(noteModel,note);
        User user = userService.getUser(noteModel.getOwnerId());
        note.setUser(user);

        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(NoteModel noteModel, Long noteId) throws NotFountException {

        Note note = getNote(noteId);

        note.setTitle(noteModel.getTitle() != null ? noteModel.getTitle() : note.getTitle());
        note.setBody(noteModel.getCoverImageUrl() != null ? noteModel.getCoverImageUrl() : note.getCoverImageUrl());
        note.setTitle(noteModel.getBody() != null ? noteModel.getBody() : note.getBody());

        if (noteModel.getOwnerId() != null) {
            User user = userService.getUser(noteModel.getOwnerId());
            note.setUser(user);
            note.setOwnerId(noteModel.getOwnerId() != null ? noteModel.getOwnerId() : note.getOwnerId());
        }
        return noteRepository.save(note);
    }

    @Override
    public Note getNote(Long noteId) throws NotFountException {
        return noteRepository.findById(noteId).orElseThrow(()-> new NotFountException("No note found with id: "+noteId));
    }

    @Override
    public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }
}
