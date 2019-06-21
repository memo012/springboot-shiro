package com.qiang.service.impl;

import com.qiang.mapper.UseMapper;
import com.qiang.mapper.UserMapper;
import com.qiang.model.User;
import com.qiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: qiang
 * @ProjectName: adminsystem
 * @Package: com.qiang.service.impl
 * @Description:
 * @Date: 2019/6/20 0020 11:26
 **/
@Service
public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private UseMapper useMapper;

    @Override
    public User findByUsername(String username) {
        User sel = useMapper.selByName(username);
        return sel;
    }
}
