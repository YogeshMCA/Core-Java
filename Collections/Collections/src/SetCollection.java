import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
 *  StringBuffer and StringBuilder classes not overriding equals() method and hashcode() method where as String class is overriding these two methods.
Basically Strings are Immutable means Whenever we try to change the value of string result will be new string. So string content wont change.
StringBuffer main use is mutable means when we append a string to it it will add to existing object.
When the content changes the hashcode will changes.

HashSet internally uses HashMap(Eliminate duplicate value) to store the value. 
 */
public class SetCollection {

	public static void main(String arg[]) {
		
	//Mutable
		StringBuilder name= new StringBuilder("AAAA");
		StringBuilder name1= new StringBuilder("AAAA");
		System.out.println("Name:"+name+" "+name.hashCode());
		//name.append("XXX");
		System.out.println("Name:"+name1+" "+name1.hashCode());

		/*
		 * Set allows duplicate String value when using StringBuilder / StringBuffer because both are not overriding hascode() and equals() method.
		 */
		Set<StringBuilder> uniqSet = new HashSet<>();
		uniqSet.add(name);
		uniqSet.add(name1);
		System.out.println(uniqSet);
		
	//Immutable
		String immu = new String("Imm");
		String immu1 = new String("Imm");
		String ss = new String("RAM");
		System.out.println("Immutable:"+immu+" "+immu.hashCode());
		System.out.println("Immutable:"+immu1+" "+immu1.hashCode());
		
		
		Set<String> muSet = new HashSet<>();
		muSet.add(immu);
		muSet.add(ss);
				
		Iterator itr = muSet.iterator();
		/*
		 ConcurrentModificationException / Fail fast - Adding values into the list/set once iterator created.
		 But we can add it only if list/set having single value
		*/
		
		while (itr.hasNext()){
			System.out.println(itr.next());
			//muSet.add("FDFDFD");	    
			//muSet.remove(immu);
		}
		System.out.println(muSet.size());
		
	//TreeSet
		Set<String> treeSet = new TreeSet<>(); //This will consider case sensitive
		treeSet.add("1FDFDFD");	    
		treeSet.add("Z");
		treeSet.add("fDFDFD12");
		System.out.println(treeSet); //[1FDFDFD, Z, fDFDFD12]
		
		Set<String> treeSetNc = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);//This won't consider case sensitive
		treeSetNc.add("1FDFDFD");	    
		treeSetNc.add("Z");
		treeSetNc.add("fDFDFD12");
		System.out.println(treeSetNc); //[1FDFDFD, Z, fDFDFD12]
		
		Set<String> treeSetComp = new TreeSet<>(new StringDes()); //Sorting(Ascending/Descending) using Comparator
		treeSetComp.add("1FDFDFD");	    
		treeSetComp.add("Z");
		treeSetComp.add("fDFDFD12");
		System.out.println(treeSetComp); //[1FDFDFD, Z, fDFDFD12]
		
	}
}

class StringAss implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1.compareToIgnoreCase(o2)>0)
			return 1;
		else if(o1.compareToIgnoreCase(o2)<0)
			return -1;
		else
			return 0;
	}
	
}

class StringDes implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1.compareToIgnoreCase(o2)>0)
			return -1;
		else if(o1.compareToIgnoreCase(o2)<0)
			return 1;
		else
			return 0;
	}
	
}