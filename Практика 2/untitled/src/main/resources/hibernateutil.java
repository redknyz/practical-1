import org.hibernate.SessionFactory;
import org.hibernate.cfg.xml;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Конфигурация Hibernate из hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
/*
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
<session-factory>
<property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
<property name="connection.url">jdbc:mysql://localhost/experiment</property>
<property name="connection.username">root</property>
<property name="connection.password">12345</property>
<property name="hibernate.dialect">org.hibernate.dialect.MySQL57Dialect</property>
<property name="hibernate.hbm2ddl.auto">update</property>

</session-factory>
</hibernate-configuration>=
 */