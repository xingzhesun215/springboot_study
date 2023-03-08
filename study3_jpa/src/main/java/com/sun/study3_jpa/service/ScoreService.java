package com.sun.study3_jpa.service;

import com.sun.study3_jpa.dao.IScoreDao;
import com.sun.study3_jpa.domain.ScoreDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 商品服务类
 */
@Service
public class ScoreService {
    @Autowired
    private IScoreDao goodsDao;

    /**
     * 新增商品
     */
    public void add(ScoreDo goods) {
        goodsDao.save(goods);
    }

    /**
     * 删除商品
     */
    public void remove(Long id) {
        goodsDao.deleteById(id);
    }

    /**
     * 编辑商品信息
     */
    public void edit(ScoreDo goods) {
        goodsDao.save(goods);
    }

    /**
     * 按id获取商品信息
     */
    public Optional<ScoreDo> getById(Long id) {
        return goodsDao.findById(id);
    }

    /**
     * 获取商品信息列表
     */
    public Iterable<ScoreDo> getList() {
        return goodsDao.findAll();
    }
}
