package com.sun.study3_jpa.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.study3_jpa.domain.GoodsDo;
import com.sun.study3_jpa.domain.ScoreDo;
import com.sun.study3_jpa.domain.ScoreDoS;
import com.sun.study3_jpa.service.GoodsService;
import com.sun.study3_jpa.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品控制器类
 */
@RestController
public class ScoreController {
    @Autowired
    private ScoreService goodsService;

    /**
     * 新增商品
     */
    @GetMapping("/score/app")
    public List<ScoreDoS> addAll() throws Exception {


        String jsonStr="";
        Gson gson = new Gson();
        List<ScoreDoS> list = gson.fromJson(jsonStr, new TypeToken<List<ScoreDoS>>() {
        }.getType());


        for (ScoreDoS bean : list) {
            ScoreDo sd = new ScoreDo(2022, "jiangxi", 2, bean.getScore(), bean.getPnum(), bean.getPrank());
            System.out.println("2022 li科 " + bean.getScore());
            goodsService.add(sd);
        }
        return list;
    }

    /**
     * 编辑商品
     */
    @PutMapping("/score/{id}")
    public void update(@PathVariable("id") long id, @RequestBody GoodsDo goods) {
        // 修改指定id的博客信息
        goods.setId(id);
    }

    /**
     * 移除商品
     */
    @DeleteMapping("/score/{id}")
    public void delete(@PathVariable("id") long id) {
        goodsService.remove(id);
    }
}
