package Expected.ExpectedFile;

import Expected.Expected;

public class ExpectedFileExtensionCsv implements Expected {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		if (! valueRaw.endsWith(".csv"))
			throw createInputError();
	}
	
	@Override
	public String getErrorMessage() {
		return "Файл должен быть расширения .csv";
	}
}
