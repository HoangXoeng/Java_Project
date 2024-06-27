import java.util.ArrayList;

public class PNV_Student extends Person{
	private static ArrayList<PNV_Student> list_Student = new ArrayList<PNV_Student>();
	private static int numberOfStudent  = 0;
	private String class_Student;
	public PNV_Student () {} //!This constructor only create base object (object use to call method)
	public PNV_Student (String name,String phoneNumber,int age, char gender, Address address, String name_class) {
		super(name,phoneNumber,age,gender,address );
		this.class_Student = name_class;
		list_Student.add(this);
		numberOfStudent = numberOfStudent + 1;
	}
	public String getClass_Student() {
		return class_Student;
	}
	public void setClass_Student(String class_Student) {
		this.class_Student = class_Student;
	}
	public String view_Information(PNV_Student student) {
		return ("Student name is "+student.getName()+" \nStudy in class "+student.getClass_Student());
	}

	public static ArrayList<PNV_Student> getList_Student() {
		return list_Student;
	}
	public void setList_Student(ArrayList<PNV_Student> list_Student) {
		PNV_Student.list_Student = list_Student;
	}
	public static int getStudent_ID() {
		return numberOfStudent;
	}
	public static void setStudent_ID(int numberOfStudent) {
		PNV_Student.numberOfStudent = numberOfStudent;
	}
	public void view_learning_situation(Subject subject) {
		System.out.println("_______________SUBJECT LIST______________");
        for(int i = 0; i < subject.getListSubject().size(); i++ ) {
            System.out.printf(i+1 +". %-20s %.0f lesson %20s\n",subject.getListSubject().get(i).getSubject_name(), subject.getListSubject().get(i).getNumber_of_lesson(),subject.getListSubject().get(i).getTeacher().getName());
        }
        }	
	public static void showStudentList() {
        System.out.println("_______________STUDENT LIST______________");
        for(int i = 0; i < numberOfStudent; i++ ) {
            System.out.println(i + "   " +list_Student.get(i).getName()+"   "+ list_Student.get(i).getClass_Student());
        }
    }
	public void showInfor(){
		System.out.println("Student name: "+this.getName());
		System.out.println("Student age: "+this.getAge());
		System.out.println("Student phone number: "+this.getPhoneNumber());
		System.out.println("Student address: "+ this.getAddress());
		System.out.println("Student class: "+this.getClass_Student());
		System.out.println("-------------------------------------------------");
	}
}