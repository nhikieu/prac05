package mapset;

public class MapSetTest {
    public static void main(String[] args) {
        MapSet<String, Integer> map = new MapSet<>();
        map.addValue("B", 4);
        map.addValue("A", 0);
        map.addValue("A", 1);
        map.addValue("B", 3);
        map.addValue("A", 2);
        for (Integer value : map) {
            System.out.println(value);
        }
    }
}
