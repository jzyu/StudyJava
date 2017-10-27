package jzyu.com.github.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: weplant
 * Date  : 2017/10/26.
 */
public class MiscEqual {
    public static void main(String[] args) {
        List<String> obj1 = new ArrayList<>();
        obj1.add("abc");
        List<String> obj2 = new ArrayList<>();
        obj2.add("abc");
        //String obj1 = "abc";
        //String obj2 = "abc";
        //Integer obj1 = 123;
        //Integer obj2 = 123;

        System.out.println(obj1 == obj2);
        System.out.println(obj1.equals(obj2));
    }
}
