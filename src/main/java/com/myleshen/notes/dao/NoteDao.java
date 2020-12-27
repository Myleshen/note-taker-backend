package com.myleshen.notes.dao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myleshen.notes.entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDao {

    @JsonIgnore
    private int id;
    private String titleOfNote;
    private String contentOfNote;

    public NoteDao(NoteEntity noteEntity) {
        this.id = noteEntity.getId();
        this.titleOfNote = noteEntity.getTitleOfNote();
        this.contentOfNote = noteEntity.getContentOfNote();
    }

}
