import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapCollection {

	public static void main(String arg[]){
		
		StringBuffer sb1= new StringBuffer("A");
		StringBuffer sb2=new StringBuffer("B");
		StringBuffer sb3=new StringBuffer("C");
		StringBuffer sb4=new StringBuffer("C");
		
		String s1 = new String("A");
		String s2 = new String("B");
		String s3 = new String("C");
		String s4 = new String("D");
		String s5 = new String("E");
		String s6 = new String("F");

	//HashMap - Maintain unique key and allow single null key(except TreeMap), allow multiple null values  
		Map<StringBuffer,String> map = new HashMap<>();
		
		map.put(sb1, "AAA");
		map.put(sb2, "BBB");
		map.put(sb3, "CCC");
		map.put(sb4, "DDD");
		
		System.out.println(map);
		
		Map<String,String> map1 = new LinkedHashMap<>();
		
		map1.put(s1, "AAA");
		map1.put(s2, "BBB");
		map1.put(s3, "CCC");
		map1.put(s4, "FFF");
		map1.put(s5, "DDD");
		map1.put(null, "AAA");
		System.out.println(map1);
		
			
        List<Map.Entry<String, String>> lst = new LinkedList<>(map1.entrySet());
        Collections.sort(lst,new SortHashValue());
        System.out.println(lst);	// [A=AAA, F=AAA, B=BBB, C=CCC, E=DDD, D=FFF]
        		
        //This won't consider duplicate value
        Set<Map.Entry<String, String>> set = new TreeSet<>(new SortHashValue());
        set.addAll(map1.entrySet());
        System.out.println(set);	//[A=AAA, B=BBB, C=CCC, E=DDD, D=FFF]
        
                
        map1.clear();
        System.out.println(map1.size());
        set.forEach(sSet->map1.put(sSet.getKey(),sSet.getValue()));
        
        Iterator<Map.Entry<String, String>> itr =  map1.entrySet().iterator();
        while(itr.hasNext()){
        	Map.Entry<String, String> mm = itr.next();
        	System.out.println(mm.getKey()+" "+mm.getValue());
        	
        }  
        
        
     /*Tree Map - Tree uses Red-Black tree data structure to store data.
      * Performance wise TreeMap is slow if you will compare with HashMap and LinkedHashMap.
      * The left element will always be logically less than the parent element.
		The right element will always be logically greater than OR equal to a parent element
      */
        
        Map<String,String> treeHashMp = new TreeMap<>();
        treeHashMp.put(s1, "AAA");
        treeHashMp.put(s2, "BBB");
        treeHashMp.put(s3, "CCC");
        treeHashMp.put(s4, "FFF");
        treeHashMp.put(s5, "DDD");
        //treeHashMp.put(null, "AAA");
                
		System.out.println(treeHashMp);
	}

}


class SortHashValue implements Comparator<Map.Entry<String, String>>{


	public int compare(Entry<String, String> e1, Entry<String, String> e2) {
		String v1 = e1.getValue();
        String v2 = e2.getValue();
        return v1.compareTo(v2);
	}
	
}