package com.sun.hellospringboot.controller;

import com.sun.hellospringboot.bean.GoodsDo;
import com.sun.hellospringboot.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 通过该注解，第一是将GoodsController注册为控制器，可以响应Http请求；第二是可以将控制器中的方法返回值序列化为json格式。
public class GoodsController {
    @Autowired // 自动装配goodsService
    private GoodsService goodsService;

    /**
     * 查询商品信息
     * 1、@GetMapping表示可以使用get方法请求该api
     * 2、"/goods/{id}"表示请求路径为/goods/{id}的形式，其中{id}为占位符
     * 3、@PathVariable("id")表示将占位符{id}的值传递给id
     * 4、也就是说/goods/123请求的话，会将123传递给参数id
     */
    @GetMapping("/goods/{id}")
    public GoodsDo getOne(@PathVariable("id") long id) {
        return goodsService.getGoodsById(id);
    }

    /**
     * 查询商品列表，使用get方法
     */
    @GetMapping("/goods")
    public List<GoodsDo> getList() {
        return goodsService.getGoodsList();
    }

    /**
     * 新增商品
     * 1、@PostMapping表示使用post方法
     * 2、@RequestBody表示将请求中的json信息转换为GoodsDo类型的对象信息，该转换也是由SpringMVC自动完成的
     * {
     *                 "id" : 2 ,
     *                 "name" : "pingguo",
     *                 "price" : 12,
     *                 "pic'" : "pic"
     *                 }
     */
    @PostMapping("/goods")
    public String add(@RequestBody GoodsDo goods) {
        goodsService.addGoods(goods);
        System.out.println("post 新增");
        return "{result=\" 新增成功 \"}";
    }

    /**
     * 修改商品
     */
    @PutMapping("/goods/{id}")
    public String update(@PathVariable("id") long id, @RequestBody GoodsDo goods) {
        // 修改指定id的商品信息
        goods.setId(id);
        goodsService.editGoods(goods);
        System.out.println("Updata id=" + id);
        return "{result=\" 更新成功 \"}";
    }

    /**
     * 删除商品
     */
    @DeleteMapping("/goods/{id}")
    public String delete(@PathVariable("id") long id) {
        goodsService.removeGoods(id);
        System.out.println("delete id=" + id);
        return "{result=\" 删除成功 \"}";
    }
}
