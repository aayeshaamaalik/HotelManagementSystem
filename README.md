# Hotel Room Reservation System

This project implements a modular **Hotel Room Reservation System** in Java, using clean object-oriented principles. The system supports room inventory management, reservation requests based on room type and quantity, and custom exception handling when insufficient rooms are available.

---

## Key Components and Interacting Objects

| Class / Component                      | Responsibility                                                          |
| -------------------------------------- | ----------------------------------------------------------------------- |
| `RoomType`                             | Enum representing room categories (e.g., SINGLE, DOUBLE)                |
| `Room`                                 | Represents an individual room with a type and availability flag         |
| `ReservationRequest`                   | User’s request: required room types, quantities, and reservation dates  |
| `Reservation`                          | Confirmed booking including rooms and time period                       |
| `Hotel`                                | Manages rooms, processes reservation requests, and handles availability |
| `NotEnoughRoomForReservationException` | Exception thrown when the room supply is insufficient                   |

---

## Class Hierarchy and Structure

```
Hotel
 ├── List<Room>
 └── createReservation(ReservationRequest) → Reservation or Exception

Reservation
 ├── List<Room> rooms
 ├── Date start, end

ReservationRequest
 ├── Map<RoomType, Integer> roomsNeeded
 ├── Date start, end

Room
 ├── RoomType type
 ├── boolean available
```

---

## Supported Functionalities

1. **Add Rooms to Inventory**
   Rooms of different types can be added to the hotel dynamically.

2. **Create Reservation**
   Accepts a `ReservationRequest` and returns a `Reservation` if enough available rooms exist.

3. **Check Availability and Throw Exceptions**
   If requested rooms cannot be fulfilled, a `NotEnoughRoomForReservationException` is thrown with a clear message.

4. **Rollback Logic on Partial Allocation Failure**
   If allocation partially succeeds but cannot fulfill the full request, previously allocated rooms are freed.

---

## Getting Started

To set up and run the project locally:

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/hotel-reservation-system.git
   ```

2. Navigate into the project directory:

   ```bash
   cd hotel-reservation-system
   ```

3. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse)

4. Compile and run the system.
   Ensure your environment supports **Java 8+**

---

## File Implementation Order

**RoomType → Room → ReservationRequest → Reservation → NotEnoughRoomForReservationException → Hotel**
