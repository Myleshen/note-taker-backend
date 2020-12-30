package com.myleshen.notes.service;

import com.myleshen.notes.dao.NoteDao;
import com.myleshen.notes.entity.NoteEntity;
import com.myleshen.notes.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private final Logger logger = LoggerFactory.getLogger(NoteService.class);
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public String saveNote(NoteDao noteDao) {
        NoteEntity noteEntity = new NoteEntity(noteDao);
        this.noteRepository.save(noteEntity);
        return "Success";
    }
}
