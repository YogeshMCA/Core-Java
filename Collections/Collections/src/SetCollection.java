import java.util.HashSet;
import java.util.Set;

/*
 *  StringBuffer and StringBuilder classes not overriding equals() method and hashcode() method where as String class is overriding these two methods.
Basically Strings are Immutable means Whenever we try to change the value of string result will be new string. So string content wont change.
StringBuffer main use is mutable means when we append a string to it it will add to existing object.
When the content changes the hashcode will changes. 
 */
public class SetCollection {

	public static void main(String arg[]) {
		

		StringBuilder name= new StringBuilder("AAAA");
		StringBuilder name1= new StringBuilder("AAAA");
		System.out.println("Name:"+name+" "+name.hashCode());
		//name.append("XXX");
		System.out.println("Name:"+name1+" "+name1.hashCode());

		Set<StringBuilder> uniqSet = new HashSet<>();
		uniqSet.add(name);
		uniqSet.add(name1);
		System.out.println(uniqSet);
		

		String immu = new String("Imm");
		System.out.println("Immutable:"+immu+" "+immu.hashCode());
		String immu1 = new String("Imm");
		System.out.println("Immutable:"+immu1+" "+immu1.hashCode());
		
		
		Set<String> muSet = new HashSet<>();
		muSet.add(immu);
		muSet.add(immu1);
		System.out.println(muSet);
		
		
	}
}
