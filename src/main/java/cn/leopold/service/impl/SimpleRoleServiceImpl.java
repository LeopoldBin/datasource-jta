package cn.leopold.service.impl;

import cn.leopold.entity.SimpleRole;
import cn.leopold.mapper.second.SimpleRoleMapper;
import cn.leopold.service.ISimpleRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleRoleServiceImpl implements ISimpleRoleService {

    @Autowired
    private SimpleRoleMapper simpleRoleMapper;

    @Override
    public void save(SimpleRole simpleRole) {
        simpleRoleMapper.insert(simpleRole);
    }
}
