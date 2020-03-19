package com.paradise.all4me.mapper;
import org.apache.ibatis.annotations.Param;

import com.paradise.all4me.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Mybatis Generator 2020/03/06
 * @author Paradise
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectOneByTelephone(@Param("telephone")String telephone);

    User selectOneByEmail(@Param("email")String email);



}