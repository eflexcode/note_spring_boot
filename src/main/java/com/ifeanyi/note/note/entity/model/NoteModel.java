package com.ifeanyi.note.note.entity.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class NoteModel {

    private Long ownerId;// this is not note id
    private String title;
    private String coverImageUrl;
    private String body;

}
