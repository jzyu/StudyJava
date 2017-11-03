package jzyu.com.github.collection.myversion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printf;
import static org.junit.Assert.*;

/**
 * Author: weplant
 * Date  : 2017/11/2.
 */
public class MyLinkedListTest {

    private MyList<String> texts = new MyLinkedList<>();

    @Before
    public void tearDown() {
        texts.removeAll();
    }

    @Test
    public void testAddRemove() {
        texts.add("abc");
        assertEquals(1, texts.size());
        assertEquals("abc", texts.get(0));

        texts.add("def");
        assertEquals(2, texts.size());
        assertEquals("def", texts.get(1));

        assertEquals(0, texts.indexOf("abc"));
        assertEquals(1, texts.indexOf("def"));

        String removed = texts.remove(1);
        assertEquals(1, texts.size());
        assertEquals("def", removed);

        texts.add("def");
        removed = texts.remove(0);
        assertEquals(1, texts.size());
        assertEquals("abc", removed);
        removed = texts.remove(0);
        assertEquals(0, texts.size());
        assertEquals("def", removed);
    }

    @Test
    public void testItr() {
        texts.add("ABC");
        texts.add("DEF");

        Iterator<String> iter = texts.iterator();
        while (iter.hasNext()) {
            printf("%s,", iter.next());
        }
    }
}