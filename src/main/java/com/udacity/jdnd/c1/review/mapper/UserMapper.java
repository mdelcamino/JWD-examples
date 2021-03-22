package com.udacity.jdnd.c1.review.mapper;

import com.udacity.jdnd.c1.review.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT EXISTS(SELECT 1 FROM USERS WHERE username = #{username})")
    boolean getUserName(@Param("username") String username);
/*@Select("SELECT EXISTS(SELECT 1 FROM my_table WHERE email=#{email})")
boolean checkUserExists(@Param("email") String email);*/
    @Select("SELECT * FROM USERS WHERE username= #{username}")
    User getUser(String username);

    @Insert(" INSERT INTO USERS VALUES (userid, username, password, salt, surname, lastname)" +
            "VALUES(#{userid}, #{username}, #{password}) , #{salt}, #{surname}, #{lastname})")
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    int insert(User user);

}
