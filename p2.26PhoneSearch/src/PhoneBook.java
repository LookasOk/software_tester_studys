import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class PhoneBook {
	private Map<String, Set<String>> numbers;
	private Map<String, String> adressesStreet;
	private Map<String, String> adressesCity;

	public PhoneBook() {
		this.numbers = new HashMap<String, Set<String>>();
		this.adressesStreet = new HashMap<String, String>();
		this.adressesCity = new HashMap<String, String>();
	}

	public void addNumber(String name, String number) {
		if (!this.numbers.containsKey(name)) {
			this.numbers.put(name, new HashSet<String>());
		}
		Set<String> numbers = this.numbers.get(name);
		numbers.add(number);
	}

	public void addAdressStreet(String name, String adress) {
		this.adressesStreet.put(name, adress);
	}

	public void addAdressCity(String name, String adress) {
		this.adressesCity.put(name, adress);
	}

	public Set<String> getPhoneNumber(String person) {
		return this.numbers.get(person);
	}

	public String getPerson(String phoneNumber) {
		for (Entry<String, Set<String>> E : this.numbers.entrySet()) {
			for (String numbers : E.getValue()) {
				if (Objects.equals(phoneNumber, numbers)) {
					return E.getKey();
				}

			}
		}
		return null;
	}

	public String getAdressStreet(String person) {
		return this.adressesStreet.get(person);
	}

	public String getAdressCity(String person) {
		return this.adressesCity.get(person);
	}

	public void deletePersonalInfo(String person) {
		this.numbers.remove(person);
		this.adressesStreet.remove(person);
		this.adressesCity.remove(person);
	}

	public Set<String> allEntryNames() {
		Set<String> allEntrys = new HashSet<String>();
		for (Entry<String, Set<String>> E : this.numbers.entrySet()) {
			allEntrys.add(E.getKey());
		}
		for (Entry<String, String> E : this.adressesStreet.entrySet()) {
			allEntrys.add(E.getKey());
		}
		return allEntrys;
	}

	public Set<String> filteredSearch(String keyWord) {
		SortedSet<String> list = new TreeSet<String>();
		for (Entry<String, Set<String>> E : this.numbers.entrySet()) {
			if (E.getKey().contains(keyWord)) {
				list.add(E.getKey());
			}
		}
		for (Entry<String, String> E : this.adressesStreet.entrySet()) {
			if (E.getKey().contains(keyWord) || E.getValue().contains(keyWord)) {
				list.add(E.getKey());
			}
		}
		for (Entry<String, String> E : this.adressesCity.entrySet()) {
			if (E.getKey().contains(keyWord) || E.getValue().contains(keyWord)) {
				list.add(E.getKey());
			}
		}
		if(list.isEmpty()) {
			System.out.println("keyword not found");
		}
		return list;
	}
}
