package AppPackage.controller;

import AppPackage.service.CompanyService;
import AppPackage.service.CourseService;
import AppPackage.service.GroupService;
import AppPackage.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")
public class Course {

    private final CourseService courseService;
    private final CompanyService companyService;
    private final TeacherService teacherService;
    private final GroupService groupService;

    @Autowired
    public Course(CourseService courseService, CompanyService companyService, TeacherService teacherService, GroupService groupService) {
        this.courseService = courseService;
        this.companyService = companyService;
        this.teacherService = teacherService;
        this.groupService = groupService;
    }

    @GetMapping()
    public String getAllCourse(Model model, @RequestParam("companyId") long id) {
        model.addAttribute("courses", courseService.getAll(id));
        return "course/getAllCourse";
    }

    @GetMapping("/newCourse")
    public String newCourse(Model model) {
        model.addAttribute("courses", new AppPackage.entity.Course());
        return "course/addCourse";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute AppPackage.entity.Course course, @RequestParam("companyId") long id, Model model) {
        course.setCompany(companyService.getById(id));
        courseService.create(course);
        model.addAttribute("courses", courseService.getAll(id));
        return "course/getAllCourse";
    }

    @RequestMapping("/getCourseById")
    public String getCourseById(Model model, @RequestParam("courseId") long id) {
        model.addAttribute("courseUpdate", courseService.getById(id));
        return "course/updateCourse";
    }

    @RequestMapping("/updateCourse")
    public String updateCourse(@ModelAttribute AppPackage.entity.Course course, @RequestParam("companyId") long companyId) {
        course.setCompany(companyService.getById(companyId));
        courseService.update(course);
        return "redirect:/course?companyId="+companyId;
    }

    @GetMapping("/deleteCourseById")
    public String deleteCourseById(@RequestParam("companyId") long companyId,@RequestParam("courseId") long id) {
        courseService.deleteById(id);
        return "redirect:/course?companyId="+companyId;
    }
}
