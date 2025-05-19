package java8.part3;

@FunctionalInterface
public interface IPrintable {

//	public abstract void print(int no);
//	public abstract void print(String firstName);
//	public abstract void print(String firstName,String lastName);
//	public abstract String print(String text);
	public abstract boolean print(String text);

}