package org.example.kutubxona.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseRepo<T, I> {


    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();


    public Class<T> persistenceClass;

    public BaseRepo() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        this.persistenceClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    public void begin() {
        entityManager.getTransaction().begin();
    }

    public void commit() {
        entityManager.getTransaction().commit();
    }

    public void save(T t) {
        begin();
        entityManager.persist(t);
        commit();
    }

    public List<T> findAll() {
        return entityManager.createQuery("from " + persistenceClass.getSimpleName(), persistenceClass).getResultList();
    }

    public T findById(I id) {
        return entityManager.find(persistenceClass, id);
    }
    public void delete(I id) {
        begin();
        T t = entityManager.find(persistenceClass, id);
        entityManager.remove(t);
        commit();
    }
}

//public class BaseRepo<T,I> {
//    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
//    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//    public static void begin() {
//        entityManager.getTransaction().begin();
//    }
//
//    public static void commit() {
//        entityManager.getTransaction().commit();
//    }
//
//    private final Class<T> persistanceClass;
//
//    public BaseRepo() {
//        this.persistanceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getClass();
//    }
//    public  void save(T t) {
//        begin();
//        entityManager.persist(t);
//        commit();
//    }
//    public List<T> findAll() {
//        return entityManager.createQuery("FROM " + persistanceClass.getSimpleName(), persistanceClass).getResultList();
//    }
//
//    public void findById(I id) {
//         entityManager.find(persistanceClass, id);
//    }public void deleteById(I id) {
//        begin();
//        T t = entityManager.find(persistanceClass, id);
//        entityManager.remove(t);
//        commit();
//    }
//}
