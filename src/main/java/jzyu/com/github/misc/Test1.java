package jzyu.com.github.misc;

/**
 * Author: jzyu
 * Date  : 2017/9/29
 */
public class Test1 {
    public static void main(String[] args) {
        //boolValueOf();
        //boolParse();
        intValueOf();
    }

    private static void boolParse() {
        boolean flag1 = Boolean.parseBoolean("");
        boolean flag2 = Boolean.parseBoolean(" ");
        boolean flag3 = Boolean.parseBoolean("True");
        boolean flag4 = Boolean.parseBoolean("true");

        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
        System.out.println(flag4);
    }

    private static void boolValueOf() {
        boolean flag1 = Boolean.valueOf("");
        boolean flag2 = Boolean.valueOf(" ");
        boolean flag3 = Boolean.valueOf("True");
        boolean flag4 = Boolean.valueOf("true");

        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
        System.out.println(flag4);
    }

    private static void intValueOf() {
        try {
            int flag1 = Integer.valueOf("123");
            int flag2 = Integer.parseInt(" 123 ");
            int flag3 = Integer.valueOf(" - 123 ");
            int flag4 = Integer.valueOf(" ");
            int flag5 = Integer.valueOf("");

            System.out.println(flag1);
            System.out.println(flag2);
            System.out.println(flag3);
            System.out.println(flag4);
            System.out.println(flag5);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
