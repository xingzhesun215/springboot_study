package com.sun.study4_mybatis.controller;

import com.sun.study4_mybatis.dao.GoodsDao;
import com.sun.study4_mybatis.domain.GoodsDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping("/goods")
public class GoodsController {


    @Autowired
    private GoodsDao goodsDao;


    @ResponseBody
    @GetMapping("/goods")
    public List<GoodsDo> list() {
        return goodsDao.selectAll();
    }

    @ResponseBody
    @GetMapping("/goods/{id}")
    public GoodsDo listone(@PathVariable("id") long id) {
        System.out.println("id=" + id);
        return goodsDao.selectOne(id);
    }

    @ResponseBody
    @PostMapping("/goods")
    public String add(@RequestBody GoodsDo goodsDo) {
        goodsDao.insert(goodsDo);
        return "{result:\"success\"}";
    }

    @ResponseBody
    @PutMapping("/goods/{id}")
    public String add(@PathVariable("id") int id, @RequestBody GoodsDo newGoods) {
        GoodsDo goods = goodsDao.selectOne((long) id);
        if (goods == null) {
            return "{result:\"fail null\"}";
        } else {
            goods.setName(newGoods.getName());
            goods.setPic(newGoods.getPic());
            goods.setPrice(newGoods.getPrice());
            goodsDao.update(goods);
            return "{result:\"success\"}";
        }
    }

    @ResponseBody
    @DeleteMapping("/goods/{id}")
    public String delete(@PathVariable("id") int id) {
        System.out.println("id="+id);
        GoodsDo goods = goodsDao.selectOne((long) id);
        if (goods == null) {
            return "{result:\"null\"}";
        } else {
            goodsDao.delete((long) id);
            return "{result:\"success\"}";
        }
    }
}
