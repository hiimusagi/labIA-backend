package com.labia.gradeReport.dao;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@AllArgsConstructor
@Service
public class EntityManagerDao {
    private EntityManager entityManager;

    public StringBuilder sqlBuilder() {
        return new StringBuilder();
    }

    public Session session() {
        return entityManager.unwrap(Session.class);
    }
}
