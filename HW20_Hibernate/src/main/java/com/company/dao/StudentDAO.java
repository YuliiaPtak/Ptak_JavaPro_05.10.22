package com.company.dao;

import com.company.HibernateSession;
import com.company.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {
    public void add(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    public void delete(long id) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Student student = getById(id);
            session.delete(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    public void update(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateSession.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    public Student getById(long id) {
        try (Session session = HibernateSession.getInstance().getSessionFactory().openSession()) {
            return session.get(Student.class, id);
        }
    }

    public List<Student> getAll() {
        try (Session session = HibernateSession.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }
}
