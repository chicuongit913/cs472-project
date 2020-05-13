package repositories;

import connection.HibernateUtil;
import models.RoomModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * CRUD database operations
 * @author Ramesh Fadatare
 *
 */
public class RoomRepository {

    /**
     * Save Room
     * @param room
     */
    public void newRoom(RoomModel room) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(room);
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
     * Update Room
     * @param room
     */
    public void updateRoom(RoomModel room) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(room);
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
     * Delete Room
     * @param id
     */
    public void deleteRoom(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete a user object
            RoomModel room = session.get(RoomModel.class, id);
            if (room != null) {
                session.delete(room);
                System.out.println("room is deleted");
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
     * Get Room By Confirmation# / ID
     * @param id
     * @return RoomModel
     */
    public RoomModel getRoom(int id) {

        Transaction transaction = null;
        RoomModel room = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an room object
            room = session.get(RoomModel.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return room;
    }

    /**
     * Get all Room
     * @return List<RoomModel>
     */
    @SuppressWarnings("unchecked")
    public List<RoomModel> getAllRoom() {

        Transaction transaction = null;
        List<RoomModel> listOfRoom = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // get an room object
            listOfRoom = session.createQuery("from RoomModel").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfRoom;
    }
}
