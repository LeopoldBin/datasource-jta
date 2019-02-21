package cn.leopold.service.impl;

import cn.leopold.entity.SimpleUser;
import cn.leopold.mapper.first.SimpleUserMapper;
import cn.leopold.service.ISimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author: Leopold
 * @date: 2019/2/19 11:58
 */
@Service
@Primary
public class SimpleUserServiceImpl implements ISimpleUserService {

    @Autowired
    private SimpleUserMapper simpleUserMapper;

    @Override
    public void save(SimpleUser entity) {
        simpleUserMapper.insert(entity);
    }
}
