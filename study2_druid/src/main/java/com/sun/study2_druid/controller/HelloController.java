package com.sun.study2_druid.controller;

import com.sun.study2_druid.dao.GoodsDao;
import com.sun.study2_druid.domain.GoodsDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;


@Controller
public class HelloController {


    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Springboot!!!   hello";
    }


    @Autowired
    private DataSource dataSource;// 自动注入数据源

    @Autowired
    private GoodsDao goodsDao;

    /**
     * 打印数据源信息
     */
    void printDataSource() {
        System.out.println(dataSource);
    }

    /**
     * 批量插入测试
     */
    void insertBatch() {
        // 开始时间
        long startTime = System.currentTimeMillis();
        // 执行1000次插入
        GoodsDo goods = new GoodsDo();
        goods.setName("测试");
        goods.setPic("测试图片");
        goods.setPrice("1.0");
        for (int i = 0; i < 10; i++) {
            goodsDao.insert(goods);
        }
        // 输出操作时间
        System.out.println("use time:" + (System.currentTimeMillis() - startTime) + "ms");
    }

}
