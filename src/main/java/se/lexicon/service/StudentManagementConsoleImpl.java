package se.lexicon.service;

import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDao;
import se.lexicon.data_access.StudentDaoListImpl;
import se.lexicon.model.Student;
import se.lexicon.util.UserInputService;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    UserInputService userInputService;
    StudentDao studentDao;

    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDao studentDao) {
        this.userInputService = userInputService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        System.out.println("Enter Student name : ");
        String name = userInputService.getString();
        if(name.isBlank()) throw new IllegalArgumentException("Student name was empty!");
        return new Student(name);
    }

    @Override
    public Student save(Student student) {
        if(student == null) throw new IllegalArgumentException("Student was null!");
        studentDao.save(student);
        return student;
    }

    @Override
    public Student find(int id) {
        if(id==0) throw new IllegalArgumentException("Id was empty!");
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        if(id==0) throw new IllegalArgumentException("Id was empty!");
        Student student = studentDao.find(id);
        studentDao.delete(student.getId());
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        if(student == null) throw new IllegalArgumentException("Student was null!");
        Student studentMatched = studentDao.find(student.getId());
        studentMatched.setName(student.getName());
        return student;
    }
}
