package util;
public interface Util {
	static void checkObject(Object o) {
		if (o == null)
			throw new IllegalArgumentException("L'objet ne peut pas �tre null");
	}

	static void checkString(String s) {
		checkObject(s);
		if (s.matches("\\s*"))
			throw new IllegalArgumentException(
					"La cha�ne ne peut pas �tre vide");
	}

	static void checkNumerique(String s) {
		checkString(s);
		try {
			Long.parseLong(s);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(
					"La cha�ne doit �tre un nombre valide");
		}
	}

	static void checkPositive(double nombre) {
		if (nombre <= 0)
			throw new IllegalArgumentException(
					"La valeur ne peut pas �tre n�gative ou nulle");

	}
}
