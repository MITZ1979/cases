package com.nf.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class SessionUtil {
    private SessionFactory sessionFactory;
    private static SessionUtil instance;

    private SessionUtil() {
        /* hibernate3or5 */
        Configuration configuration = new Configuration();
        configuration.configure("com/nf/hibernate/util/hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();

        /* hibernate4 */
        /**
        Configuration configure = new Configuration().configure();
        //
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();
        //
        sessionFactory = configure.buildSessionFactory(serviceRegistry);
        **/
    }
    public static SessionUtil getInstance(){
        if(instance == null){
            instance = new SessionUtil();
        }
        return instance;
    }
    public static SessionFactory getSessionFactory(){
        return getInstance().sessionFactory;
    }
    public static Session getSession(){
        return getSessionFactory().openSession();
    }
}
