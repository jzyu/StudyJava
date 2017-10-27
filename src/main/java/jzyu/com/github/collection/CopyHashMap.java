package jzyu.com.github.collection;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Author: jzyu
 * Date  : 2017/9/21
 */
public class CopyHashMap {
    private static <T> List<T> fillList(List<T> datas, T... valueArray) {
        Collections.addAll(datas, valueArray);
        return datas;
    }

    public static <K, V> Map<K, V> deepCopy(Map<K, V> original){

        Map<K, V> copy = new HashMap<>();
        for(Map.Entry<K, V> entry : original.entrySet()){
            copy.put(entry.getKey(), entry.getValue());
        }
        return copy;
    }

    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("AAA", fillList(new ArrayList<>(),1, 2, 3));
        map.put("BBB", fillList(new ArrayList<>(),11, 22, 33));
        map.put("CCC", fillList(new ArrayList<>(),111, 222, 333));

        Map<String, List<Integer>> copy = DeepClone.deepClone(map);

        Iterator<Map.Entry<String, List<Integer>>> iterator = copy.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Integer>> entry = iterator.next();
            if (entry.getKey().equals("BBB")) {
                entry.getValue().clear();
            }
        }

        System.out.println(map.get("BBB").size());
        System.out.println(map.get("BBB").size());
    }

    /**
     * deep clone
     */
    public static final class DeepClone {

        private DeepClone(){}

        public static <X> X deepClone(final X input) {
            if (input == null) {
                return input;
            } else if (input instanceof Map<?, ?>) {
                return (X) deepCloneMap((Map<?, ?>) input);
            } else if (input instanceof Collection<?>) {
                return (X) deepCloneCollection((Collection<?>) input);
            } else if (input instanceof Object[]) {
                return (X) deepCloneObjectArray((Object[]) input);
            } else if (input.getClass().isArray()) {
                return (X) clonePrimitiveArray((Object) input);
            }

            return input;
        }

        private static Object clonePrimitiveArray(final Object input) {
            final int length = Array.getLength(input);
            final Object copy = Array.newInstance(input.getClass().getComponentType(), length);
            // deep clone not necessary, primitives are immutable
            System.arraycopy(input, 0, copy, 0, length);
            return copy;
        }

        private static <E> E[] deepCloneObjectArray(final E[] input) {
            final E[] clone = (E[]) Array.newInstance(input.getClass().getComponentType(), input.length);
            for (int i = 0; i < input.length; i++) {
                clone[i] = deepClone(input[i]);
            }

            return clone;
        }

        private static <E> Collection<E> deepCloneCollection(final Collection<E> input) {
            Collection<E> clone;
            // this is of course far from comprehensive. extend this as needed
            if (input instanceof LinkedList<?>) {
                clone = new LinkedList<E>();
            } else if (input instanceof SortedSet<?>) {
                clone = new TreeSet<E>();
            } else if (input instanceof Set) {
                clone = new HashSet<E>();
            } else {
                clone = new ArrayList<E>();
            }

            for (E item : input) {
                clone.add(deepClone(item));
            }

            return clone;
        }

        private static <K, V> Map<K, V> deepCloneMap(final Map<K, V> map) {
            Map<K, V> clone;
            // this is of course far from comprehensive. extend this as needed
            if (map instanceof LinkedHashMap<?, ?>) {
                clone = new LinkedHashMap<K, V>();
            } else if (map instanceof TreeMap<?, ?>) {
                clone = new TreeMap<K, V>();
            } else {
                clone = new HashMap<K, V>();
            }

            for (Map.Entry<K, V> entry : map.entrySet()) {
                clone.put(deepClone(entry.getKey()), deepClone(entry.getValue()));
            }

            return clone;
        }
    }
}
