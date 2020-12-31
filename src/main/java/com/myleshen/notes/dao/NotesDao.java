package com.myleshen.notes.dao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myleshen.notes.entity.NotesEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotesDao {

    @JsonIgnore
    private int id;
    private String titleOfNote;
    private String contentOfNote;

    public NotesDao(NotesEntity notesEntity) {
        this.id = notesEntity.getId();
        this.titleOfNote = notesEntity.getTitleOfNote();
        this.contentOfNote = notesEntity.getContentOfNote();
    }

}