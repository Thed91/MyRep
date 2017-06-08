package javarush.test.crud.dao;

import javarush.test.crud.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class,id);
        if (user!=null){
            session.delete(user);
        }
    }

    @Override
    public User updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        return user;
    }

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (User)session.get(User.class,id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers(int maxRecords,int page) {
        Session session = sessionFactory.getCurrentSession();
        return (List<User>) session.createQuery("from User ").setFirstResult(maxRecords*page).setMaxResults(maxRecords).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> searchUsers(String name) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.like("name","%"+name+"%"));
        return (List<User>) criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public int getRecords() {
        Session session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        return userList.size();
    }

}
