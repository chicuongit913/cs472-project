package repositories;

import connection.HibernateUtil;
import models.BookingModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 * CRUD database operations
 * @author Ramesh Fadatare
 *
 */
public class BookingRepository {

    /**
     * Save Booking
     * @param booking
     */
    public void newBooking(BookingModel booking) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(booking);
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
     * Update Booking
     * @param booking
     */
    public void updateBooking(BookingModel booking) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(booking);
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
     * Delete Booking
     * @param id
     */
    public void deleteBooking(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete a user object
            BookingModel booking = session.get(BookingModel.class, id);
            if (booking != null) {
                session.delete(booking);
                System.out.println("booking is deleted");
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
     * Get Booking By Confirmation# / ID
     * @param id
     * @return BookingModel
     */
    public BookingModel getBooking(int id) {

        Transaction transaction = null;
        BookingModel booking = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an booking object
            booking = session.get(BookingModel.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return booking;
    }

    /**
     * Get all Users
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<BookingModel> getAllBooking() {

        Transaction transaction = null;
        List<BookingModel> listOfBooking = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // get an booking object
            listOfBooking = session.createQuery("from BookingModel").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfBooking;
    }
}
