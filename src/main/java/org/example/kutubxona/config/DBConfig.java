package org.example.kutubxona.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.example.kutubxona.entity.Admin;
import org.example.kutubxona.entity.Book;

import static org.example.kutubxona.repo.BaseRepo.entityManagerFactory;
import static org.example.kutubxona.repo.BaseRepo.entityManager;


@WebListener
public class DBConfig implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        entityManagerFactory= Persistence.createEntityManagerFactory("default");

        entityManagerFactory=Persistence.createEntityManagerFactory("library");
        entityManager=entityManagerFactory.createEntityManager();
        //initData();
        ServletContextListener.super.contextInitialized(sce);

    }
    private void initData() {
        entityManager.getTransaction().begin();
        Book book1= Book.builder()
                .name("O`tgan kunlar")
                .authorName("Abdulla Qodiriy")
                .build();
        entityManager.persist(book1);

        Book book2= Book.builder()
                .name("Mehrobdan chayon")
                .authorName("Abdulla Qodiriy")
                .build();
        entityManager.persist(book2);
        Book book3= Book.builder()
                .name("Shum bola")
                .authorName("O`tkir Hoshimov")
                .build();
        entityManager.persist(book3);
        Book book4= Book.builder()
                .name("SAriq devn minib")
                .authorName("Xudoyberdi to`xtaboyev")
                .build();
        entityManager.persist(book4);


        Admin admin= Admin.builder()
                .name("Javohir")
                .email("a@gmail.com")
                .password("root123")

                .build();
        entityManager.persist(admin);
        entityManager.getTransaction().commit();
    }
}
