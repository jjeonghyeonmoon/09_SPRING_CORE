package com.ohgiraffers.common;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("studentRepository")
public class StudentRepositoryImpl implements StudentRepository{

        private final Map<Integer,StudentDTO> studentList;


        public StudentRepositoryImpl(){
            studentList = new HashMap<>();
            studentList.put(1,new StudentDTO(1,17,"문정현"));
            studentList.put(2,new StudentDTO(2,16,"박정현"));

        }

    @Override
    public List<StudentDTO> findAllStudent() {
        return List.of();
    }

    @Override
    public StudentDTO findStudentName(String Name) {
        return null;
    }
}
