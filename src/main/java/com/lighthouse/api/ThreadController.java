package com.lighthouse.api;

import com.lighthouse.dao.RoleRepository;
import com.lighthouse.dao.UserRepository;
import com.lighthouse.entity.Role;
import com.lighthouse.entity.UserEntity;
import com.lighthouse.service.ThreadTest;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/huhan")
public class ThreadController {

    ThreadTest threadTest;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    // http://127.0.0.1:8080/user/123/roles/222
    @PostMapping(value = "/thread/test/{username}")
    @ResponseBody
    public String getLogin(@PathVariable("username") String username) {
        //新建线程
        ThreadTest threadTest1 = new ThreadTest("线程A",roleRepository);
        ThreadTest threadTest2 = new ThreadTest("线程B",roleRepository);

        Thread myth1 = new Thread(threadTest1);
        Thread myth2 = new Thread(threadTest2);

        myth1.start();
        myth2.start();

        return "User Id : "   + username;
    }

}
