package com.myleshen.notes.service;

import com.myleshen.notes.entity.NotesEntity;
import com.myleshen.notes.repository.NotesRepository;
import com.myleshen.notes.security.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    private final Logger logger = LoggerFactory.getLogger(NotesService.class);
    private final NotesRepository notesRepository;

    @Autowired
    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public void saveNote(NotesEntity notesEntity) {
        this.notesRepository.save(notesEntity);
    }

    public List<NotesEntity> getAllNotes(UserEntity userEntity) {
        return this.notesRepository.findAllByUserEntity(userEntity);
    }

}
