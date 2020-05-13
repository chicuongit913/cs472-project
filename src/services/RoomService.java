package services;

import models.RoomModel;
import repositories.RoomRepository;

import java.util.List;

public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomService(){
        this.roomRepository = new RoomRepository();
    }

    public List<RoomModel> getAllRoom() {
        return this.roomRepository.getAllRoom();
    }

    public void deleteRoom(int id) {
        this.roomRepository.deleteRoom(id);
    }

    public void newRoom(RoomModel room) {
        this.roomRepository.newRoom(room);
    }

    public void updateRoom(RoomModel room) {
        this.roomRepository.updateRoom(room);
    }

    public RoomModel getRoom(int id){return this.roomRepository.getRoom(id);}

}
