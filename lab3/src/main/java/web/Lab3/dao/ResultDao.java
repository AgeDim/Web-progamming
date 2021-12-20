package web.Lab3.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import web.Lab3.HibernateSessionFactoryUtil;
import web.Lab3.entity.Result;

import java.util.List;

public class ResultDao {

    public void save(Result result) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(result);
        transaction.commit();
        session.close();
    }

    public List<Result> findAll() {
        return (List<Result>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Result ").list();
    }

    public void deleteAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE FROM Result ").executeUpdate();
        transaction.commit();
        session.close();
    }
}
