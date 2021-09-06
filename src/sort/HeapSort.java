package sort;

import java.text.Collator;
import java.util.Locale;

import data.DadoCovid;
import util.Array;

public class HeapSort implements Sort {

	private int heapSize;

	@Override
	public void sortInteger(Array<DadoCovid> A, String method) throws Exception {
		buildMaxHeapInteger(A, method);
		for (int i = A.size() - 1; i > 0; i--) {
			A.swap(0, i);
			heapSize--;
			maxHeapifyInteger(A, 0, method);
		}
	}

	private void buildMaxHeapInteger(Array<DadoCovid> A, String method) throws Exception {
		heapSize = A.size() - 1;
		for (int i = (A.size() - 1) / 2; i >= 0; i--) {
			maxHeapifyInteger(A, i, method);
		}
	}

	private void maxHeapifyInteger(Array<DadoCovid> A, int i, String method) throws Exception {
		int l = left(i);
		int r = right(i);
		
		int largest;

		if (l <= heapSize && ((Integer) A.get(l).getClass().getMethod(method).invoke(A.get(l))).compareTo((Integer) A.get(i).getClass().getMethod(method).invoke(A.get(i))) > 0) {
			largest = l;
		} else {
			largest = i;
		}

		if (r <= heapSize && ((Integer) A.get(r).getClass().getMethod(method).invoke(A.get(r))).compareTo((Integer) A.get(largest).getClass().getMethod(method).invoke(A.get(largest))) > 0) {
			largest = r;
		}

		if (largest != i) {
			A.swap(i, largest);
			maxHeapifyInteger(A, largest, method);
		}
	}

	@Override
	public void sortString(Array<DadoCovid> A, String method) throws Exception {
		buildMaxHeapString(A, method);
		for (int i = A.size() - 1; i > 0; i--) {
			A.swap(0, i);
			heapSize--;
			maxHeapifyString(A, 0, method);
		}
	}

	private void buildMaxHeapString(Array<DadoCovid> A, String method) throws Exception {
		heapSize = A.size() - 1;
		for (int i = (A.size() - 1) / 2; i >= 0; i--) {
			maxHeapifyString(A, i, method);
		}
	}

	private void maxHeapifyString(Array<DadoCovid> A, int i, String method) throws Exception {		
		Collator collator = Collator.getInstance(new Locale ("pt", "BR"));
		
		int l = left(i);
		int r = right(i);		
		int largest;

		if (l <= heapSize && collator.compare((String) A.get(l).getClass().getMethod(method).invoke(A.get(l)), (String) A.get(i).getClass().getMethod(method).invoke(A.get(i))) > 0) {
			largest = l;
		} else {
			largest = i;
		}

		if (r <= heapSize && collator.compare((String) A.get(r).getClass().getMethod(method).invoke(A.get(r)), (String) A.get(largest).getClass().getMethod(method).invoke(A.get(largest))) > 0)  {
			largest = r;
		}

		if (largest != i) {
			A.swap(i, largest);
			maxHeapifyString(A, largest, method);
		}
	}
	
	private int left(int i) {
		return 2 * i;
	}

	private int right(int i) {
		return 2 * i + 1;
	}
	
}