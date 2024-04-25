package com.ifeanyi.note.note.service;

import com.ifeanyi.note.note.entity.Note;
import com.ifeanyi.note.note.entity.model.NoteModel;
import com.ifeanyi.note.note.repository.NoteRepository;
import com.ifeanyi.note.user.entity.User;
import com.ifeanyi.note.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Data
public class NoteServiceImpl implements NoteService{

    private NoteRepository noteRepository;
    private UserService userService;

    @Override
    public Note createNote(NoteModel noteModel) {
        Note note = new Note();
        BeanUtils.copyProperties(noteModel,note);
        User user = userService.getUser(noteModel.getOwnerId());
        note.setUser(user);

        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(NoteModel noteModel, Long noteId) {



        return null;
    }

    @Override
    public Note getNote(Long noteId) {
        return null;
    }

    @Override
    public void deleteNote(Long noteId) {

    }
}
