package com.lighthouse.service;

import com.lighthouse.Util.SpringContextUtil;
import com.lighthouse.dao.RoleRepository;
import com.lighthouse.dao.UserRepository;
import com.lighthouse.entity.Role;
import com.lighthouse.entity.UserEntity;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;

public class ThreadTest implements Runnable {


    String threadName;

    BasicService basicService;

    @Resource
    UserRepository userRepository;


    public ThreadTest(String threadName,RoleRepository roleRepository) {
        this.threadName = threadName;
    }

    @Override
    public void run() {

        double upTime;
        long startTime=System.currentTimeMillis(); //获取开始时间
        if (threadName.equals("线程A")){
            for (Integer i = 0; i<1000000000; i++){
                int A = 0;
                int B = A++;
            }
        }
        long endTime=System.currentTimeMillis(); //获取结束时间
        upTime = new BigDecimal(endTime-startTime).divide(new BigDecimal(1000)).doubleValue();//耗时(秒)

        System.out.println(upTime);
        System.out.println("线程"+threadName+"运行");
        System.out.println("----------------------------------");
        RoleRepository roleRepository = SpringContextUtil.getBean(RoleRepository.class);
        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.notNull(role.getId(),"ID不能为null");
    }


}
