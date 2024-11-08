package com.ohgiraffers.common;

import java.util.List;

public interface StudentRepository {

    List<StudentDTO>findAllStudent();

    StudentDTO findStudentName(String Name);
}
