package com.scu.hub.mapper;

import com.scu.hub.entity.Depository;
import com.scu.hub.entity.User;
import com.scu.hub.entity.UserDepository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDepositoryMapper {
    @Select("SELECT * FROM depository WHERE depository_id  in\n" +
            "(SELECT  depository_id FROM user_depository WHERE user_id = #{userId})")
    public List<Depository> getDepossitoryByUserId(@Param("userId")String userId);

    @Select("SELECT  * FROM user_depository WHERE user_id = #{userId} ")
    public List<UserDepository> getUserDepoByUserId(@Param("userId")String userId);

    @Insert("INSERT into user_depository VALUES (#{userId},#{depositoryId},#{privilege})")
    public Integer insertUserDepository(@Param("userId")String userId,
                                        @Param("depositoryId")Integer depositoryId,
                                        @Param("privilege")Integer privilege);
}
