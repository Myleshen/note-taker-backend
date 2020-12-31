package com.myleshen.notes.entity;

import com.myleshen.notes.dao.NotesDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Note")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotesEntity {

    @Id
    private int id;
    private String titleOfNote;
    private String contentOfNote;

    public NotesEntity(NotesDao notesDao) {
        this.id = notesDao.getId();
        this.titleOfNote = notesDao.getTitleOfNote();
        this.contentOfNote = notesDao.getContentOfNote();
    }

}
