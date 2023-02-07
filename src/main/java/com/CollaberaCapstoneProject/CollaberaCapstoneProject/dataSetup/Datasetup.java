package com.CollaberaCapstoneProject.CollaberaCapstoneProject.dataSetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Datasetup {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE movies (movieId SERIAL PRIMARY KEY, title VARCHAR(255), similarity DECIMAL(5,2))");
    }
}
