package sort;

import java.text.Collator;
import java.util.Locale;

import data.DadoCovid;
import util.Array;

public class InsertionSort implements Sort {
	
	@Override
	public void sortInteger(Array<DadoCovid> A, String method) throws Exception {
		for (int j = 1; j < A.size(); j++) {
			DadoCovid key = A.get(j);
			Integer valueKey = (Integer) key.getClass().getMethod(method).invoke(key);
			
			int i = j - 1;
			while (i >= 0 && valueKey.compareTo((Integer) A.get(i).getClass().getMethod(method).invoke(A.get(i))) < 0) {
				A.set(i + 1, A.get(i));
				i--;
			}
			A.set(i + 1, key);
		}
	}

	@Override
	public void sortString(Array<DadoCovid> A, String method) throws Exception {
		Collator collator = Collator.getInstance(new Locale ("pt", "BR"));
		
		for (int j = 1; j < A.size(); j++) {
			DadoCovid key = A.get(j);
			String valueKey = (String) key.getClass().getMethod(method).invoke(key);
			
			int i = j - 1;
			while (i >= 0 && collator.compare(valueKey, (String) A.get(i).getClass().getMethod(method).invoke(A.get(i))) < 0) {
				A.set(i + 1, A.get(i));
				i--;
			}
			A.set(i + 1, key);
		}
	}

}