package com.sun.study3_jpa.domain;


import java.io.Serializable;

/**
 * 商品类
 */
public class ScoreDoS implements Serializable {

    private int score;
    private int pnum;
    private int prank;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public int getPrank() {
        return prank;
    }

    public void setPrank(int prank) {
        this.prank = prank;
    }

    @Override
    public String toString() {
        return "ScoreDoS{" +
                "score=" + score +
                ", pnum=" + pnum +
                ", prank=" + prank +
                '}';
    }
}
