package com.myleshen.notes.controller;


import com.myleshen.notes.dao.NoteDao;
import com.myleshen.notes.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("/")
public class NoteController {

    private Logger logger = LoggerFactory.getLogger(NoteController.class);

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("save")
    public ResponseEntity save(@RequestBody NoteDao noteDao) {
        Optional<Integer> id = Optional.of(noteDao.getId());
        id.ifPresent(integer -> {
            int newId = new Random().nextInt();
            if (newId < 0) {
                newId = -newId;
            }
            noteDao.setId(newId);
        });
        this.noteService.saveNote(noteDao);
        return new ResponseEntity(HttpStatus.OK);
    }
}
