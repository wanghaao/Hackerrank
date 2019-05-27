package com.scu.hub.controller;

import com.scu.hub.controller.enuminfo.DepositoryVisible;
import com.scu.hub.controller.enuminfo.Role;
import com.scu.hub.controller.enuminfo.ResponseStatus;
import com.scu.hub.entity.Depository;
import com.scu.hub.entity.User;
import com.scu.hub.entity.UserDepository;
import com.scu.hub.mapper.DepositoryMapper;
import com.scu.hub.mapper.UserDepositoryMapper;
import com.scu.hub.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/depository")
@Slf4j
public class DepositoryController {

    private final static String filePath = "C:\\allFiles";

    @Resource
    DepositoryMapper depositoryMapper;

    @Resource
    UserDepositoryMapper userDepositoryMapper;

    @Resource
    UserMapper userMapper;

    /**
     * 创建仓库
     *
     * @param depositoryName
     * @param depositoryOwnerId
     * @param depositoryVisible
     * @param depositoryClassificationId
     * @param tags
     * @return
     */
    @PostMapping("/create")
    private String createDepository(@RequestParam("depositoryName") String depositoryName,
                                    @RequestParam("depositoryOwnerId") String depositoryOwnerId,
                                    @RequestParam("depositoryVisible") Boolean depositoryVisible,
                                    @RequestParam("depositoryClassificationId") Integer depositoryClassificationId,
                                    @RequestParam("tags") String tags) {

        int depositoryId = depositoryMapper.getMaxId() + 1;
        JSONObject jsonObject = new JSONObject();
        try {
            //创建新仓库
            depositoryMapper.insertDepository(depositoryId, depositoryName, depositoryVisible, depositoryClassificationId, tags);
            //添加所有者
            userDepositoryMapper.inserUserDepository(depositoryOwnerId, depositoryId);
            userDepositoryMapper.updateRole(Role.OWNER, depositoryOwnerId, depositoryId);

            //创建文件夹
            File dir = new File(filePath+"\\"+depositoryName);
            if (!dir.exists()) {
                dir.mkdirs();
                jsonObject.put("filepathStatus","1");
            }else{
                jsonObject.put("filepathStatus","0");
            }
            jsonObject.put("depositoryId", depositoryId);
            jsonObject.put("status", ResponseStatus.SUCCESS);
        } catch (Exception e) {
            log.info("新仓库创建失败");
            jsonObject.put("status", ResponseStatus.FAIL);
        }
        return jsonObject.toString();
    }

    /**
     * 关键字查询仓库信息
     *
     * @param keyword
     * @return
     */
    @PostMapping("/keywordMatching")
    private List<Depository> keywordMatching(@RequestParam("keyword") String keyword) {
        return depositoryMapper.keywordMatching("%" + keyword + "%");
    }

    /**
     * 添加仓库的管理员
     *
     * @param userId
     * @return
     */
    @PostMapping("/addDepositoryManager")
    private Integer addDepositoryManager(@RequestParam("userId") String userId,
                                         @RequestParam("depositoryId") Integer depositoryId) {
        try {
            UserDepository userDepository = userDepositoryMapper.getUserDepositoryByUserIdAndDeId(userId, depositoryId);
            if (userDepository == null) {
                userDepositoryMapper.inserUserDepository(userId, depositoryId);
            }
            userDepositoryMapper.updateRole(Role.MANAGER, userId, depositoryId);
            userDepositoryMapper.updateCollection(true, userId, depositoryId);
            return ResponseStatus.SUCCESS;
        } catch (Exception e) {
            log.info("添加管理员出错");
        }
        return ResponseStatus.FAIL;
    }

    /**
     * 通过id获取仓库信息
     *
     * @param depositoryId
     * @return
     */
    @PostMapping("/getDepositoryById")
    private String getDepositoryById(@RequestParam("depositoryId") Integer depositoryId) {

        int collectionNumber = userDepositoryMapper.getDepositoryCollectionNumber(depositoryId);
        int thumbsUpNumber = userDepositoryMapper.getDepositoryThumsUpNumber(depositoryId);

        Depository depository = depositoryMapper.getDepositoryById(depositoryId);
        JSONObject depositoryJsonObject = JSONObject.fromObject(depository);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("collectionNumber", collectionNumber);
        jsonObject.put("thumbsUpNumber", thumbsUpNumber);
        jsonObject.put("depository", depositoryJsonObject);
        return jsonObject.toString();
    }

    /**
     * 设置仓库可见性
     *
     * @param visible
     * @param depositoryId
     * @return
     */
    @PostMapping("/setVisibleById")
    private Integer setVisibleById(@RequestParam("visible") String visible,
                                   @RequestParam("depositoryId") Integer depositoryId) {
        if (visible.equals("true")) {
            depositoryMapper.setVisibleById(DepositoryVisible.VISIBLE, depositoryId);
        } else {
            depositoryMapper.setVisibleById(DepositoryVisible.UNVISIBLE, depositoryId);
        }
        return ResponseStatus.SUCCESS;
    }


    /**
     * 点赞
     *
     * @param depositoryId
     * @return
     */
    @PostMapping("/depositoryThumbsUp")
    private Integer depositoryLike(@RequestParam("depositoryId") Integer depositoryId,
                                   @RequestParam("userId") String userId,
                                   @RequestParam("thumbsUp") boolean thumbsUp) {
        try {
            UserDepository userDepository = userDepositoryMapper.getUserDepositoryByUserIdAndDeId(userId, depositoryId);
            if (userDepository == null) {
                userDepositoryMapper.inserUserDepository(userId, depositoryId);
            }
            userDepositoryMapper.updateThumbsUp(thumbsUp, userId, depositoryId);
            return ResponseStatus.SUCCESS;
        } catch (Exception e) {
            log.info("点赞失败");
        }
        return ResponseStatus.FAIL;
    }

    /**
     * 添加一个仓库的协作者
     *
     * @param depositoryId
     * @param userId
     * @return
     */
    @PostMapping("/addDepositoryMember")
    private Integer addDepositoryMember(@Param("userId") String userId,
                                        @Param("depositoryId") Integer depositoryId) {

        try {
            UserDepository userDepository = userDepositoryMapper.getUserDepositoryByUserIdAndDeId(userId, depositoryId);
            if (userDepository == null) {
                userDepositoryMapper.inserUserDepository(userId, depositoryId);
            }
            userDepositoryMapper.updateRole(Role.PARTNER, userId, depositoryId);
            userDepositoryMapper.updateCollection(true, userId, depositoryId);
            return ResponseStatus.SUCCESS;
        } catch (Exception e) {
            log.info("添加协作者失败");
        }
        return ResponseStatus.FAIL;
    }

    /**
     * 收藏
     *
     * @param userId       用户Id
     * @param depositoryId 仓库id
     * @return
     */
    @PostMapping("/collection")
    private Integer depositoryCollection(@Param("userId") String userId,
                                         @Param("depositoryId") Integer depositoryId,
                                         @Param("collection") boolean collection) {
        try {
            UserDepository userDepository = userDepositoryMapper.getUserDepositoryByUserIdAndDeId(userId, depositoryId);
            if (userDepository == null) {
                userDepositoryMapper.inserUserDepository(userId, depositoryId);
            }
            userDepositoryMapper.updateCollection(collection, userId, depositoryId);
            return ResponseStatus.SUCCESS;
        } catch (Exception e) {
            log.info("收藏失败");
        }
        return ResponseStatus.FAIL;
    }


    @PostMapping("/getOwnerDepositorDetailInfo")
    private String getOwnerDepositoryDetailInfo(@RequestParam("userId") String userId) {
        List<Integer> depositoryIds = userDepositoryMapper.getUserOwnerDepoByUserId(userId);

        JSONArray jsonArray = new JSONArray();
        for (Integer depositoryId : depositoryIds) {
            JSONObject jsonObject = new JSONObject();
            JSONObject depositoryObject = JSONObject.fromObject(depositoryMapper.getDepositoryById(depositoryId));
            List<UserDepository> userDepositories =
                    userDepositoryMapper.getUserDepoByDepositoryId(depositoryId);
            JSONArray managerArray = new JSONArray();
            JSONArray partnerArray = new JSONArray();
            for (UserDepository userDepo : userDepositories) {
                User user = userMapper.getUserById(userDepo.getUserId());
                if (userDepo.getRoleId() == Role.MANAGER) {
                    managerArray.add(JSONObject.fromObject(user.toString()));
                }else if(userDepo.getRoleId()==Role.PARTNER){
                    partnerArray.add(JSONObject.fromObject(user.toString()));
                }
            }
            jsonObject.put("depositoryInfo",depositoryObject);
            jsonObject.put("manager",managerArray);
            jsonObject.put("partner",partnerArray);
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }
}

