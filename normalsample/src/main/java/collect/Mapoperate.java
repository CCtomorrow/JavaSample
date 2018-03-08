package collect;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Project:</b> Sample <br>
 * <b>Create Date:</b> 2018/1/28 <br>
 * <b>@author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b>  <br>
 */
public class Mapoperate {

    public static void main(String s[]) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "qyert");
        map.put("fav", "play");
        System.out.println(map.toString());
    }

}
