package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {
	private Set<String> uniqueStrings;
	private int numberOfDuplicates;

	public PersonalDuplicateRemover() {
		this.uniqueStrings = new HashSet<String>();
		numberOfDuplicates = 0;
	}

	@Override
	public void add(String characterString) {
		if (this.uniqueStrings.contains(characterString)) {
			this.numberOfDuplicates++;
		} else {
			this.uniqueStrings.add(characterString);
		}
	}

	@Override
	public int getNumberOfDetectedDuplicates() {
		return this.numberOfDuplicates;
	}

	@Override
	public Set<String> getUniqueCharacterStrings() {
		return this.uniqueStrings;
	}

	@Override
	public void empty() {
		this.uniqueStrings.clear();
		this.numberOfDuplicates = 0;
	}

}
