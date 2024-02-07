package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

public class Main {
    public static void main(String[] args) {

        System.out.println("Student Management System");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        //part-1
        StudentDao studentDao = context.getBean(StudentDao.class);
//        Student student = new Student("Deli");
//        Student deli = studentDao.save(student);
//        System.out.println(studentDao.findAll());
//        System.out.println("Find by id: " + studentDao.find(deli.getId()));
//        studentDao.delete(deli.getId());
//        System.out.println(studentDao.findAll());

        //part-2
        UserInputService userInputService = context.getBean(UserInputService.class);

        //Part-3
        StudentManagement studentManagement = context.getBean(StudentManagement.class);
        Student student = studentManagement.create();
        student = studentManagement.save(student);
        System.out.println("Student List : " + studentManagement.findAll());
        System.out.println("Find by Id : " + studentManagement.find(student.getId()));
        student.setName("Deli Cakar");
        System.out.println(studentManagement.edit(student));
        System.out.println("Student List : " + studentManagement.findAll());
        System.out.println("Remove : " + studentManagement.remove(student.getId()));
        System.out.println("Student List : " + studentManagement.findAll());
    }
}