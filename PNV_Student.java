import java.util.ArrayList;

public class PNV_Student extends Person{
	private static ArrayList<Subject> listSubject_of_Student = new ArrayList<Subject>();
	private static ArrayList<PNV_Student> list_Student = new ArrayList<PNV_Student>();
	private static int student_ID  = 0;
	private String class_Student;
	public PNV_Student () {}
	public PNV_Student (String name,String phoneNumber,int age, char gender, Address address, String name_class) {
		super(name,phoneNumber,age,gender,address );
		this.class_Student = name_class;
		list_Student.add(this);
		student_ID = student_ID + 1;
	}
	public String getClass_Student() {
		return class_Student;
	}
	public void setClass_Student(String class_Student) {
		this.class_Student = class_Student;
	}
	public String view_Information(PNV_Student student) {
		return ("Student name is "+student.getName()+"\nPhone number is "+student.getPhoneNumber()+" \nStudy in class "+student.getClass_Student());
	}

	public static ArrayList<Subject> getListSubject_of_Student() {
		return listSubject_of_Student;
	}
	public static void setListSubject_of_Student(ArrayList<Subject> listSubject_of_Student) {
		PNV_Student.listSubject_of_Student = listSubject_of_Student;
	}
	public static ArrayList<PNV_Student> getList_Student() {
		return list_Student;
	}
	public static void setList_Student(ArrayList<PNV_Student> list_Student) {
		PNV_Student.list_Student = list_Student;
	}
	public static int getStudent_ID() {
		return student_ID;
	}
	public static void setStudent_ID(int student_ID) {
		PNV_Student.student_ID = student_ID;
	}
	public void view_learning_situation(Subject subject) {
		  for (int i = 0; i <  subject.getListSubject().size(); i++) {
	                System.out.printf(i+1 +". %-20s %.0f Lessons \n",subject.getListSubject().get(i).getSubject_name(), subject.getListSubject().get(i).getNumber_of_lesson());
	            }
        }	
	public static void showStudentList() {
        System.out.println("_______________STUDENT LIST______________");
        for(int i = 0; i < student_ID; i++ ) {
            System.out.println(i + "   " +list_Student.get(i).getName()+"   "+ list_Student.get(i).getClass_Student());
        }
    }
}