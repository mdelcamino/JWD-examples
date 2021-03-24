package com.udacity.jdnd.c1.review.mapper;

import com.udacity.jdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    // messageid;
    // username;
    // messageText;
    @Select("SELECT * FROM MESSAGES WHERE username = #{username}")
    List<ChatMessage> getAllMessages (String username);
    @Insert(" INSERT INTO MESSAGES (username, messageText) " +
            "VALUES(#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int insert(ChatMessage chatMessage);

}
