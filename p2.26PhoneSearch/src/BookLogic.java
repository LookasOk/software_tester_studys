import java.util.Scanner;

public class BookLogic {
	Scanner sc;
	PhoneBook book;

	public BookLogic() {
		book = new PhoneBook();
		sc = new Scanner(System.in);
	}

	public void run() {
		this.printMenuText();
		while (true) {
			System.out.println("command: ");
			String command = sc.nextLine();
			switch (command) {
			case ("1"):
				this.menu1();
				break;
			case ("2"):
				this.menu2();
				break;
			case ("3"):
				this.menu3();
				break;
			case ("4"):
				this.menu4();
				break;
			case ("5"):
				this.menu5();
				break;
			case ("6"):
				this.menu6();
				break;
			case ("7"):
				this.menu7();
				break;
			}
			if (command.equalsIgnoreCase("x"))
				break;
		}
	}

	public void printMenuText() {
		System.out.println("phone search\r\n" + "available operations:\r\n" + "1 add a number\r\n"
				+ "2 search for a number\r\n" + "3 search for a person by phone number\r\n" + "4 add an address\r\n"
				+ "5 search for personal information\r\n" + "6 delete personal information\r\n"
				+ "7 filtered listing\r\n" + "x quit");
	}

	public void menu1() {
		String name;
		String number;
		System.out.println("whose number: ");
		name = sc.nextLine();
		System.out.println("number: ");
		number = sc.nextLine();
		book.addNumber(name, number);
	}

	public void menu2() {
		String name;
		System.out.println("whose number: ");
		name = sc.nextLine();
		if (book.getPhoneNumber(name) == null) {
			System.out.println("not found");
		} else {
			System.out.println(book.getPhoneNumber(name));
		}
	}

	public void menu3() {
		String number;
		System.out.println("number: ");
		number = sc.nextLine();
		if (book.getPerson(number) == null) {
			System.out.println("not found");
		} else {
			System.out.println(book.getPerson(number));
		}
	}

	public void menu4() {
		String name;
		String street;
		String city;
		System.out.println("whose address: ");
		name = sc.nextLine();
		System.out.println("street: ");
		street = sc.nextLine();
		book.addAdressStreet(name, street);
		System.out.println("city: ");
		city = sc.nextLine();
		book.addAdressCity(name, city);
	}

	public void menu5() {
		String name;
		System.out.println("whose information: ");
		name = sc.nextLine();
		if (book.getAdressCity(name) == null && book.getPhoneNumber(name) == null) {
			System.out.println("not found");
		} else if (book.getAdressCity(name) == null) {
			System.out.println("address unknown\r\n" + "phone numbers: \r\n" + book.getPhoneNumber(name));
		} else if (book.getPhoneNumber(name) == null) {
			System.out.println("address: " + book.getAdressStreet(name) + " " + book.getAdressCity(name)
					+ "\r\n phone number not found");
		} else {
			System.out.println("address: " + book.getAdressStreet(name) + " " + book.getAdressCity(name)
					+ "\r\n phone numbers: \r\n" + book.getPhoneNumber(name));
		}
	}

	public void menu5(String name) {
		if (book.getAdressCity(name) == null && book.getPhoneNumber(name) == null) {
			System.out.println("keyword not found");
		} else if (book.getAdressCity(name) == null) {
			System.out.println(name + "\r\n address unknown\r\n" + "phone numbers: \r\n" + book.getPhoneNumber(name));
		} else if (book.getPhoneNumber(name) == null) {
			System.out.println(name + "\r\n address: " + book.getAdressStreet(name) + " " + book.getAdressCity(name)
					+ "\r\n phone number not found");
		} else {
			System.out.println(name + "\r\n address: " + book.getAdressStreet(name) + " " + book.getAdressCity(name)
					+ "\r\n phone numbers: \r\n" + book.getPhoneNumber(name));
		}
	}

	public void menu6() {
		String name;
		System.out.println("whose information: ");
		name = sc.nextLine();
		book.deletePersonalInfo(name);
	}

	public void menu7() {
		String keyWord = "";
		System.out.println("keyword (if empty, all listed): ");
		keyWord = sc.nextLine();
		if (keyWord.isEmpty()) {
			for (String listItem : book.allEntryNames()) {
				this.menu5(listItem);
			}
		} else {
			for (String name : book.filteredSearch(keyWord)) {
				this.menu5(name);
			}
		}

	}
}
