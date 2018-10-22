package com.vietle.productdata.jpqlandnativesql.repos;

import com.vietle.productdata.jpqlandnativesql.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    // JPQL
    // select * from Student
    // Student is the entity not the table name
    @Query("from Student")
    List<Student> findAllStudents();

    // st is the alias to Student
    @Query("select st.firstName, st.lastName from Student st")
    List<Object[]> findAllStudentsPartialData();

    @Query("from Student where firstName=:fName")
    List<Student> findAllStudentsByFirstName(@Param("fName") String fName);

    @Query("from Student where score>:min and score<:max")
    List<Student> findStudentsForGivenScores(@Param("min") int min, @Param("max") int max);

    @Modifying // this query is a modify database, delete, update
    @Query("delete from Student where firstName=:fName") // you can also do update
    void deleteStudentByFirstName(@Param("fName") String fName);

    // --------------------------------------------------------------------------------------------
    // pageable and sorting using JPQL
    @Query("from Student")
    List<Student> findAllStudentsWithPageable(Pageable pageable);

    // --------------------------------------------------------------------------------------------
    // NATIVE QUERY
    // student is the table name
    @Query(value = "select * from student", nativeQuery = true)
    List<Student> findAllStudentsNativeQuery();

    @Query(value = "select * from student where fname=:firstName", nativeQuery = true)
    List<Student> findByFirstNameNativeQuery(@Param("firstName") String firstName);

}
