package com.telan.numbergame.game.domain;


import java.io.Serializable;
import java.util.List;

/**
 * Created by weiwenliang on 2017/6/16.
 */
public class FourArithmetic implements Serializable {
    private static final long serialVersionUID = 3642691792135772736L;
    private List<Integer> selectNumbers;
    private Integer targetNumber;
    private List<List<String>> formulaStack;

    public List<Integer> getSelectNumbers() {
        return selectNumbers;
    }

    public void setSelectNumbers(List<Integer> selectNumbers) {
        this.selectNumbers = selectNumbers;
    }

    public Integer getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(Integer targetNumber) {
        this.targetNumber = targetNumber;
    }

    public List<List<String>> getFormulaStack() {
        return formulaStack;
    }

    public void setFormulaStack(List<List<String>> formulaStack) {
        this.formulaStack = formulaStack;
    }
}
