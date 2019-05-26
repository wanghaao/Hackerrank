package com.scu.hub.controller;

import com.scu.hub.controller.enumInfo.ResponseStatus;
import com.scu.hub.entity.Depository;
import com.scu.hub.entity.User;
import com.scu.hub.entity.UserDepository;
import com.scu.hub.mapper.DepositoryMapper;
import com.scu.hub.mapper.UserDepositoryMapper;
import com.scu.hub.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.*;

import java.util.List;

@Controller
public class LogInOrRegisterController {

    @Resource
    UserMapper userMapper;

    @Resource
    UserDepositoryMapper userDepositoryMapper;

    @Resource
    DepositoryMapper depositoryMapper;

    /***
     * 登陆界面--主登陆界面
     * @return 跳转到主界面
     */
    @GetMapping("/login/page")
    private String loginPage() {
        return "login";
    }

    /**
     * 注册信息
     *
     * @param username 用户名
     * @param password 密码
     * @return 注册结果
     */
    @PostMapping("/register/information")
    @ResponseBody
    private Integer register(@RequestParam("userId") String userId,
                             @RequestParam("username") String username,
                             @RequestParam("password") String password) {

        User user = userMapper.getUserById(userId);
        if (user == null) {
            try {
                return userMapper.insertUser(userId, username, password);
            }catch (Exception e){
                return ResponseStatus.FAIL;
            }
        } else {
            return ResponseStatus.FAIL;
        }
    }


    /***
     * 登陆密码验证
     * @param userId 用户名
     * @param password 密码
     * @return 验证结果
     */
    @PostMapping("/login/verify")
    @ResponseBody
    private Integer verifyUser(HttpServletRequest request,
                               @RequestParam("userId") String userId,
                               @RequestParam("password") String password) {
        User user = userMapper.getUserById(userId);
        if (user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user);
            return ResponseStatus.SUCCESS;
        } else
            return ResponseStatus.FAIL;
    }

    /**
     * 个人信息界面
     * @param request
     * @param userId
     * @return 仓库的基本信息和个人基本信息
     */
    @PostMapping("/userInfo")
    @ResponseBody
    private String personalInfoPage(HttpServletRequest request,
                                    @RequestParam("userId") String userId) {
        User user = userMapper.getUserById(userId);
        List<UserDepository> userDepositories = userDepositoryMapper.getUserDepoByUserId(userId);

        JSONArray jsonArray = new JSONArray();
        for (UserDepository userDepository : userDepositories) {
            int privilege= userDepository.getRoleId();
            Depository depository =
                    depositoryMapper.getDepositoryById(userDepository.getDepositoryId());

            int collectionNumber = userDepositoryMapper.getDepositoryCollectionNumber(depository.getDepositoryId());
            int thumbsUpNumber = userDepositoryMapper.getDepositoryThumsUpNumber(depository.getDepositoryId());

            JSONObject jsonObject = new JSONObject();
            JSONObject depositoryObject = JSONObject.fromObject(depository.toString());
            jsonObject.put("privilege",privilege);
            jsonObject.put("collectionNumber",collectionNumber);
            jsonObject.put("thumbsUpNumber",thumbsUpNumber);
            jsonObject.put("depository",depositoryObject);
            jsonArray.add(jsonObject);
        }
        JSONObject userObject = JSONObject.fromObject(user.toString());

        JSONObject result = new JSONObject();
        result.put("user",userObject);
        result.put("depositories",jsonArray);
        return result.toString();
    }

}
