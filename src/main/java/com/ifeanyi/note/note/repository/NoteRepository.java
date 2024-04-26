package com.ifeanyi.note.note.repository;

import com.ifeanyi.note.note.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {

     Page<Note> findByOwnerId(Long ownerId, Pageable pageable);

}
