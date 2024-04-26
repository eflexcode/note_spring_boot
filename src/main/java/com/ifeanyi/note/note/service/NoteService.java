package com.ifeanyi.note.note.service;


import com.ifeanyi.note.exception.NotFountException;
import com.ifeanyi.note.note.entity.Note;
import com.ifeanyi.note.note.entity.model.NoteModel;

public interface NoteService {

    Note createNote(NoteModel noteModel) throws NotFountException;
    Note updateNote(NoteModel noteModel,Long noteId) throws NotFountException;
    Note getNote(Long noteId) throws NotFountException;
//    Note get
    void deleteNote(Long noteId);

}
