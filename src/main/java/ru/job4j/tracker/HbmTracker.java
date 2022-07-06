package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public void init() {
    }

    @Override
    public Item add(Item item) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        int itemsAffected;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            itemsAffected = session.createQuery("update Item i set i.name = :newName,"
                            + " i.description = :newDescription, i.created = :newCreated "
                            + "where i.id = :fId")
                    .setParameter("newName", item.getName())
                    .setParameter("newDescription", item.getDescription())
                    .setParameter("newCreated", item.getCreated())
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
        return itemsAffected > 0;
    }

    @Override
    public boolean delete(int id) {
        int itemsAffected;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            itemsAffected = session.createQuery("delete from Item where id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
        return itemsAffected > 0;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Item");
            for (Object item : query.getResultList()) {
                items.add((Item) item);
            }
            session.getTransaction().commit();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Item i where i.name = :fName")
                    .setParameter("fName", key);
            for (Object item : query.getResultList()) {
                items.add((Item) item);
            }
            session.getTransaction().commit();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            item = (Item) session.createQuery("from Item i where i.id = :fId")
                    .setParameter("fId", id).getSingleResult();
            session.getTransaction().commit();
        }
        return item;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
