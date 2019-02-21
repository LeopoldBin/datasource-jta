package cn.leopold.service;

import cn.leopold.entity.SimpleRole;
import cn.leopold.entity.SimpleUser;

public interface ITestService {

    void batchSave(SimpleUser simpleUser, SimpleRole simpleRole);
}
