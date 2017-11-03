package jzyu.com.github.designpattern;

/**
 * Author: weplant
 * Date  : 2017/11/2.
 */
public class SingletoneSample {

    public static class Singleton {
        private static Singleton instance;
        private Singleton (){}
        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
}
