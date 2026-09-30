package com.example.schoolmangment.Service;

import com.example.schoolmangment.Api.ApiException;
import com.example.schoolmangment.Model.Teacher;
import com.example.schoolmangment.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;


    public List<Teacher>getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id,Teacher teacher){
        Teacher oldTeacher=teacherRepository.findTeacherById(id);
        if(oldTeacher==null){
            throw new ApiException("teacher not found");
        }
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }


    public void deleteTeacher(Integer id){
     Teacher teacher=teacherRepository.findTeacherById(id);
     if(teacher==null){
         throw new ApiException("Teacher not found");
     }
     teacherRepository.delete(teacher);
    }


    public Teacher getTeacherDetails(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("teacher not found");
        }
        return teacher;
    }













}
