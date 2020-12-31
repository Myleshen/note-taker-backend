package com.myleshen.notes.repository;

import com.myleshen.notes.entity.NotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotesRepository extends JpaRepository<NotesEntity, Integer> {
}
