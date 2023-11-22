package AppPackage.controller;

import AppPackage.service.GroupService;
import AppPackage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class Student {

    StudentService studentService;
    GroupService groupService;

    @Autowired
    public Student(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping("/newStudent")
    public String newStudent(Model model){
        model.addAttribute("student",new AppPackage.entity.Student());
        return "student/addStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute AppPackage.entity.Student student,@RequestParam("groupId") long groupId){
        student.setGroup(groupService.getById(groupId));
        studentService.create(student);
        return "redirect:/student?groupId="+groupId;
    }

    @GetMapping()
    public String getAllStudent(Model model,@RequestParam("groupId") long groupId){
        model.addAttribute("students",studentService.getAll(groupId));
        return "student/allStudents";
    }

    @GetMapping("/getStudentById")
    public String getStudentById(Model model,@RequestParam("studentId") long studentId){
        model.addAttribute("student",studentService.getById(studentId));
        return "student/updateStudent";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute AppPackage.entity.Student student,@RequestParam("groupId") long groupId){
        student.setGroup(groupService.getById(groupId));
        studentService.update(student);
        return "redirect:/student?groupId="+groupId;
    }
    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("groupId") long groupId,@RequestParam("studentId") long studentId){
        studentService.deleteById(studentId);
        return"redirect:/student?groupId="+groupId;
    }
}
