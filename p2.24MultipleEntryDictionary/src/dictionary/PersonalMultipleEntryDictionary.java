package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
	private final Map<String, Set<String>> dictionary;

	public PersonalMultipleEntryDictionary() {
		this.dictionary = new HashMap<String, Set<String>>();
	}

	@Override
	public void add(String word, String entry) {
		if (!this.dictionary.containsKey(word)) {
			this.dictionary.put(word, new HashSet<String>());
		}
		Set<String> translations = this.dictionary.get(word);
		translations.add(entry);
	}

	@Override
	public Set<String> translate(String word) {
		return this.dictionary.get(word);
	}

	@Override
	public void remove(String word) {
		this.dictionary.remove(word);
	}

}
