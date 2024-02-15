/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kiubit.kiubitWebAPI.daos.impl;

import com.kiubit.kiubitWebAPI.daos.BaseDao;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;

/**
 *
 * @author DesarrolloDB
 */
@Repository
public class BaseDaoJpa implements BaseDao {
    protected static final int RESULT_SUCCESS = 0;
    protected static final int RESULT_SPD_EXISTS = -1;

    protected static final String SUCCESS_MESSAGE = "OK";
    protected static final int SUCCESS_RESULT = 0;

    protected SessionFactory sessionFactory;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public <T> T findById(Class<T> type, Serializable id) {
        return entityManager.find(type, id);
    }

    @Override
    public <T> List<T> findAll(Class<T> type) {
        return findManyByCriterias(type, (builder, criteria, root) -> {
        });
    }

    protected boolean hasFilterValue(String value) {
        return (value != null && !value.trim().isEmpty() && !value.trim().equals("%"));
    }

    public <T extends Object> T findOneByCriterias(Class<T> type, CriteriaInteractor<T> interactor) {
        return findManyByCriterias(type, interactor)
                .stream()
                .findFirst()
                .orElse(null);
    }

    public <T extends Object> List<T> findManyByCriterias(Class<T> type, CriteriaInteractor<T> interactor) {
        return findManyByCriterias(type, null, interactor);
    }

    public <T extends Object> List<T> findManyByCriterias(Class<T> type, Integer maxResults,
            CriteriaInteractor<T> interactor) {
        return typedQueryByCriterias(type, maxResults, interactor)
                .getResultList();
    }

    public <T extends Object> TypedQuery typedQueryByCriterias(Class<T> type, Integer maxResults,
            CriteriaInteractor<T> interactor) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);

        Root<T> root = criteria.from(type);
        interactor.addCriterias(builder, criteria, root);

        TypedQuery<T> query = entityManager
                .createQuery(criteria);

        if (maxResults != null) {
            query.setMaxResults(maxResults);
        }

        return query;
    }

    protected String spBoolValue(Boolean value) {
        return value == null ? null : (value ? "Y" : "N");
    }

    public interface CriteriaInteractor<T> {

        void addCriterias(CriteriaBuilder builder, CriteriaQuery<T> criteria, Root<T> root);
    }

    protected Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        // session.setFlushMode(FlushMode.MANUAL);
        return session;
    }

    protected Connection getConnection() {
        return ((SessionImpl) getSession()).unwrap(Connection.class);
    }

    protected void closeCallableStatement(CallableStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDaoJpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
