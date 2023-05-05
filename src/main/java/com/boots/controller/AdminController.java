package com.boots.controller;

import com.boots.entity.TablesLevelRegion.Level;
import com.boots.repository.LevelRepository;
import com.boots.service.LevelService;
import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private LevelService levelService;

    @Autowired
    private LevelRepository levelRepository;


    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    /** DELETE **/

    @PostMapping("/admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }

    @PostMapping("/LevelTable")
    public String deleteStudent(@RequestParam(required = true, defaultValue = "" ) Long levelId,
                                @RequestParam(required = true, defaultValue = "" ) String action,
                                Model model) {
        if (action.equals("delete")){
            levelService.deleteLevels(levelId);
        }
        return "redirect:/LevelTable";
    }

    /** ADD **/

    @PostMapping("/LevelTable/add")
    public String studentAdd_Post(@RequestParam String level_name,
                                  Model model){
        Level new_level = new Level(level_name);
        levelRepository.save(new_level);
        return "redirect:/LevelTable";
    }

    /** EDIT **/

//    @PostMapping("/edit")
//    public String bossEditPostMapping(Model model) {
//        return "boss-edit";
//    }

    @PostMapping("/LevelTable/edit")
    public String bossEdit_Post (@RequestParam Long level_id,
                                 @RequestParam String new_level_name,
                                 Model model){
        Level update_level = levelRepository.findById(level_id).orElseThrow();
        update_level.setName(new_level_name);
        levelRepository.save(update_level);
        return "redirect:/LevelTable";
    }

    /** Other **/

    @GetMapping("/add")
    public String levelAdd(Model model) {
        return "levelAdd";
    }

    @GetMapping("/edit")
    public String levelEdit(Model model) {
        return "levelEdit";
    }

    @GetMapping("/admin/gt/{userId}")
    public String  gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "admin";
    }

    @GetMapping("/LevelTable")
    public String bossList(Model model) {
        model.addAttribute("allLevels", levelService.allLevels());
        return "LevelTable";
    }
}
