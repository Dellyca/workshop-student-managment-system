package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDao;
import se.lexicon.model.Student;

public class Main {
    public static void main(String[] args) {

        System.out.println("Student Management System");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        Student student = new Student("Deli");
        Student deli = studentDao.save(student);
        System.out.println(studentDao.findAll());
        System.out.println("Find by id: " + studentDao.find(deli.getId()));
        studentDao.delete(deli.getId());
        System.out.println(studentDao.findAll());

    }
}