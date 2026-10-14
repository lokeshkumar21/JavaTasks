package com;

public class CinemaService {
    public void bookTicket(int availableSeats, int requiredSeats) throws CustomException {

        if (requiredSeats <= 0) {
            throw new CustomException(
                    new ErrorMessage(
                            "CIN_001",
                            "Invalid seat count",
                            "Number of seats must be greater than zero"
                    )
            );
        }

        if (requiredSeats > availableSeats) {
            throw new CustomException(
                    new ErrorMessage(
                            "CIN_002",
                            "Not enough seats available",
                            "Available seats: " + availableSeats
                    )
            );
        }

        System.out.println("Ticket booked successfully!");
    }
}