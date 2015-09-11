public class Student{
	private String name;
	private int age;
	private char sex;
	private String phone;
	private String major;
	public static final String school = "GDUT";

	//Constructor
	public Student(String n, int a, char s, String p, String m){
		name = n;
		age = a;
		sex = s;
		phone = p;
		major = m;
	}
	//Accessor methods
	public String getName(){
		return name;	
	}
	public int getAge(){
		return age;
	}
	public char getSex(){
		return sex;
	}
	public String getPhone(){
		return phone;
	}
	public String getMajor(){
		return major;
	}
	//Mutator
	//...
	@Override
	public String toString(){
		return ("Name: " + name + " Age: " + age + " Sex: " + sex + "Phone: "+ phone+ " Major: "+ major + " School: " +school);
	}
}	
