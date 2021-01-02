package com.myleshen.notes.entity;

import com.myleshen.notes.api.dao.NotesDao;
import com.myleshen.notes.security.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Table(name = "Note")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotesEntity {

    @Id
    private UUID id;
    private String titleOfNote;
    private String contentOfNote;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public NotesEntity(NotesDao notesDao) {
        this.id = notesDao.getId();
        this.titleOfNote = notesDao.getTitleOfNote();
        this.contentOfNote = notesDao.getContentOfNote();
    }

}
