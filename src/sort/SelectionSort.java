package sort;

import java.text.Collator;
import java.util.Locale;

import data.DadoCovid;
import util.Array;

public class SelectionSort implements Sort {

	@Override
	public void sortInteger(Array<DadoCovid> A, String method) throws Exception {
		for (int i = 0; i < A.size(); i++) {
			int min = i;
			for (int j = i + 1; j < A.size(); j++) {
				Integer data1 = (Integer) A.get(j).getClass().getMethod(method).invoke(A.get(j));    	
				Integer data2 = (Integer) A.get(min).getClass().getMethod(method).invoke(A.get(min));
				if (data1.compareTo(data2) < 0) {
					min = j;
				}
			}
			A.swap(i, min);
		}
	}

	@Override
	public void sortString(Array<DadoCovid> A, String method) throws Exception {
		Collator collator = Collator.getInstance(new Locale ("pt", "BR"));
		for (int i = 0; i < A.size(); i++) {
			int min = i;
			for (int j = i + 1; j < A.size(); j++) {
				String data1 = (String) A.get(j).getClass().getMethod(method).invoke(A.get(j));    	
				String data2 = (String) A.get(min).getClass().getMethod(method).invoke(A.get(min));
				if (collator.compare(data1, data2) < 0) {
					min = j;
				}
			}
			A.swap(i, min);
		}
	}

}