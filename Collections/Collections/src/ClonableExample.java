
public class ClonableExample {
	public static void main(String arg[]){
		Books book = new Books(1,"C++");
		First first = new First("Yogesh",book);
		First fir=null;
		try{
			fir = first.clonable();
		}catch(CloneNotSupportedException e){
			System.out.println(e);
		}
		/*
		 * Changing reference object(book) value from a cloneable object(fir), will change the origin object(first) reference(book) value also.
		 * Shallow Cloning
		 */
		fir.book.Id=2;
		fir.book.name="Java";
		System.out.println(first);
		System.out.println(fir);
		
		System.out.println(first.hashCode()+" "+fir.hashCode()+" "+(first==fir)+" "+first.equals(fir));
		
		/*
		 * Deep Cloning
		 */
		Books book1 = new Books(101,"C");
		First first1 = new First("Ram",book1);
		First fir1=null;
		try{
			fir1 = first1.deepClonable();
		}catch(CloneNotSupportedException e){
			System.out.println(e);
		}
		fir1.book.Id=2;
		fir1.book.name="Java";
		System.out.println(first1);
		System.out.println(fir1);
	}

}


class First implements Cloneable{
	String sname;
	Books book;
	First(String sname,Books book){
		this.sname = sname;
		this.book = book;
	}
	/*
	 *Shallow Cloning 
	 */
	protected First clonable()throws CloneNotSupportedException{
		return (First)super.clone();
	}
	
	/*
	 *Deep Cloning 
	 */
	protected First deepClonable()throws CloneNotSupportedException{
		First first = (First)super.clone();
		first.book = first.book.clone();
		return first;
	}
	public String toString(){
		return this.sname+" "+this.book.Id+" "+this.book.name;
	}
}

class Books implements Cloneable{
	int Id;
	String name;
	Books(int id, String name){
		this.Id = id;
		this.name = name;
	}
	
	protected Books clone()throws CloneNotSupportedException{
		return (Books)super.clone();
	}
}