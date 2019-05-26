package com.scu.hub.mapper;

import com.scu.hub.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    public List<User> getallUser();

}
