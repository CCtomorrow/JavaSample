package collect;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

/**
 * <b>Project:</b> Sample <br>
 * <b>Create Date:</b> 2017/9/7 <br>
 * <b>Author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b>  <br>
 */
public class Set {

    public static void main(String[] args) {

        TreeSet<String> set = new TreeSet<String>();
        set.add("we");
        set.add("are");
        set.add("we");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Random random = new Random();
        System.out.println(random.nextInt(5));

        String s1 = "we";
        String s2 = "we";
        System.out.println(s1 == s2);


        AssistantCache cache = new AssistantCache();
        cache.time = System.currentTimeMillis();
        cache.count = 2;
        cache.enable = true;

        saveCache(cache);

    }

    public static class AssistantCache {

        public long time;

        public int count;

        public boolean enable;

    }


    public static void saveCache(AssistantCache a) {
        if (a == null) return;
        String result = a.time + ";" + a.count + ";" + a.enable;
        System.out.println(result);
    }

}
