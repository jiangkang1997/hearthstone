package com.jk.game.herathstone.calculator;

/**
 * @author jk
 * @date 2021/1/30 22:22
 */
public class Test {

    public static void main(String[] args) {
        String number = "-123456";
        boolean flag = false;
        if(Integer.valueOf(number)<0){
            flag = true;
            number = number.substring(1);
        }
        number = new StringBuffer(number).reverse().toString();
        System.out.println(flag ? -1*Integer.parseInt(number) : Integer.parseInt(number));
    }
}
