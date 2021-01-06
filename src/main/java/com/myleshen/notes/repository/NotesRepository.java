package com.myleshen.notes.repository;

import com.myleshen.notes.entity.NotesEntity;
import com.myleshen.notes.security.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface NotesRepository extends JpaRepository<NotesEntity, UUID> {

    List<NotesEntity> findAllByUserEntity(UserEntity userEntity);

}
