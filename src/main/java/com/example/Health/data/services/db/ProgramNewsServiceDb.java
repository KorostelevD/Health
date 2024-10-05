package com.example.Health.data.services.db;

import com.example.Health.data.repositories.ProgramNewsRepository;
import com.example.Health.data.services.ProgramNewsService;
import com.example.Health.models.ProgramNews;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class ProgramNewsServiceDb implements ProgramNewsService {
    private final ProgramNewsRepository programNewsRepository ;

    @Autowired
    public ProgramNewsServiceDb(ProgramNewsRepository programNewsRepository) {
        this.programNewsRepository = programNewsRepository;
    }

    @Override
    public List<ProgramNews> getAllNews() {
        return programNewsRepository.findAll();
    }

    @Override
    public ProgramNews addNews(ProgramNews news) {
        news.setCreatedAt(LocalDate.now());
        news.setUpdatedAt(LocalDate.now());
        return programNewsRepository.save(news);
    }
}
