package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation4;
import model.exceptions.DomainException;

public class Program4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			sc.nextLine();
			System.out.print("Check-in date (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.nextLine());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.nextLine());

			Reservation4 reservation = new Reservation4(roomNumber, checkIn, checkOut);
			System.out.println(reservation);

			System.out.println("Enter data do update the reservation:");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.nextLine());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.nextLine());

			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation);
			
		} catch (ParseException e) {
			System.out.println("Invalid date format");
			
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());	
		}

		sc.close();
	}
}