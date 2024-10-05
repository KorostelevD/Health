package com.example.Health.data.services;

import com.example.Health.models.ProgramNews;

import java.util.List;

public interface ProgramNewsService {
    List<ProgramNews> getAllNews();
    ProgramNews addNews(ProgramNews news);
}
