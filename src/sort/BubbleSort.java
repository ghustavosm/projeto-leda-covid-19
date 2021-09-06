package sort;

import java.text.Collator;
import java.util.Locale;

import data.DadoCovid;
import util.Array;

public class BubbleSort implements Sort {
	
	@Override
	public void sortInteger(Array<DadoCovid> A, String method) throws Exception {
		for (int i = 0; i < A.size(); i++) {
			for (int j = A.size() - 1; j > 0; j--) {			
				Integer data1 = (Integer) A.get(j).getClass().getMethod(method).invoke(A.get(j));    	
				Integer data2 = (Integer) A.get(j - 1).getClass().getMethod(method).invoke(A.get(j - 1));				
				if (data1.compareTo(data2) < 0) {
					A.swap(j, j - 1);
				}
			}
		}
	}
	
	@Override
	public void sortString(Array<DadoCovid> A, String method) throws Exception {
		Collator collator = Collator.getInstance(new Locale ("pt", "BR"));
		for (int i = 0; i < A.size(); i++) {
			for (int j = A.size() - 1; j > 0; j--) {			
				String data1 = (String) A.get(j).getClass().getMethod(method).invoke(A.get(j));    	
		    	String data2 = (String) A.get(j - 1).getClass().getMethod(method).invoke(A.get(j - 1));
		    	if (collator.compare(data1, data2) < 0) {
					A.swap(j, j - 1);
				}
			}
		}
	}

}