package com.scu.hub.mapper;

import com.scu.hub.entity.Depository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepositoryMapper {

    @Select("SELECT * FROM depository WHERE depository_id = #{id}")
    public Depository getDepositoryById(@Param("id") Integer id);

    @Insert("INSERT depository(depository_id," +
            "depository_name," +
            "depository_visiable," +
            "depository_like," +
            "depository_collection," +
            "depository_classification_id," +
            "tags)\n" +
            "VALUES(#{depositoryId},#{depositoryName}," +
            "#{depositoryVisible},0,0," +
            "#{depositoryClassificationId},#{tags})")
    public Integer insertDepository(@Param("depositoryId") Integer depositoryId,
                                    @Param("depositoryName") String depositoryName,
                                    @Param("depositoryVisible") Boolean depositoryVisible,
                                    @Param("depositoryClassificationId") Integer depositoryClassificationId,
                                    @Param("tags") String tags);

    @Select("SELECT MAX(depository.depository_id) as max_id FROM depository;")
    public Integer getMaxId();

}
