package data;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import module.Student;
import module.User;
public class Read {

    public static List<User> readListUser() throws IOException {
        List<User> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(new File("./user.xml"));
        XMLDecoder decoder = new XMLDecoder(fis);
        list = (List<User>) decoder.readObject();
        decoder.close();
        fis.close();
        return list;
    }
    public static List<Student> readListStudent() throws IOException {
        List<Student> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(new File("./student.xml"));
        XMLDecoder decoder = new XMLDecoder(fis);
        list = (List<Student>) decoder.readObject();
        decoder.close();
        fis.close();
        return list;
    }
}