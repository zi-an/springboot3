package spring.boot.database;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select id, name, pwd from user")
    List<UserEntity> getUsers();

    @Insert("insert into user (name,pwd) values (#{name},#{pwd}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertOne(UserEntity user);
}
