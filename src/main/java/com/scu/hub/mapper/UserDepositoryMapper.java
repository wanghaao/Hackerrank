package com.scu.hub.mapper;

import com.scu.hub.entity.Depository;
import com.scu.hub.entity.UserDepository;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDepositoryMapper {
    @Select("SELECT * FROM depository WHERE depository_id  in\n" +
            "(SELECT  depository_id FROM user_depository WHERE user_id = #{userId})")
    public List<Depository> getDepossitoryByUserId(@Param("userId") String userId);

    @Select("SELECT  * FROM user_depository WHERE user_id = #{userId} ")
    public List<UserDepository> getUserDepoByUserId(@Param("userId") String userId);

    @Select("SELECT  depository_id FROM user_depository WHERE user_id = #{userId} AND role_id=0")
    public List<Integer> getUserOwnerDepoByUserId(@Param("userId") String userId);


    @Select("SELECT * FROM user_depository WHERE user_id =#{userId} AND depository_id=#{depositoryId}")
    public UserDepository getUserDepositoryByUserIdAndDeId(@Param("userId") String userId,
                                                           @Param("depositoryId") Integer depositoryId);

    @Select("SELECT * FROM user_depository WHERE depository_id=#{depositoryId}")
    public List<UserDepository> getUserDepoByDepositoryId(@Param("depositoryId") Integer depositoryId);

    /***
     * 插入一条新的数据，除去主键外，全部为默认值
     * @param userId
     * @param depositoryId
     * @return
     */
    @Insert("INSERT into user_depository(user_id,depository_id) VALUES(#{userId},#{depositoryId})")
    public Integer inserUserDepository(@Param("userId") String userId,
                                       @Param("depositoryId") Integer depositoryId);

    /**
     * 更新角色
     *
     * @param roleId
     * @param userId
     * @param depositoryId
     * @return
     */
    @Update("UPDATE user_depository SET role_id = #{roleId} WHERE user_id=#{userId} AND depository_id=#{depositoryId}")
    public Integer updateRole(@Param("roleId") Integer roleId,
                              @Param("userId") String userId,
                              @Param("depositoryId") Integer depositoryId);

    /**
     * 添加点赞
     *
     * @param thumbsUp
     * @param userId
     * @param depositoryId
     * @return
     */
    @Update("UPDATE user_depository SET thumbs_up = #{thumbsUp} WHERE user_id=#{userId} AND depository_id=#{depositoryId}")
    public Integer updateThumbsUp(@Param("thumbsUp") boolean thumbsUp,
                                  @Param("userId") String userId,
                                  @Param("depositoryId") Integer depositoryId);


    /**
     * 添加收藏
     *
     * @param collection
     * @param userId
     * @param depositoryId
     * @return
     */
    @Update("UPDATE user_depository SET collection = #{collection} WHERE user_id=#{userId} AND depository_id=#{depositoryId}")
    public Integer updateCollection(@Param("collection") boolean collection,
                                    @Param("userId") String userId,
                                    @Param("depositoryId") Integer depositoryId);


    @Select("SELECT COUNT(*) as number from user_depository WHERE depository_id = #{depositoryId}  AND thumbs_up =1")
    public Integer getDepositoryThumsUpNumber(@Param("depositoryId") Integer depositoryId);

    @Select("SELECT COUNT(*) as number from user_depository WHERE depository_id = #{depositoryId}  AND collection =1")
    public Integer getDepositoryCollectionNumber(@Param("depositoryId") Integer depositoryId);

}
