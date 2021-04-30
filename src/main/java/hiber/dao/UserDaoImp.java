package hiber.dao;

import hiber.model.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   public UserDaoImp(@Autowired SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }



   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("select  u from User u", User.class);
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("uncheked")
   public List<User> findCar(String model, int series){
      return (List<User>) sessionFactory.getCurrentSession()
              .createQuery("select  u from  User u where  u.car.model = :model and u.car.series = :series")
              .setParameter("model", model)
               .setParameter("series", series)
              .list();
   }






}
