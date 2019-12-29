package module;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private int no;
    private int id;
    private String name;
    private int age;
    private Date birthday;
    private String address;
    private String classs;

    public Student(int no, int id, int parseInt, String text, int age, String classsText, int i, Date date)
    {
        super();
    }
public Student(int no, int id, String name, int age, Date birthday, String text, String address)
{
    super(); /*Từ khóa super được sử dụng để tham chiếu trực tiếp đến biến instance của lớp cha gần nhất.
     được sử dụng để gọi trực tiếp Constructor của lớp cha.
        Từ khóa super được sử dụng để gọi trực tiếp phương thức của lớp cha.*/
    this.no = no;
    this.id = id;
    this.name = name; //
    this.age = age;
    this.classs = classs;
    this.birthday = birthday;
    this.address= address;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday =birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }
}
