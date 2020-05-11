package repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.UserModel;
import connection.HibernateUtil;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * CRUD database operations
 * @author Ramesh Fadatare
 *
 */
public class UserRepository {

    /**
     * Save User
     * @param user
     */
    public void saveUser(UserModel user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update User
     * @param user
     */
    public void updateUser(UserModel user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete User
     * @param id
     */
    public void deleteUser(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete a user object
            UserModel user = session.get(UserModel.class, id);
            if (user != null) {
                session.delete(user);
                System.out.println("user is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get User By ID
     * @param id
     * @return
     */
    public UserModel getUser(int id) {

        Transaction transaction = null;
        UserModel user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = session.get(UserModel.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Get User By EMAIL
     * @param email
     * @return
     */
    public UserModel getUserByEmail(String email) {

        Transaction transaction = null;
        UserModel user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<UserModel> cr = cb.createQuery(UserModel.class);
            Root<UserModel> root = cr.from(UserModel.class);
            cr.select(root).where(cb.equal(root.get("email"), email));
            Query<UserModel> query = session.createQuery(cr);
            query.setMaxResults(1);
            List<UserModel> result = query.getResultList();
            if(result.size() == 1) {
                user = result.get(0);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Get all Users
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<UserModel> getAllUser() {

        Transaction transaction = null;
        List<UserModel> listOfUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfUser = session.createQuery("from UserModel").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUser;
    }
}
