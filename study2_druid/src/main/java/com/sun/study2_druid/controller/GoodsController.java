package com.sun.study2_druid.controller;

import com.sun.study2_druid.dao.GoodsDao;
import com.sun.study2_druid.domain.GoodsDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/goods")
public class GoodsController {


    @Autowired
    private GoodsDao goodsDao;


    @ResponseBody
    @GetMapping("/list")
    public List<GoodsDo> list(@RequestParam int size) {
        System.out.println("size=" + size);
        return goodsDao.getList(size);
    }

    @ResponseBody
    @GetMapping("/list/{id}")
    public GoodsDo listone(@PathVariable("id") long id) {
        System.out.println("id=" + id);
        return goodsDao.getById(id);
    }

    @ResponseBody
    @PostMapping("/add")
    public String add(@RequestBody GoodsDo goodsDo) {
        goodsDao.insert(goodsDo);
        return "{result:\"success\"}";
    }

    @ResponseBody
    @PutMapping("/updata")
    public String add(@RequestParam int id, @RequestBody GoodsDo newGoods) {
        GoodsDo goods = goodsDao.getById((long) id);
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
    @DeleteMapping("/delete")
    public String delete(@RequestParam int id) {
        System.out.println("id="+id);
        GoodsDo goods = goodsDao.getById((long) id);
        if (goods == null) {
            return "{result:\"null\"}";
        } else {
            goodsDao.delete((long) id);
            return "{result:\"success\"}";
        }
    }
}
