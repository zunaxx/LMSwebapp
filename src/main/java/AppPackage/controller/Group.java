package AppPackage.controller;

import AppPackage.service.CourseService;
import AppPackage.service.GroupService;
import AppPackage.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/group")
public class Group {

    GroupService groupService;
    CourseService courseService;
    TeacherService teacherService;

    @Autowired
    public Group(GroupService groupService, CourseService courseService, TeacherService teacherService) {
        this.groupService = groupService;
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @GetMapping("/newGroup")
    public String newGroup(Model model){
        model.addAttribute("group",new AppPackage.entity.Group());
        return "group/addGroup";
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@RequestParam ("courseId") long courseId,@ModelAttribute("group") AppPackage.entity.Group group){
        group.setCourse(courseService.getById(courseId));
        groupService.create(group);
        return "redirect:/group?courseId="+courseId;
    }

    @GetMapping("/getGroupById")
    public String getGroupById(@RequestParam ("groupId")long id,Model model){
        model.addAttribute("group",groupService.getById(id));
        return "/group/updateGroup";
    }

    @PostMapping("/updateGroup")
    public String updateGroup(@RequestParam ("courseId") long courseId,@ModelAttribute AppPackage.entity.Group group){
        groupService.update(group);
        return "redirect:/group?courseId="+courseId;
    }

    @GetMapping("/deleteGroup")
    public String deleteGroup(@RequestParam ("courseId") long courseId,@RequestParam ("groupId") long groupId){
        groupService.deleteById(groupId);
        return "redirect:/group?courseId="+courseId;
    }
    @GetMapping()
    public String groupAndTeacher(@RequestParam("courseId") long courseId,Model model){
        model.addAttribute("groups",groupService.getAll(courseId));
        model.addAttribute("teachers",teacherService.getAll(courseId));
        return "/course/groupAndTeacher";
    }
}
