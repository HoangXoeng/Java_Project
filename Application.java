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
        System.out.println("_______________LOG IN_______________");
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
        System.out.println("_______________SIGN UP_______________");
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

    public static void modifiInformation(PNV_Student student) {
        int chose;
        do {

            System.out.println("Choose your infor you want modifi: ");
            System.out.println("1. Modifi name");
            System.out.println("2. Modifi phone number");
            System.out.println("3. Modifi age");
            System.out.println("4. Modifi gender");
            System.out.println("5. Modifi address");
            System.out.println("6. Modifi class");
            System.out.println("7. Exit");
            chose = input.nextInt();
            input.nextLine();
            switch (chose) {
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
                    char gender = input.nextLine().charAt(0); // if user enter mone than 1 letter, App will recive first letter
                                                              
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

        } while (chose != 6);
    }

    public static void main(String[] args) {

        System.out.println("Welcome");
        System.out.println("Choose your role");
        System.out.println("1. Student \n2. Staff \n3. Exit");
        int choose = input.nextInt();
        switch (choose) {
            case 1: {
                accessFile(1);// prepare list of account
                logIn(1);
                System.out.println("case 1 run");
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

}
