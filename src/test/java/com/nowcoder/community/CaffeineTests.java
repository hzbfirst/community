package com.nowcoder.community;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.service.DiscussPostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class CaffeineTests {

    @Autowired
    private DiscussPostService postService;

    @Test
    public void initDataForTest() {
        for (int i = 0; i < 300000; i++) {
            DiscussPost post = new DiscussPost();
            post.setUserId(111);
            post.setTitle("C语言从入门到精通");
            post.setContent("出售二手课本包括语言类：C/C++ 选择谭浩强的，比较经典。 数据库方面：《数据库系统概论（第4版)》 高教版，王珊等编 。数据结构方面： 《数据结构》，清华严蔚敏版 。当然还有《计算机组成原理》 (唐朔飞，高教版)。《计算机系统结构》（西电的就可以）。《计算机操作系统(第 三 版)》 西电（作者忘记了）。 学有余力的话，可以看经典教材。《操作系统设计与实现（第三版）》陈渝 译电子工业出版社等。");
            post.setCreateTime(new Date());
            post.setScore(Math.random() * 2000);
            postService.addDiscussPost(post);
        }
    }

    @Test
    public void testCache() {
        System.out.println(postService.findDiscussPosts(0, 0, 10, 1));
        System.out.println(postService.findDiscussPosts(0, 0, 10, 1));
        System.out.println(postService.findDiscussPosts(0, 0, 10, 1));
        System.out.println(postService.findDiscussPosts(0, 0, 10, 0));
    }

}
