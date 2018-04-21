package com.zeus.test.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.thymeleaf.expression.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * @author keven
 * @date 2018-04-01 下午5:23
 * @Description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
class Student {

    Integer id;

    String name;


    @Override
    public int hashCode() {
        return id;
    }


    @Override
    public boolean equals (Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }
        Student student = (Student) obj;
        return this.id.equals(student.getId());
    }


}

public class SetTest {

    public static void main(String[] args) {
        Student student = new Student(1, "a");
        Student student1 = new Student(2, "b");

        Set<Student> students = new HashSet<>();
        students.add(student);
        students.add(student1);

        Student student2 = new Student(1, "c");
        students.add(student2);

        System.out.println(students.size());
    }

}
