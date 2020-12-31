package com.myleshen.notes.controller;


import com.myleshen.notes.dao.NotesDao;
import com.myleshen.notes.service.NotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/notes")
public class NotesController {

    private final Logger logger = LoggerFactory.getLogger(NotesController.class);

    private final NotesService notesService;

    @Autowired
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping("/save")
    public String save(@RequestBody NotesDao notesDao) {
        this.notesService.saveNote(notesDao);
        return "Notes/EntitySaved";
    }
}