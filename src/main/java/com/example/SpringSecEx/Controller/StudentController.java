package com.example.SpringSecEx.Controller;

import com.example.SpringSecEx.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController
{
    public List<Student> students = new ArrayList<>(
            List.of(
                    new Student(201, "Poorna", 24),
                    new Student(202, "Sundar", 28),
                    new Student(203, "Rainaa", 32)
            )
    );

    @GetMapping("/allstudent")
    public List<Student> getStudent()
    {
        return students;
    }

    @PostMapping("/addstudent")
    public void addStudent(@RequestBody Student student)
    {
        students.add(student);
    }

    @GetMapping("/get-csrf-token")
    public CsrfToken getToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
