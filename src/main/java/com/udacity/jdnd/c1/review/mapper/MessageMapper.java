package com.udacity.jdnd.c1.review.mapper;

import com.udacity.jdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageMapper {
    // messageid;
    // username;
    // messageText;
    @Select("SELECT * FROM MESSAGES WHERE username = #{username}")
    ChatMessage getAllMessages (String username);
    @Insert(" INSERT INTO MESSAGES VALUES (messageid, username, messageText)" +
            "VALUES(#{messageid}, #{username}, #{messageText}))")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int insert(ChatMessage chatMessage);

}
