package module;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentFormat {
    private int no;
    private int id;
    private String name;
    private int age;
    private String classs;
    private String birthday; //?? ko phari laf Date
    private String address;

    public StudentFormat(int no, int id, String name, int age, String address, String classs, Date birthday)
    {
        super();
    }

    public StudentFormat(int no, int id, String name, int age, String classs, Date birthday, String address) {
        super();
        this.no = no;
        this.id = id;
        this.name = name; //
        this.age = age;
        this.classs = classs;
        this.address = address;
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        this.birthday =dt1.format(birthday);
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
