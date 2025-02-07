package es.upm.grise.prof2022.ex2;

public class LanguageManipulation {

	static String text;

	// The strings are stored in property files under /resources
	// Each file corresponds to a Language
	// This method return the string associated with a key, e.g.,
	// translate("greeting", English) == "How are you?"
	// translate("greeting", Spanish) == "¿Cómo se encuentra?"
	//
	// See the smokeTest
	public String getText(String key, Language language, Refactor refactor) throws Exception {

		try {
			text = refactor.cargaryobtener(key, language);
		} catch (Exception e) {
			throw new CannotFindPropertyFileOrWrongFileException();
		}
		

		// Non-existing key: case 1
		if(text == null && language == Language.English) { 
			throw new NonExistingKeyException();
		}

		// Non-existing key: case 2
		if(text == null && language != Language.English) { 
			text = "This Key does not exist or it has not been yet translated";
		}

		return text;
	}


}
