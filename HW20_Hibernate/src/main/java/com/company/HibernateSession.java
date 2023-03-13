package com.company;

import com.company.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HibernateSession {

    private static final String CONFIG_PATH = "src/main/resources/hibernate.properties";

    private static HibernateSession hibernateSession;

    private final SessionFactory sessionFactory;

    private HibernateSession() {
        sessionFactory = buildFactory();
    }

    public static HibernateSession getInstance() {
        if (hibernateSession == null) {
            init();
        }
        return hibernateSession;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private SessionFactory buildFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.setProperties(getProperties());
            configuration.addAnnotatedClass(Student.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static synchronized void init() {
        if (hibernateSession == null) {
            hibernateSession = new HibernateSession();
        }
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_PATH))) {
            properties.load(reader);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
