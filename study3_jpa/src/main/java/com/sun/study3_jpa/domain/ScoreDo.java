package com.sun.study3_jpa.domain;

import javax.persistence.*;

/**
 * 商品类
 */
@Entity // 表示这是一个数据对象类
@Table(name = "table_scorerank")
public class ScoreDo {
    /**
     * 商品id
     */
    @Id // 该字段对应数据库中的列为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增长
    @Column(name = "id") // 对应goods表中的id列
    private long id=0;
    /**
     * 商品名称
     */
    @Column(name = "year") // 对应goods表中的name列
    private int year;
    /**
     * 商品价格
     */
    @Column(name = "privince") // 对应goods表中的price列
    private String privince;
    /**
     * 商品图片
     */
    @Column(name = "type") // 对应goods表中的pic列
    private int type;

    @Column(name = "score") // 对应goods表中的pic列
    private int score;

    @Column(name = "pnum") // 对应goods表中的pic列
    private int pnum;

    @Column(name = "prank") // 对应goods表中的pic列
    private int prank;


    public ScoreDo(int year, String privince, int type, int score, int pnum, int prank) {
        this.year = year;
        this.privince = privince;
        this.type = type;
        this.score = score;
        this.pnum = pnum;
        this.prank = prank;
    }

    public ScoreDo() {
    }
}
