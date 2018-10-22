package com.vietle.productdata;

import com.vietle.productdata.jpqlandnativesql.entities.Student;
import com.vietle.productdata.jpqlandnativesql.repos.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpqlandnativesqlApplicationTest {

    @Autowired
    StudentRepository studentRepository;

    // JPQL
    @Test
    public void testStudentCreate() {
        Student student = new Student();
        student.setFirstName("Viet");
        student.setLastName("Le");
        student.setScore(98);

        Student student2 = new Student();
        student2.setFirstName("Bill");
        student2.setLastName("Gates");
        student2.setScore(75);

        studentRepository.save(student);
        studentRepository.save(student2);
    }

    @Test
    public void testFindAllStudents() {
        studentRepository.findAllStudents().forEach(student -> {
            System.out.println(">>>>>>" + student);
        });
    }

    @Test
    public void testFindAllStudentsPartialData() {
        List<Object[]> partialData = studentRepository.findAllStudentsPartialData();
        for(Object[] objects : partialData) {
            System.out.println(">>>>>>" + objects[0]); // first name column
            System.out.println(">>>>>>" + objects[1]); // last name column
        }
    }

    @Test
    public void testFindAllStudentsByFirstName() {
        studentRepository.findAllStudentsByFirstName("Viet").forEach(student -> {
            System.out.println(">>>>>>" + student);
        });
    }

    @Test
    public void testFindAllStudentsByScores() {
        studentRepository.findStudentsForGivenScores(70, 80).forEach(student -> {
            System.out.println(">>>>>>" + student);
        });
    }

    @Test
    @Transactional
    @Rollback(false) // since this is junit test, we don't want to roll back, but we want to commit
    public void testDeleteStduentsByFirstName() {
        studentRepository.deleteStudentByFirstName("Viet");
    }

    // --------------------------------------------------------------------------------------------
    // pageable and sorting
    @Test
    public void testFindAllStudentsWithPageable() {
        Pageable pageable = PageRequest.of(1, 2);
        studentRepository.findAllStudentsWithPageable(pageable).forEach(student -> {
            System.out.println(">>>>>>" + student);
        });
    }

    @Test
    public void testFindAllStudentsWithPageableAndSorting() {
        Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "id");
        studentRepository.findAllStudentsWithPageable(pageable).forEach(student -> {
            System.out.println(">>>>>>" + student);
        });
    }

    // --------------------------------------------------------------------------------------------
    // NATIVE QUERY
    @Test
    public void testFindAllStudentsNativeQuery() {
        studentRepository.findAllStudentsNativeQuery().forEach(student -> {
            System.out.println(">>>>>>" + student);
        });
    }

    @Test
    public void testFindByFirstNameNativeQuery() {
        studentRepository.findByFirstNameNativeQuery("Bill").forEach(student -> {
            System.out.println(">>>>>>" + student);
        });
    }
}
