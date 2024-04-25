package com.ifeanyi.note.note.service;


import com.ifeanyi.note.note.entity.Note;
import com.ifeanyi.note.note.entity.model.NoteModel;

public interface NoteService {

    Note createNote(NoteModel noteModel);
    Note updateNote(NoteModel noteModel,Long noteId);
    Note getNote(Long noteId);
    void deleteNote(Long noteId);

}
