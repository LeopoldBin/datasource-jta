package cn.leopold;

import static org.junit.Assert.assertTrue;

import cn.leopold.entity.SimpleRole;
import cn.leopold.entity.SimpleUser;
import cn.leopold.service.ITestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    @Autowired
    private ITestService testService;

    @Test
    public void test() {

        SimpleUser simpleUser = new SimpleUser();
        simpleUser.setUsername("bin1");
        simpleUser.setPassword("111");


        SimpleRole simpleRole = new SimpleRole();
        simpleRole.setName("superadmin");
        testService.batchSave(simpleUser,simpleRole);
    }
}
