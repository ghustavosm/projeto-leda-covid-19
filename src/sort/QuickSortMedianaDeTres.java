package sort;

import java.text.Collator;
import java.util.Locale;

import data.DadoCovid;
import util.Array;

public class QuickSortMedianaDeTres implements Sort {
	
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
		int xPos = getMedianPositionInteger(A, p, r, method);
		Integer x = (Integer) A.get(xPos).getClass().getMethod(method).invoke(A.get(xPos));
		A.swap(r, xPos);

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

	private int getMedianPositionInteger(Array<DadoCovid> A, int p, int r, String method) throws Exception {
		int midPos = (p + r) / 2;

		DadoCovid prev = A.get(p);
		DadoCovid mid = A.get(midPos);
		DadoCovid next = A.get(r);
		
		Integer prevData = (Integer) prev.getClass().getMethod(method).invoke(prev);
		Integer midData = (Integer) mid.getClass().getMethod(method).invoke(mid);
		Integer nextData = (Integer) next.getClass().getMethod(method).invoke(next);

		if (midData.compareTo(prevData) < 0 && prevData.compareTo(nextData) < 0) {
			return p;
		} else if (prevData.compareTo(midData) < 0 && nextData.compareTo(prevData) < 0) {
			return p;
		} else if (nextData.compareTo(prevData) < 0 && midData.compareTo(nextData) < 0) {
			return r;
		} else if (prevData.compareTo(nextData) < 0 && nextData.compareTo(midData) < 0) {
			return r;
		}

		return midPos;
	}
	
	public void sortIntegerDesc(Array<DadoCovid> A, String method) throws Exception {
		sortIntegerDesc(A, 0, A.size() - 1, method);
	}
	
	private void sortIntegerDesc(Array<DadoCovid> A, int p, int r, String method) throws Exception {
		if (p < r) {
			int q = partitionIntegerDesc(A, p, r, method);
			sortIntegerDesc(A, p, q - 1, method);
			sortIntegerDesc(A, q + 1, r, method);
		}
	}

	private int partitionIntegerDesc(Array<DadoCovid> A, int p, int r, String method) throws Exception {
		int xPos = getMedianPositionInteger(A, p, r, method);
		Integer x = (Integer) A.get(xPos).getClass().getMethod(method).invoke(A.get(xPos));
		A.swap(r, xPos);

		int i = p - 1;
		for (int j = p; j < r; j++) {
			Integer data = (Integer) A.get(j).getClass().getMethod(method).invoke(A.get(j));
			if (data.compareTo(x) > 0) {
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
		
		int xPos = getMedianPositionString(A, p, r, method);
		String x = (String) A.get(xPos).getClass().getMethod(method).invoke(A.get(xPos));		
		A.swap(r, xPos);

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

	private int getMedianPositionString(Array<DadoCovid> A, int p, int r, String method) throws Exception {
		Collator collator = Collator.getInstance(new Locale ("pt", "BR"));
		
		int midPos = (p + r) / 2;

		DadoCovid prev = A.get(p);
		DadoCovid mid = A.get(midPos);
		DadoCovid next = A.get(r);
		
		String prevData = (String) prev.getClass().getMethod(method).invoke(prev);
		String midData = (String) mid.getClass().getMethod(method).invoke(mid);
		String nextData = (String) next.getClass().getMethod(method).invoke(next);

		if (collator.compare(midData, prevData) < 0 && collator.compare(prevData, nextData) < 0) {
			return p;
		} else if (collator.compare(prevData, midData) < 0 && collator.compare(nextData, prevData) < 0) {
			return p;
		} else if (collator.compare(nextData, prevData) < 0 && collator.compare(midData, nextData) < 0) {
			return r;
		} else if (collator.compare(prevData, nextData) < 0 && collator.compare(nextData, midData) < 0) {
			return r;
		}

		return midPos;
	}
	
	public void sortStringDesc(Array<DadoCovid> A, String method) throws Exception {
		sortStringDesc(A, 0, A.size() - 1, method);
	}

	private void sortStringDesc(Array<DadoCovid> A, int p, int r, String method) throws Exception {
		if (p < r) {
			int q = partitionStringDesc(A, p, r, method);
			sortStringDesc(A, p, q - 1, method);
			sortStringDesc(A, q + 1, r, method);
		}
	}

	private int partitionStringDesc(Array<DadoCovid> A, int p, int r, String method) throws Exception {
		Collator collator = Collator.getInstance(new Locale ("pt", "BR"));
		
		int xPos = getMedianPositionString(A, p, r, method);
		String x = (String) A.get(xPos).getClass().getMethod(method).invoke(A.get(xPos));		
		A.swap(r, xPos);

		int i = p - 1;
		for (int j = p; j < r; j++) {
			String data = (String) A.get(j).getClass().getMethod(method).invoke(A.get(j));
			if (collator.compare(data, x) > 0) {
				i++;
				A.swap(i, j);
			}
		}
		A.swap(i + 1, r);

		return i + 1;
	}

}