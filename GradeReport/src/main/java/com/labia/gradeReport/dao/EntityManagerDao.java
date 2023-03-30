package com.labia.gradeReport.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EntityManagerDao {
	private EntityManager entityManager;

    public StringBuilder sqlBuilder() {
        return new StringBuilder();
    }

    public Session session() {
        return entityManager.unwrap(Session.class);
    }
}
