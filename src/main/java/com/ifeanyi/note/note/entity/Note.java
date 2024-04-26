package com.ifeanyi.note.note.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ifeanyi.note.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "note")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long id;
    @Column(name = "owner_id")
    private Long ownerId;
    private String title;
    @Column(name = "cover_image_url")
    private String coverImageUrl;

    private String body;// this is going to be htlm dont know how to do it yet
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "created_at",updatable = false)
    @CreationTimestamp
    private Date createAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

}
