package su.pos.sevice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import su.pos.domain.User;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kochetkov_V on 04.02.2016.
 */
@Repository
@EnableTransactionManagement

public class UserDaoImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public User getUser(int id) {
        Session session= sessionFactory.getCurrentSession();
        User user =session.get(User.class, id);
        return user;
    }
    @Transactional
    public void setUser(User user) {
        if (user!=null || user.getName()!=null){
        Session session= sessionFactory.getCurrentSession();
        session.persist(user);}
    }
    @Transactional
    public List<User> getUsers(int page, int count) {
        Session session= sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        List<User> pagedList = new LinkedList<>();
        for (int i = (page-1)* count; i<page* count; i++)
        {
            if (i<userList.size()) pagedList.add(userList.get(i));
        }

        return pagedList;
    }

    @Transactional
    public List<User> getAll() {
        Session session= sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        return userList;
    }

    @Transactional
    public void removeUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        if(null != user){
            session.delete(user);
        }
    }
    @Transactional
    public void editUser(User user) {
        Session session=sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    @Transactional
    public List<User> findByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User where name= :name").setParameter("name",name).list();
        return userList;
    }

    @Override
    @Transactional
    public List<User> findPagedByName(String name,int page, int count) {
        List<User> userList = findByName(name);
        List<User> pagedList = new LinkedList<>();
        for (int i=(page-1)*count; i<page*count; i++)
        {
            if (i<userList.size()) pagedList.add(userList.get(i));
        }
        return pagedList;
    }

}
