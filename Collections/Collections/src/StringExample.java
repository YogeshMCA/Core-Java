import java.util.HashSet;
import java.util.Set;

public class StringExample {
	public static void main(String ar[]){
		String s1 = "AA";
		System.out.println(s1.hashCode());
		String s2 = "AA";
		System.out.println(s2.hashCode());
		String s3 = new String("AA");
		System.out.println(s3.hashCode());
		s3 = "BB";
		System.out.println(s3.hashCode());
		
		Set<Immutable> set = new HashSet<>();
		set.add(new Immutable("KING"));
		set.add(new Immutable("BLAKE"));
		System.out.println(set.size());
	}

}

class Immutable{
	String id;
	Immutable(String id){
		this.id = id;
		System.out.println(id.hashCode() & 9);
	}
	@Override
	public int hashCode() {
		int i;
		i= id.hashCode() & 15;
		return i;
		
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Immutable other = (Immutable) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}