package repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.GuestModel;
import connection.HibernateUtil;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * CRUD database operations
 */
public class GuestRepository {
    /**
     * Create Guest
     *
     * @param guest
     */
    public void createGuest(GuestModel guest) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the guest object
            session.save(guest);
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
     * Update Guest
     *
     * @param guest
     */
    public void updateGuest(GuestModel guest) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // update the guest object
            session.update(guest);
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
     * Delete Guest
     *
     * @param id
     */
    public void deleteGuest(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete the guest object
            GuestModel guest = session.get(GuestModel.class, id);
            if (guest != null) {
                session.delete(guest);
                System.out.println("guest is deleted");
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
     * Get Guest By Id
     *
     * @param id
     * @return GuestModel
     */
    public GuestModel getGuest(int id) {
        Transaction transaction = null;
        GuestModel guest = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get the guest object
            guest = session.get(GuestModel.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return guest;
    }

    /**
     * Get Guest By Email
     *
     * @param email
     * @return GuestModel
     */
    public GuestModel getGuestByEmail(String email) {
        Transaction transaction = null;
        GuestModel guest = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get the guest object
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<GuestModel> cr = cb.createQuery(GuestModel.class);
            Root<GuestModel> root = cr.from(GuestModel.class);
            cr.select(root).where(cb.equal(root.get("email"), email));
            Query<GuestModel> query = session.createQuery(cr);
            query.setMaxResults(1);
            List<GuestModel> result = query.getResultList();
            if (result.size() == 1) {
                guest = result.get(0);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return guest;
    }

    /**
     * Get Guest By Phone Number
     *
     * @param phoneNumber
     * @return GuestModel
     */
    public GuestModel getGuestByPhoneNumber(String phoneNumber) {
        Transaction transaction = null;
        GuestModel guest = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get the guest object
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<GuestModel> cr = cb.createQuery(GuestModel.class);
            Root<GuestModel> root = cr.from(GuestModel.class);
            cr.select(root).where(cb.equal(root.get("phoneNumber"), phoneNumber));
            Query<GuestModel> query = session.createQuery(cr);
            query.setMaxResults(1);
            List<GuestModel> result = query.getResultList();
            if (result.size() == 1) {
                guest = result.get(0);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return guest;
    }

    /**
     * Get All Guest
     *
     * @return List<GuestModel>
     */
    @SuppressWarnings("unchecked")
    public List<GuestModel> getAllGuest() {
        Transaction transaction = null;
        List<GuestModel> listOfGuest = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get the guest object list
            listOfGuest = session.createQuery("from GuestModel").getResultList();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfGuest;
    }
}