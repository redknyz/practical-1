package com.dev;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        class ChemicalSample {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private int idchemical_samples;
            private String name;
            private int quantity;

            public int getName() {
                return 0;
            }

            // constructors, getters, setters
        }

        @Entity
        @Table(name = "crews")
        class Crew {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private int idcrews;
            private String name;
            private int members;

            public int getName() {
                return 0;
            }

            // constructors, getters, setters
        }

        interface ChemicalSampleRepository extends JpaRepository<ChemicalSample, Integer> {
            default List<ChemicalSample> findAll() {
                return null;
            }
            // additional methods if needed
        }

        interface CrewRepository extends JpaRepository<Crew, Integer> {
            default List<Crew> findAll() {
                return null;
            }
            
        }

        class MainApplication {
            public void main(String[] args) {
                // Создаем фабрику сессий для Hibernate
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");

                // Создаем экземпляры репозиториев
                ChemicalSampleRepository chemicalSampleRepository = (ChemicalSampleRepository) new ChemicalSampleRepositoryImpl(entityManagerFactory);
                CrewRepository crewRepository = (CrewRepository) new CrewRepositoryImpl(entityManagerFactory);

                // Получаем список объектов ChemicalSample из БД
                List<ChemicalSample> chemicalSamples = chemicalSampleRepository.findAll();

                
                for (ChemicalSample chemicalSample : chemicalSamples) {
                    System.out.println(chemicalSample.getName());
                }

                
                List<Crew> crews = crewRepository.findAll();

               
                for (Crew crew : crews) {
                    System.out.println(crew.getName());
                }

                
                entityManagerFactory.close();
            }
        }
        transaction.commit();
        session.close();
    }
}
