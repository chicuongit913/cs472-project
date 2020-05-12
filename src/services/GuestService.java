package services;

import models.GuestModel;
import repositories.GuestRepository;

import java.util.List;

public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService() {
        this.guestRepository = new GuestRepository();
    }

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public void createGuest(GuestModel guestModel) {
        this.guestRepository.createGuest(guestModel);
    }

    public void updateGuest(GuestModel guestModel) {
        this.guestRepository.updateGuest(guestModel);
    }

    public void deleteGuest(int id) {
        this.guestRepository.deleteGuest(id);
    }

    public GuestModel getGuest(int id) {
        return this.guestRepository.getGuest(id);
    }

    public GuestModel getGuestByEmail(String email) {
        return this.guestRepository.getGuestByEmail(email);
    }

    public GuestModel getGuestByPhoneNumber(String phoneNumber) {
        return this.guestRepository.getGuestByPhoneNumber(phoneNumber);
    }

    public List<GuestModel> getAllGuest() {
        return this.guestRepository.getAllGuest();
    }
}
