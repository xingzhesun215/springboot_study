package com.sun.study2_druid.dao;

import com.sun.study2_druid.domain.GoodsDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 商品数据库访问类
 */
@Repository // 标注数据访问类
public class GoodsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 新增
     */
    public void insert(GoodsDo goods) {
        jdbcTemplate.update("insert into goods(name,price,pic)values(?,?,?)", goods.getName(), goods.getPrice(),
                goods.getPic());
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        jdbcTemplate.update("delete from goods where id =?", id);
    }

    /**
     * 更新
     */
    public void update(GoodsDo goods) {
        jdbcTemplate.update("update goods set name=?,price=?,pic=? where id=?", goods.getName(), goods.getPrice(),
                goods.getPic(), goods.getId());
    }

    /**
     * 按id查询
     */
    public GoodsDo getById(Long id) {
        return jdbcTemplate.queryForObject("select * from goods where id=?", new RowMapper<GoodsDo>() {
            @Override
            public GoodsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
                GoodsDo goods = new GoodsDo();
                goods.setId(rs.getLong("id"));
                goods.setName(rs.getString("name"));
                goods.setPrice(rs.getString("price"));
                goods.setPic(rs.getString("pic"));
                return goods;
            }
        }, id);
    }

    /**
     * 查询商品列表
     */
    public List<GoodsDo> getList(int size) {
        return jdbcTemplate.query("select * from goods LIMIT "+size, new RowMapper<GoodsDo>() {
            @Override
            public GoodsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
                GoodsDo goods = new GoodsDo();
                goods.setId(rs.getLong("id"));
                goods.setName(rs.getString("name"));
                goods.setPrice(rs.getString("price"));
                goods.setPic(rs.getString("pic"));
                return goods;
            }
        });
    }
}
