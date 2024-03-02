package ru.netology.springdaoapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DaoRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String product;

    @Autowired
    public DaoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.product = read("getproduct.sql");
    }

    public List<String> getProductName(String name) {
        return namedParameterJdbcTemplate.queryForList(product, Map.of("name", name), String.class);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}