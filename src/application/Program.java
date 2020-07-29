package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.nextLine());
		System.out.print("Check-out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.nextLine());

		if (checkIn.after(checkOut)) {
			System.out.println("Error in reservation: check-out date must be after check-out date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);

			System.out.println("Enter data do update the reservation:");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.nextLine());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.nextLine());

			// Date now = new Date();

			// if (checkIn.before(now) || (checkOut.before(now))) {
			// System.out.println("Error in reservation: Reservation dates for update must
			// be future dates");
			// } else {

			String error = reservation.updateDates(checkIn, checkOut);
			if (error == null) {
				System.out.println(reservation);

			}else
				System.out.println(error);
		}
	}
}