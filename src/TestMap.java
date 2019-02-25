/**
 *
 */
public class TestMap {
    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<String, Integer>();

        Long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++){
            map.put("HI"+i,i);
        }

        for (int i = 0; i<1000;i++){
            System.out.println(map.get("HI"+i));
        }

        Long end = System.currentTimeMillis();

        System.out.println("Size: " + map.size() + " Time: " + (end - start));
    }
}
