package com.amir.Diploma.repositories;

import com.amir.Diploma.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findAll();
    List<Message> findMessageByUserId(Long userId);
    List<Message> findMessageByDoctorId(Long docId);
}
