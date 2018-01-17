package com.zeus.test.service;

import com.zeus.test.dao.StudentDao;
import com.zeus.test.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author keven
 * @date 2018-01-17 上午11:44
 * @Description
 */
@Service
public class StudentService {


    private final StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public Student findById(Long id) {
        Student student = studentDao.findById(id);
        if (student == null) {
            return null;
        }
       return student;
    }
}
