
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    static ArrayList<String> listAccStudent = new ArrayList<String>();
    static ArrayList<String> listAccStaff = new ArrayList<String>();
    static ArrayList<String> listAcc = new ArrayList<String>();
    static Scanner input = new Scanner(System.in);
    final static File myFileStudent = new File("C:\\Users\\Admin\\Documents\\GitHub\\Java_Project\\AccountStudent.txt");
    final static File myFileStaff = new File("C:\\Users\\Admin\\Documents\\GitHub\\Java_Project\\AccountStaff.txt");
    // you can change your path of file.

    static int checkAcc(String userName, int role) { // check username already exits ?

        if (role == 1) {
            listAcc = listAccStudent;
        } else {
            listAcc = listAccStaff;
        }
        for (int i = 0; i < listAcc.size(); i += 2) {
            if (userName.equalsIgnoreCase(listAcc.get(i)))
                return i;
        }
        return -1;
    }

    static void accessFile(int role) {
        File myFile; // create myFile, it will access the file base on role

        if (role == 1) {
            myFile = myFileStudent;
            listAcc = listAccStudent;
        } else {
            myFile = myFileStaff;
            listAcc = listAccStaff;
        }
        // create 2 list acc, base on role, the arrayList will store data ex. role
        // 1(Student) => arrayList store data account of student

        try {
            // create file if file not exits
            myFile.createNewFile();

            FileInputStream in = new FileInputStream(myFile); // read data file (byte)
            InputStreamReader in1 = new InputStreamReader(in, "UTF-8"); // convert data from byte to utf-8
            BufferedReader file = new BufferedReader(in1); // add data to file

            String x;
            while ((x = file.readLine()) != null) {
                listAcc.add(x);// read file and add data(user name , pass) to ArrayList
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void logIn(int role) {
        int count = 0;
        if (input.hasNextLine())
            input.nextLine();
        System.out.println("------------LOG IN------------");
        System.out.print("\nUser name: ");
        String userName = input.nextLine();
        while (checkAcc(userName, role) == -1) {
            count++;
            if (count == 3) {
                System.out.println("Enter incorrectly 3 times, automatically switch to the sign up case");
                System.out.println("Press enter to continue");
                signUp(role);
                break;
            }
            System.out.println("Account does not exist! Re-enter!");
            System.out.print("User name: ");
            userName = input.nextLine();
        }
        if (count == 3)
            return;
        int indexPassword = checkAcc(userName, role) + 1;
        count = 0;
        System.out.print("Password: ");
        String password = input.nextLine();
        while (password.equals(listAcc.get(indexPassword)) == false) {
            count++;
            if (count == 3) {
                System.out.println("Enter incorrectly 3 times, automatically switch to the sign up item");
                System.out.println("Enter to continue");
                signUp(role);
                break;
            }
            System.out.println("Wrong password! Re-enter!");
            System.out.print("Password: ");
            password = input.nextLine();
        }
    }

    static void clrscr() { // make blank console
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    static void signUp(int role) {
        if (input.hasNextLine())
            input.nextLine();
        clrscr();
        File myFile;
        if (role == 1) {
            myFile = myFileStudent;
        } else {
            myFile = myFileStaff;
        }
        System.out.println("------------SIGN UP------------");
        try {
            FileWriter writer = new FileWriter(myFile, true); // access file and allow write new linne
            BufferedWriter filein = new BufferedWriter(writer);

            System.out.print("\nUser name: ");
            String userName = input.nextLine();
            while (checkAcc(userName, role) != -1) { // check user name already exits ???
                System.out.println("This name account has already existed! Re-enter!");
                System.out.print("User name: ");
                userName = input.nextLine();
            }
            System.out.print("Password: ");
            String password = input.nextLine();
            filein.write(userName + "\n"); // add user name to file
            filein.write(password + "\n"); // add password to file
            filein.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void modifiInformation(PNV_Student student, int choseModifi) {
        do {
            switch (choseModifi) {
                case 1:
                    input.nextLine();
                    System.out.print("Enter new name: ");
                    String name = input.nextLine();
                    student.setName(name);
                    break;
                case 2:
                    input.nextLine();
                    System.out.print("Enter new phone number: ");
                    String phoneNum = input.nextLine();
                    student.setPhoneNumber(phoneNum);
                    break;
                case 3:
                    input.nextLine();
                    System.out.print("Enter new age: ");
                    int age = input.nextInt();
                    student.setAge(age);
                    break;
                case 4:
                    input.nextLine();
                    System.out.print("Enter new gender (1 letter): ");
                    char gender = input.nextLine().charAt(0); // if user enter mone than 1 letter, App will recive firs letter
                    student.setAge(gender);
                    break;
                case 5:
                    input.nextLine();
                    System.out.print("Enter name of street: ");
                    String street = input.nextLine();
                    System.out.print("Enter house number (int)");
                    int houseNumber = input.nextInt();
                    student.setAddress(new Address(street, houseNumber));
                    break;
                case 6:
                    input.nextLine();
                    System.out.print("Enter new class: ");
                    String className = input.nextLine();
                    student.setClass_Student(className);
                    break;
                default:
                    break;
            }

        } while (choseModifi != 7);
    }

    public static void studentMenthod(PNV_Student student) {
        int chose;
        System.out.println("Welcome back");
        System.out.println("List of student: ");
        PNV_Student.showStudentList();
        System.out.println("Chose your id student:");
        int id = input.nextInt();
        do {
            System.out.println(PNV_Student.getList_Student().get(id).getName());
            System.out.println("Chose funtion");
            System.out.println("1: Modifi infomation");
            System.out.println("2: View list of subject in PNV");
            System.out.println("3: Exit");
            chose = input.nextInt();
            switch (chose) {
                case 1:
                    System.out.println("Choose your infor you want modifi: ");
                    System.out.println("1. Modifi name");
                    System.out.println("2. Modifi phone number");
                    System.out.println("3. Modifi age");
                    System.out.println("4. Modifi gender");
                    System.out.println("5. Modifi address");
                    System.out.println("6. Modifi class");
                    System.out.println("7. Exit");
                    int choseModifi = input.nextInt();
                    modifiInformation(PNV_Student.getList_Student().get(id), choseModifi);
                    break;
                case 2:
                    Subject.showSubjectList();
                    break;
                default:
                    break;
            }
        } while (chose != 3);

    }

    public static void main(String[] args) {
        runData();// run data for program, you can understand this funtion will create object for this program
        PNV_Student pnv_Student = new PNV_Student();
        System.out.println("Welcome");
        System.out.println("Choose your role");
        System.out.println("1. Student \n2. Staff \n3. Exit");
        int choose = input.nextInt();
        switch (choose) {
            case 1: {
                accessFile(1);// prepare list of account
                logIn(1);
                studentMenthod(pnv_Student);
                break;
            }
            case 2: {
                accessFile(2);// prepare list of account
                logIn(2);
                System.out.println("case2 run");
                break;
            }
        }

        input.close();

    }

    public static void runData() {
        Address ad0 = new Address("To Hien Thanh", 13);
        Address ad1 = new Address("Phan Boi Chau", 13);
        Address ad2 = new Address("Ho Chi Minh", 13);
        Address ad3 = new Address("To Hien Thanh", 13);
        Address ad4 = new Address("To Hien Thanh", 13);
        Address ad5 = new Address("To Hien Thanh", 13);
        PNV_Student st1 = new PNV_Student("Ky Ba", "012312412", 18, 'f', ad0, "PNV26A");
        PNV_Student st2 = new PNV_Student("Thanh Binh", "012312412", 18, 'f', ad1, "PNV26A");
        PNV_Student st3 = new PNV_Student("Minh Hoang", "012312412", 18, 'f', ad2, "PNV26A");
        PNV_Student st4 = new PNV_Student("Thai Duong", "012312412", 18, 'f', ad3, "PNV26B");
        PNV_Student st5 = new PNV_Student("Xuan Nguyen", "012312412", 18, 'f', ad4, "PNV26B");
        PNV_Student st6 = new PNV_Student("Duyen Ha", "012312412", 18, 'f', ad5, "PNV26B");
        Subject sb1 = new Subject("Python", 90);
        Subject sb2 = new Subject("Java OOP", 90);
        Subject sb3 = new Subject("GE1", 120);
        Subject sb4 = new Subject("GE2", 120);
        Subject sb5 = new Subject("PLT1", 90);
        Subject sb6 = new Subject("PLT2", 45);
    }
}
