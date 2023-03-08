package com.sun.study3_jpa.dao;

import com.sun.study3_jpa.domain.ScoreDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 商品数据操作接口
 */
@Repository
public interface IScoreDao extends CrudRepository<ScoreDo, Long> {
}
