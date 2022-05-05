package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import dao.InstrumentDao;
import entity.Instrument;

public class Menu {
	
	private Scanner scanner = new Scanner(System.in);
	private InstrumentDao instrumentDao = new InstrumentDao();
	private List<String> options = Arrays.asList(
			"Display Instruments",
			"Create Instrument",
			"Delete Instrument");
	
	public void start() {
		String selection = "";
		do {
			printMenu();
			selection = scanner.nextLine();
			try {
				if (selection.equals("1")) {
					displayInstruments();
				} else if (selection.equals("2")) {
					createInstrument();
				} else if (selection.equals("3")) {
					deleteInstrument();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Press enter to continue");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	private void printMenu() {
		System.out.println("Select an option:\n-------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}	
	private void displayInstruments() throws SQLException {
		List<Instrument> instruments = instrumentDao.getInstruments();
		for (Instrument instrument : instruments) {
			System.out.println("\tID: " + instrument.getId() + "\tNAME: " + instrument.getName() + "\tTYPE: " + instrument.getType() + "\tORIGIN: " + instrument.getOrigin());
		}
	}
	private void createInstrument() throws SQLException {
		System.out.print("Enter the name of the instrument: ");
		String name = scanner.nextLine();
		System.out.print("Enter the type of the instrument(stringed, wind, percussion, or other): ");
		String type = scanner.nextLine();
		System.out.print("Enter the place of origin of the instrument: ");
		String origin = scanner.nextLine();
		instrumentDao.createNewInstrument(name, type, origin);
	}
	private void deleteInstrument() throws SQLException {
		System.out.print("Enter ID of instrument to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		instrumentDao.deleteInstrumentById(id);
	}
}