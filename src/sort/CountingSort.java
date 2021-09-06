package sort;

import data.DadoCovid;
import util.Array;

public class CountingSort {
	
	public Array<DadoCovid> sortInteger(Array<DadoCovid> A, String method) throws Exception {
		Array<DadoCovid> B = new Array<DadoCovid>(A.size());
		sortInteger(A, B, A.getMaxDadoCovid(method) + 1, method);
		return B;
	}

	private void sortInteger(Array<DadoCovid> A, Array<DadoCovid> B, int k, String method) throws Exception {		
		Array<Integer> C = new Array<Integer>(k);
		
		for (int i = 0; i < k; i++) {
			C.set(i, 0);
		}

		for (int j = 0; j < A.size(); j++) {
			int index = (Integer) A.get(j).getClass().getMethod(method).invoke(A.get(j));
			C.set(index, C.get(index) + 1);
		}

		for (int i = 1; i < k; i++) {
			C.set(i, C.get(i) + C.get(i - 1));
		}

		for (int j = A.size() - 1; j >= 0; j--) {
			int number = (Integer) A.get(j).getClass().getMethod(method).invoke(A.get(j));
			int index = C.get(number) - 1;
			B.set(index, A.get(j));
			C.set(number, C.get(number) - 1);
		}
	}

}