package com.lighthouse.api;

import com.lighthouse.dao.RoleRepository;
import com.lighthouse.dao.UserRepository;
import com.lighthouse.entity.Role;
import com.lighthouse.service.ThreadTest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

@Controller
@RequestMapping("/huhan")
public class ThreadController {

    ThreadTest threadTest;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    // http://127.0.0.1:8080/user/123/roles/222
    @ApiOperation("Runnable实现方式")
    @PostMapping(value = "/thread/test/{username}")
    @ResponseBody
    public String getLogin(@PathVariable("username") String username) {
        //新建线程
        ThreadTest threadTest1 = new ThreadTest("线程A",roleRepository);
        ThreadTest threadTest2 = new ThreadTest("线程B",roleRepository);

        Thread myth1 = new Thread(threadTest1);
        Thread myth2 = new Thread(threadTest2);

        System.out.println(ThreadController.class.toGenericString().compareTo("萨达")+"比较完成");
        myth1.start();
        myth2.start();


        return "User Id : "   + username;
    }

    // http://127.0.0.1:8080/user/123/roles/222
    @ApiOperation("callable实现方式")
    @PostMapping(value = "/thread/callable")
    @ResponseBody
    public Object callable() throws ExecutionException, InterruptedException {
        FutureTask<Role> futureTask = null;
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            System.out.println("正在解析主线程"+i+System.currentTimeMillis());
            FutureTask<Role> finalFutureTask = futureTask;
            futureTask = new FutureTask<Role>((Callable<Role>)()->{
                finalFutureTask.get(10,TimeUnit.SECONDS);
                Role role = new Role();
                role.setName("callable");
                return roleRepository.save(role);
            });
                FutureTask<Role> futureTask1 = new FutureTask<Role>((Callable<Role>)()->{
                    Role role =  new Role();
                    role.setName("potato1008");
                    return roleRepository.save(role);
                });
            Thread thread = new Thread(futureTask);
            Thread thread1 = new Thread(futureTask1);
            thread1.start();
            thread1.join();
            thread.join();
            thread.start();
            Thread.sleep(1000);
            System.out.println(futureTask.get().toString()+"地址值为"+futureTask.get().hashCode());
            System.out.println(futureTask1.get().toString()+"酷炫地址值为"+futureTask.get().hashCode());
            list.add(futureTask.get().toString());
            list.add(futureTask1.get().toString());
        }
        return list;
    }

    // http://127.0.0.1:8080/user/123/roles/222
    @ApiOperation("join的用途")
    @PostMapping(value = "/thread/join")
    @ResponseBody
    public Object threadJoin() throws InterruptedException {
        Thread t1 = new Thread(()->{
            Role role = new Role();
            role.setName("t1");
            try {
                Thread.sleep(5_000L);
                System.out.println("M1" + "数据采集结束，花费时间:" + 5_000L);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.setName("M1");
        Thread t2 = new Thread(()->{
            Role role = new Role();
            role.setName("t2");

            try {
                Thread.sleep(10_000L);
                System.out.println("M2" + "数据采集结束，花费时间:" + 10_000L);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.setName("M2");
        Thread t3 = new Thread(()->{
            Role role = new Role();
            role.setName("t3");

            try {
                Thread.sleep(20_000L);
                System.out.println("M3" + "数据采集结束，花费时间:" + 20_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.setName("M3");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        return null;
    }

}
