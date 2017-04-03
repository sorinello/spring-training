package org.sorinb.spring.training.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sorinb.spring.training.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * Created by sorinello on 3/31/17.
 */
@Repository
public class UserRepositoryDao implements UserRepository {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void save(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("##### save(User user) has been run");
    }
}
