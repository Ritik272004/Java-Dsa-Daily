import java.util.*;

public class TimeMap {
    private static Map<String , List<Pair>> map;

    private TimeMap(){
        map = new HashMap<>();
    }


    // Set the value
    private static void set(String  key , String value , int timeStamp){
        map.putIfAbsent(key , new ArrayList<>());
        map.get(key).add(new Pair(timeStamp , value));
    }

    // get the value using Binary Search
    private static String get(String key , int timeStamp){
        if(!map.containsKey(key)){
            return null;
        }

        List<Pair> pairs = map.get(key);

        int l = 0;
        int r = pairs.size()-1;
        String result = "";

        while(l<=r){
            int m = l + (r-l)/2;
            if(pairs.get(m).timeStamp <= timeStamp){
                result = pairs.get(m).value;
                l = m + 1; // find closer timeStamp to given timeStamp
            }else{
                r = m - 1;
            }
        }

        return result;
    }

    public static class Pair{
        int timeStamp;
        String value;
        public Pair(int timeStamp , String val){
            this.timeStamp = timeStamp;
            this.value = val;
        }
    }

    public static void main(String[] args) {
        List<Object> output = new ArrayList<>();

        TimeMap obj = new TimeMap();
        output.add(null);
        obj.set("ritik" , "happy" , 1);
        output.add(null);
        output.add(obj.get("ritik" , 1));
        output.add(obj.get("ritik",2));
        obj.set("ritik","sad",3);
        output.add(null);
        output.add(obj.get("ritik",3));
        System.out.println(output);
    }
}
