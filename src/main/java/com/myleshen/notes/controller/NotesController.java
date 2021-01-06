package com.myleshen.notes.controller;


import com.myleshen.notes.entity.NotesEntity;
import com.myleshen.notes.security.service.UserService;
import com.myleshen.notes.service.NotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;


@Controller
@RequestMapping("/notes/")
public class NotesController {

    private final Logger logger = LoggerFactory.getLogger(NotesController.class);

    private final NotesService notesService;
    private final UserService userService;

    @Autowired
    public NotesController(NotesService notesService, UserService userService) {
        this.notesService = notesService;
        this.userService = userService;
    }

    @GetMapping("dashboard")
    public String getAll(Model model) {
        model.addAttribute("notes", this.notesService.getAllNotes());
        return "Notes/NotesDashboard";
    }

    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public String save(
            @ModelAttribute("NotesEntity") NotesEntity notesEntity,
            @CurrentSecurityContext(expression = "authentication")
            Authentication authentication) {
        notesEntity.setId(UUID.randomUUID());
        notesEntity.setUserEntity(userService.findByUserName(authentication.getName()));
        this.notesService.saveNote(notesEntity);
        return "Notes/EntitySaved";
    }

    @GetMapping("create")
    public String createNote(Model model, @CurrentSecurityContext(expression =
            "authentication")
    Authentication authentication ) {
        logger.info("User is Logged In " + authentication.getName());
        model.addAttribute("NotesEntity", new NotesEntity());
        return "Notes/CreateNote";
    }

}