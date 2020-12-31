package com.myleshen.notes.service;

import com.myleshen.notes.dao.NotesDao;
import com.myleshen.notes.entity.NotesEntity;
import com.myleshen.notes.repository.NotesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesService {

    private final Logger logger = LoggerFactory.getLogger(NotesService.class);
    private final NotesRepository notesRepository;

    @Autowired
    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public String saveNote(NotesDao notesDao) {
        NotesEntity notesEntity = new NotesEntity(notesDao);
        this.notesRepository.save(notesEntity);
        return "Success";
    }
}
