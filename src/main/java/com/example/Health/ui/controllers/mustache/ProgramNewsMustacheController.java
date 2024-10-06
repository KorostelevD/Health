package com.example.Health.ui.controllers.mustache;


import com.example.Health.data.services.ProgramNewsService;
import com.example.Health.models.ProgramNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ProgramNewsMustacheController {

    private final ProgramNewsService programNewsService;

    @Autowired
    public ProgramNewsMustacheController(ProgramNewsService programNewsService) {
        this.programNewsService = programNewsService;
    }

    // Метод для завантаження сторінки з новинами
    @GetMapping("programnews")
    public String getProgramNewsPage(Model model) {
        List<ProgramNews> newsList = programNewsService.getAllNews();
        model.addAttribute("newsList", newsList);
        return "mustache/programNews";
    }

    // Метод для додавання нової новини
    @PostMapping("/programNewsForm")
    public String addProgramNews(@ModelAttribute ProgramNews news) {
        programNewsService.addNews(news);
        return "redirect:programnews";
    }
}
