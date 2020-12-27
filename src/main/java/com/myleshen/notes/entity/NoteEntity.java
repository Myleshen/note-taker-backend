package com.myleshen.notes.entity;

import com.myleshen.notes.dao.NoteDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
    @Column(name = "id")
    private int id;

    @Column(name = "TITLEOFNOTE")
    private String titleOfNote;

    @Column(name = "CONTENTOFNOTE")
    private String contentOfNote;

    public NoteEntity(NoteDao noteDao) {
        this.id = noteDao.getId();
        this.titleOfNote = noteDao.getTitleOfNote();
        this.contentOfNote = noteDao.getContentOfNote();
    }

}
