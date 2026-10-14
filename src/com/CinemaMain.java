package com;

public class CinemaMain {
    public static void main(String[] args) {
        CinemaService service = new CinemaService();

        try {
            service.bookTicket(5, 7);

        } catch (CustomException e) {
            ErrorMessage error = e.getErrorMessage();

            System.out.println("Error Code: " + error.getCode());
            System.out.println("Error Message: " + error.getMessage());
            System.out.println("Additional Information: " + error.getAdditionalInformation());

        } finally {
            System.out.println("Ticket booking process finished.");
        }
    }
}
