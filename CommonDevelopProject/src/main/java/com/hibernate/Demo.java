package com.hibernate;

import org.h2.tools.RunScript;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Demo {
    private static final String JDBC_URL = "jdbc:h2:mem:DBName;DB_CLOSE_DELAY=-1";
    private static final String USER = "user";
    private static final String PASSWORD = "1234";
    private static final String DRIVER_CLASS = "org.h2.Driver";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_CLASS);
        Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        Demo demo = new Demo();
        demo.runScript(conn);
        System.out.println(demo.readAllStudent());
        System.exit(0);
    }

    public SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Grade.class)
                .buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public List<Student> readAllStudent() {
        Session session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<Student> employees = session.createQuery("from Student").list();
        session.close();
        System.out.println("Found " + employees.size() + " Employees");
        return employees;
    }

    public List<Grade> readAllGrade() {
        Session session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<Grade> employees = session.createQuery("from Grade").list();
        session.close();
        System.out.println("Found " + employees.size() + " Employees");
        return employees;
    }

    public Student findByID(Integer id) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Student e = (Student) session.load(Student.class, id);
            return e;
        }finally {
            session.close();
        }
    }

    public void runScript(Connection conn){
        try {
            URI url = this.getClass().getClassLoader().getResource("h2/DDL.sql").toURI();
            URI url2 = this.getClass().getClassLoader().getResource("h2/DML.sql").toURI();
            Reader reader = new FileReader(Paths.get(url).toFile());
            Reader reader2 = new FileReader(Paths.get(url2).toFile());
            RunScript.execute(conn,reader);
            RunScript.execute(conn,reader2);
        } catch (FileNotFoundException | SQLException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
