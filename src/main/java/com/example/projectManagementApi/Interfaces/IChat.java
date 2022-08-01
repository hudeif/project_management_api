package com.example.projectManagementApi.Interfaces;

import com.example.projectManagementApi.Models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChat extends JpaRepository<Chat,Integer> {
    @Query(value = "select * from chat where sender_id=?1 and receiver_id=?2 or sender_id=?2 and receiver_id=?1 order by id",nativeQuery = true)
    List<Chat> getChat(String senderId,String receiverId);
}
