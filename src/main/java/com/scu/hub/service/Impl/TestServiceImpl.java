package com.scu.hub.service.Impl;

import com.scu.hub.service.TestService;
import com.scu.hub.entity.User;
import com.scu.hub.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    TestMapper mapper;

    @Override
    public List<User> getallUser() {
        return mapper.getallUser();
    }
}
