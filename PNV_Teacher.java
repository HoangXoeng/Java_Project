import java.util.ArrayList;
public class PNV_Teacher extends Person {
    private static ArrayList<PNV_Teacher> list_Teacher = new ArrayList<PNV_Teacher>();
    private static int numberOfTeacher  = 0;
    private int salary;   

    public PNV_Teacher () {}//!This constructor only create base object (object use to call method)

    public PNV_Teacher (String name,String phoneNumber,int age, char gender, Address address, int salary) {
		super(name,phoneNumber,age,gender,address);
		this.salary = salary;
		list_Teacher.add(this);
		numberOfTeacher = numberOfTeacher + 1;
	}

    public static ArrayList<PNV_Teacher> getList_Teacher() {
        return list_Teacher;
    }

    public static void setList_Teacher(ArrayList<PNV_Teacher> list_Teacher) {
        PNV_Teacher.list_Teacher = list_Teacher;
    }

    public static int getTeacher_ID() {
        return numberOfTeacher;
    }

    public static void setTeacher_ID(int numberOfTeacher) {
        PNV_Teacher.numberOfTeacher = numberOfTeacher;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public static void showTeacherList() {
        System.out.println("_______________TEACHER LIST______________");
        for(int i = 0; i < numberOfTeacher; i++ ) {
            System.out.println(i + "   " +list_Teacher.get(i).getName());
        }
    }
    public void showInfor(){
		System.out.println("Teacher name: "+this.getName());
		System.out.println("Teacher age: "+this.getAge());
		System.out.println("Teacher phone number: "+this.getPhoneNumber());
		System.out.println("Teacher address: "+ this.getAddress());
        System.out.println("Teacher salary: " + this.getSalary());
	}
}
