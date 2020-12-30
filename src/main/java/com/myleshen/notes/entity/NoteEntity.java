package com.myleshen.notes.entity;

import com.myleshen.notes.dao.NoteDao;
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
public class NoteEntity {

    @Id
    private int id;
    private String titleOfNote;
    private String contentOfNote;

    public NoteEntity(NoteDao noteDao) {
        this.id = noteDao.getId();
        this.titleOfNote = noteDao.getTitleOfNote();
        this.contentOfNote = noteDao.getContentOfNote();
    }

}
