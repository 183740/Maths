package com.csd.Maths.calcbelowten;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Formula formula = new Formula(10);
        List formulas = formula.getFormulas();
        System.out.println(String.valueOf(formulas.size()));
        for(int i=0;i<formulas.size();i++){
            System.out.println(/*String.valueOf(i) + " : " + */formulas.get(i));
        }
        System.out.println("end end end ");
    }
}
