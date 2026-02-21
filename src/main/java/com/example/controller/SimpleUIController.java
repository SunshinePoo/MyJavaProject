package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleUIController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/display")
    public String display(@RequestParam(value = "text", required = false) String text, Model model) {
        if (text == null || text.trim().isEmpty()) {
            model.addAttribute("output", "Please enter some text!");
            model.addAttribute("outputColor", "error");
        } else {
            model.addAttribute("output", "You typed: " + text);
            model.addAttribute("outputColor", "success");
        }
        return "index";
    }
}
