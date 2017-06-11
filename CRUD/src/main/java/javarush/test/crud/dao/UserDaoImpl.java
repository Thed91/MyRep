package javarush.test.crud.dao;

import javarush.test.crud.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        logger.info("Add User: "+user);
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class,id);
        if (user!=null){
            session.delete(user);
            logger.info("Remove User: "+user);
        }
    }

    @Override
    public User updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("Update User: "+user);
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
        List<User> list =(List<User>) session.createQuery("from User ").setFirstResult(maxRecords*page).setMaxResults(maxRecords).list();
        for (User user:list) {
            logger.info("User list: "+user);
        }
        return list;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> searchUsers(String name) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.like("name","%"+name+"%"));
        List<User>list=(List<User>) criteria.list();
        for (User user:list){
            logger.info("Search User list: "+user);
        }
        return list;
    }

    @Override
    @SuppressWarnings("unchecked")
    public int getRecords() {
        Session session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        return userList.size();
    }

}
