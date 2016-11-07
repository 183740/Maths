package com.csd.Maths.calcbelowten;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuefen on 2016/11/5.
 */
public class Formula {
    private int maxNumber = 0;
    private List formulas;

    public Formula(int maxValue)
    {
        this.maxNumber = maxValue;
        formulas = new ArrayList();
        this.generateFormula();
    }

    public void generateFormula()
    {
        for(int i=0;i<=this.maxNumber;i++)
        {
            for(int j=0;j<=this.maxNumber;j++)
            {
                checkFormula(i,"+",j);
                checkFormula(i,"-",j);
            }
        }
    }

    private void checkFormula(int i, String s, int j) {
        if(s == "-" && i<j)
        {
            return;
        }

        int temp = calcFormula(i,s,j);
        if(temp>-1 && temp <= this.maxNumber)
        {
            for(int k=0;k<=this.maxNumber;k++) {
                String tempFormula = String.valueOf(i) + " " + s + " " + String.valueOf(j);
                //checkFormula(tempFormula,temp, "+", k);
                //checkFormula(tempFormula,temp, "-", k);
                checkFormula(i,s,j,temp, "+", k);
                checkFormula(i,s,j,temp, "-", k);
            }
        }
    }

    private void checkFormula(String tempFormula, int i, String s, int j) {
        if(s == "-" && i<j)
        {
            return;
        }

        int temp = calcFormula(i,s,j);
        if(temp>-1 && temp <= this.maxNumber)
        {
            String finalFormula = tempFormula + " " + s + " " + String.valueOf(j) + " = " + String.valueOf(temp);
            this.formulas.add(finalFormula);
        }
    }

    private void checkFormula(int i,String s, int j, int temp, String s1, int k) {
        if(s1 == "-" && temp<k)
        {
            return;
        }

        int finalvalue = calcFormula(temp,s1,k);
        if(finalvalue>-1 && finalvalue <= this.maxNumber)
        {
            if(isValide(i,j,k))
            {
                String finalFormula =  String.valueOf(finalvalue) + "," + String.valueOf(i) + " " + s + " " + String.valueOf(j) + " " + s1 + " " + String.valueOf(k) + " =";
                this.formulas.add(finalFormula);
            }
        }
    }

    private boolean isValide(int i, int j, int k) {
        if((i==j && (j==k || i == 0)) || (j==k && j==0) || (i==k && i==0))
        {
            return false;
        }
        return true;
    }

    private int calcFormula(int i, String s, int j) {
        int answer = -1;
        switch(s)
        {
            case "-": answer = i-j;break;
            case "+": answer=i+j;break;
            default: answer = -1;
        }
        return answer;
    }

    public List getFormulas()
    {
        return this.formulas;
    }
}