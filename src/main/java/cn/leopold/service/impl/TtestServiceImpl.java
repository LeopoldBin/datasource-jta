package cn.leopold.service.impl;

import cn.leopold.entity.SimpleRole;
import cn.leopold.entity.SimpleUser;
import cn.leopold.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Primary
public class TtestServiceImpl implements ITestService {

    @Autowired
    private ISimpleUserService simpleUserService;


    @Autowired
    private ISimpleRoleService simpleRoleService;

    @Override
    @Transactional(rollbackFor = {Exception.class, SQLException.class})
    public void batchSave( SimpleUser simpleUser, SimpleRole simpleRole) {
        simpleUserService.save(simpleUser);
        simpleRoleService.save(simpleRole);
        int b = 10 / 0;
    }
}
