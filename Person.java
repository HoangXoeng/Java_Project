public abstract class Person {
    protected String name;
    protected String phoneNumber;
    protected int age;
    protected char gender;
    protected Address address;

    public Person(){}

    public Person(String name, String phoneNumber, int age, char gender, Address address){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", phoneNumber=" + phoneNumber + ", age=" + age + ", gender=" + gender
                + ", address=" + address + "]";
    }


    
}
