package AppPackage.controller;

import AppPackage.entity.Teacher;
import AppPackage.service.CourseService;
import AppPackage.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
public class Instructor {

    TeacherService teacherService;
    CourseService courseService;

    @Autowired
    public Instructor(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }

//    @GetMapping
//    public String getAllTeacher(Model model,@RequestParam ("courseId") long id){
//        model.addAttribute("teachers", teacherService.getAll(id));
//        return "instructor/allTeacher";
//    }

    @GetMapping("/newTeacher")
    public String newTeacher(Model model) {
        model.addAttribute("teachers", new Teacher());
        return "instructor/addInstructor";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teachers") Teacher teacher, @RequestParam("courseId") long courseId) throws Exception {
        if (courseService.getById(courseId).getTeacher()==null) {
            teacher.setCourse(courseService.getById(courseId));
            teacherService.create(teacher);
        }else {
            throw new Exception("Jok");
        }
        return "redirect:/group?courseId="+courseId;
    }

    @GetMapping("/deleteTeacher")
    public String deleteTeacher(@RequestParam ("courseId") long courseId,@RequestParam ("teacherId") long id){
        teacherService.deleteById(id);
        return "redirect:/group?courseId="+courseId;
    }

    @GetMapping("/getTeacherById")
    public  String getTeacherById(@RequestParam ("teacherId")long id,Model model){
        model.addAttribute("teacher",teacherService.getById(id));
        return "instructor/updateTeacher";
    }

    @PostMapping("/updateTeacher")
    public String updateTeacher(@ModelAttribute Teacher teacher,@RequestParam ("courseId") long courseId, @RequestParam ("courseId") long id){
        teacher.setCourse(courseService.getById(id));
        teacherService.update(teacher);
        return "redirect:/group?courseId="+courseId;
    }
}
