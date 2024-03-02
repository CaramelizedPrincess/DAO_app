package ru.netology.springdaoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springdaoapp.repository.DaoRepository;

import java.util.List;

@RestController
public class DaoController {
    private final DaoRepository DaoRepository;

    public DaoController(DaoRepository DaoRepository) {
        this.DaoRepository = DaoRepository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> fetchProduct(@RequestParam("name") String name) {
        return DaoRepository.getProductName(name);
    }
}