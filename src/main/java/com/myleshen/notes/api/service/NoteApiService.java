package com.myleshen.notes.api.service;

import com.myleshen.notes.entity.NotesEntity;
import com.myleshen.notes.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteApiService {

    private final NotesRepository notesRepository;

    @Autowired
    public NoteApiService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }


    public List<NotesEntity> getAllNotes() {
        return notesRepository.findAll();
    }


    public void saveSingleNote(NotesEntity notesEntity) {
        notesRepository.save(notesEntity);
    }


    public void saveMultipleNotes(List<NotesEntity> notesEntityList) {
        notesRepository.saveAll(notesEntityList);
    }

}
