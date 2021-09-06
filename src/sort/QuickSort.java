package sort;

import java.text.Collator;
import java.util.Locale;

import data.DadoCovid;
import util.Array;

public class QuickSort implements Sort {

	@Override
	public void sortInteger(Array<DadoCovid> A, String method) throws Exception {
		sortInteger(A, 0, A.size() - 1, method);
	}
	
	private void sortInteger(Array<DadoCovid> A, int p, int r, String method) throws Exception {
		if (p < r) {
			int q = partitionInteger(A, p, r, method);
			sortInteger(A, p, q - 1, method);
			sortInteger(A, q + 1, r, method);
		}
	}

	private int partitionInteger(Array<DadoCovid> A, int p, int r, String method) throws Exception {
		Integer x = (Integer) A.get(r).getClass().getMethod(method).invoke(A.get(r));		
		
		int i = p - 1;
		for (int j = p; j < r; j++) {
			Integer data = (Integer) A.get(j).getClass().getMethod(method).invoke(A.get(j));
			if (data.compareTo(x) < 0) {
				i++;
				A.swap(i, j);
			}
		}
		A.swap(i + 1, r);

		return i + 1;
	}

	@Override
	public void sortString(Array<DadoCovid> A, String method) throws Exception {
		sortString(A, 0, A.size() - 1, method);
	}
	
	private void sortString(Array<DadoCovid> A, int p, int r, String method) throws Exception {
		if (p < r) {
			int q = partitionString(A, p, r, method);
			sortString(A, p, q - 1, method);
			sortString(A, q + 1, r, method);
		}
	}

	private int partitionString(Array<DadoCovid> A, int p, int r, String method) throws Exception {
		Collator collator = Collator.getInstance(new Locale ("pt", "BR"));
		String x = (String) A.get(r).getClass().getMethod(method).invoke(A.get(r));		
		
		int i = p - 1;
		for (int j = p; j < r; j++) {
			String data = (String) A.get(j).getClass().getMethod(method).invoke(A.get(j));
			if (collator.compare(data, x) < 0) {
				i++;
				A.swap(i, j);
			}
		}
		A.swap(i + 1, r);

		return i + 1;
	}

}