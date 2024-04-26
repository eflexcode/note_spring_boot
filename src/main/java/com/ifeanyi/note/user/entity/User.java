package com.ifeanyi.note.user.entity;

import com.ifeanyi.note.note.entity.Note;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @Size(min = 8)
    private String password;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @OneToMany(mappedBy ="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Note> notes;

    @Column(name = "created_at",updatable = false)
    @CreationTimestamp
    private Date createAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

}
