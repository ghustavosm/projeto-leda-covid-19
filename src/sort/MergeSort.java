package sort;

import java.text.Collator;
import java.util.Locale;

import data.DadoCovid;
import util.Array;

public class MergeSort implements Sort {
	
	@Override
	public void sortInteger(Array<DadoCovid> A, String method) throws Exception {
		sortInteger(A, 0, A.size() - 1, method);
	}

	private void sortInteger(Array<DadoCovid> A, int p, int r, String method) throws Exception {
		if (p < r) {
			int q = (p + r) / 2;
			sortInteger(A, p, q, method);
			sortInteger(A, q + 1, r, method);
			mergeInteger(A, p, q, r, method);
		}
	}

	private void mergeInteger(Array<DadoCovid> A, int p, int q, int r, String method) throws Exception {
		int n1 = q - p + 1;
		int n2 = r - q;

		Array<DadoCovid> L = new Array<DadoCovid>(n1);
		Array<DadoCovid> R = new Array<DadoCovid>(n2);

		for (int i = 0; i < n1; i++) {
			L.set(i, A.get(p + i));
		}

		for (int j = 0; j < n2; j++) {
			R.set(j, A.get(q + j + 1));
		}

		int i = 0, j = 0, k = p;
		while (i < n1 && j < n2) {
			
			Integer data1 = (Integer) L.get(i).getClass().getMethod(method).invoke(L.get(i));    	
			Integer data2 = (Integer) R.get(j).getClass().getMethod(method).invoke(R.get(j));
			
			if (data1.compareTo(data2) <= 0) {
				A.set(k, L.get(i));
				i++;
			} else {
				A.set(k, R.get(j));
				j++;
			}
			k++;
		}

		while (i < n1) {
			A.set(k, L.get(i));
			i++;
			k++;
		}

		while (j < n2) {
			A.set(k, R.get(j));
			j++;
			k++;
		}
	}

	@Override
	public void sortString(Array<DadoCovid> A, String method) throws Exception {
		sortString(A, 0, A.size() - 1, method);
	}

	private void sortString(Array<DadoCovid> A, int p, int r, String method) throws Exception {
		if (p < r) {
			int q = (p + r) / 2;
			sortString(A, p, q, method);
			sortString(A, q + 1, r, method);
			mergeString(A, p, q, r, method);
		}
	}

	private void mergeString(Array<DadoCovid> A, int p, int q, int r, String method) throws Exception {
		Collator collator = Collator.getInstance(new Locale ("pt", "BR"));
		
		int n1 = q - p + 1;
		int n2 = r - q;

		Array<DadoCovid> L = new Array<DadoCovid>(n1);
		Array<DadoCovid> R = new Array<DadoCovid>(n2);

		for (int i = 0; i < n1; i++) {
			L.set(i, A.get(p + i));
		}

		for (int j = 0; j < n2; j++) {
			R.set(j, A.get(q + j + 1));
		}

		int i = 0, j = 0, k = p;
		while (i < n1 && j < n2) {
			
			String data1 = (String) L.get(i).getClass().getMethod(method).invoke(L.get(i));    	
			String data2 = (String) R.get(j).getClass().getMethod(method).invoke(R.get(j));
			
			if (collator.compare(data1, data2) <= 0) {
				A.set(k, L.get(i));
				i++;
			} else {
				A.set(k, R.get(j));
				j++;
			}
			k++;
		}

		while (i < n1) {
			A.set(k, L.get(i));
			i++;
			k++;
		}

		while (j < n2) {
			A.set(k, R.get(j));
			j++;
			k++;
		}
	}

}