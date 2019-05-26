package com.scu.hub.controller;

import com.scu.hub.entity.Depository;
import com.scu.hub.mapper.DepositoryMapper;
import com.scu.hub.mapper.UserDepositoryMapper;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLException;

@RestController
@RequestMapping("/depository")
public class DepositoryController {

    @Resource
    DepositoryMapper depositoryMapper;

    @Resource
    UserDepositoryMapper userDepositoryMapper;

    /**
     * 获取某个用户的全部仓库
     *
     * @return
     */
    private String getUserDepository() {
        /**
         * 使用session获取当前登陆用户的信息，
         * 查询用户，返回仓库信息
         */
        return "仓库信息";
    }

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

        int id = depositoryMapper.getMaxId() + 1;

        try {
            Integer statusOfInsertDepository = depositoryMapper.insertDepository(id,
                    depositoryName, depositoryVisible, depositoryClassificationId, tags);
            Integer statusOfInsertUserDepository = userDepositoryMapper.insertUserDepository(depositoryOwnerId, id, 0);
        }catch (Exception e){
            e.printStackTrace();
            return "0";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("depositoryId",id);
        jsonObject.put("status",1);
        return jsonObject.toString();
    }

    /**
     * 关键字查询仓库信息
     *
     * @param keyword
     * @return
     */
    @PostMapping("/findDepository")
    private String findDepository(@RequestParam("keywords") String keyword) {
        return "findOK";
    }

    /**
     * 添加仓库的参与人员
     *
     * @param userId
     * @return
     */
    @PostMapping("/addDepositoryUser")
    private String addDepositoryUser(@RequestParam("user_id") String userId) {
        return "addDepositoryUser ok";
    }


    /**
     * 点赞
     *
     * @param depositoryId
     * @return
     */
    @PostMapping("/depositoryLike")
    private String depositoryLike(@RequestParam("depository_id") String depositoryId) {
        return "das";
    }

    /**
     * 收藏
     *
     * @param depository_id 仓库的id
     * @return 收藏的结果
     */
    @PostMapping("/collection")
    private String depositoryCollection(@RequestParam("depository_id") String depository_id) {
        return "collection";
    }
}
