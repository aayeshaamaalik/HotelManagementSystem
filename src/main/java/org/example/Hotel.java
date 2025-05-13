package org.example;
import java.util.*;

public class Hotel {
    private List<Room> rooms;

    public Hotel() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Reservation createReservation(ReservationRequest request) throws NotEnoughRoomForReservationException {
        List<Room> reservedRooms = new ArrayList<>();
        Map<RoomType, Integer> roomsNeeded = request.getRoomsNeeded();
        Map<RoomType, Integer> roomsAllocated = new HashMap<>();

        // Initialize allocated count
        for (RoomType type : roomsNeeded.keySet()) {
            roomsAllocated.put(type, 0);
        }

        for (Room room : rooms) {
            if (!room.isAvailable()) continue;

            RoomType type = room.getType();
            if (roomsNeeded.containsKey(type) &&
                    roomsAllocated.get(type) < roomsNeeded.get(type)) {

                room.setAvailable(false);
                reservedRooms.add(room);
                roomsAllocated.put(type, roomsAllocated.get(type) + 1);
            }
        }

        // Verify if all required rooms were allocated
        for (RoomType type : roomsNeeded.keySet()) {
            if (!roomsAllocated.get(type).equals(roomsNeeded.get(type))) {
                // Roll back allocation
                for (Room r : reservedRooms) r.setAvailable(true);
                throw new NotEnoughRoomForReservationException("Not enough " + type + " rooms available.");
            }
        }

        return new Reservation(reservedRooms, request.getStart(), request.getEnd());
    }
}

