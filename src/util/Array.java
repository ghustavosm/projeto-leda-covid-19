package util;

public class Array<T> {

	private T[] array;

	public Array() {
		this(0);
	}

	@SuppressWarnings("unchecked")
	public Array(int size) {
		array = (T[]) new Object[size];
	}

	public Array(T[] array) {
		this.array = array;
	}

	public int size() {
		return array.length;
	}

	public T get(int index) {
		return array[index];
	}

	public T set(int index, T element) {
		return array[index] = element;
	}

	public int has(T element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				return i;
			}
		}
		return -1;
	}

	public T[] getArray() {
		return array;
	}
	
	@SuppressWarnings("unchecked")
	public void add(T element) {		
		T[] newArray = (T[]) new Object[array.length + 1];
		System.arraycopy(array, 0, newArray, 0, array.length);
		newArray[array.length] = element;
		array = newArray;

	}

	@SuppressWarnings("unchecked")
	public void add(int index, T element) {		
		T[] newArray = (T[]) new Object[array.length + 1];

		for (int i = 0, j = 0; i < array.length; i++, j++) {
			if (j == index) {
				newArray[j++] = element;
			}
			newArray[j] = array[i];
		}

		if (index == array.length) {
			newArray[index] = element;
		}

		array = newArray;
	}

	public void append(T element) {
		add(element);
	}

	public void prepend(T element) {
		add(0, element);
	}

	@SuppressWarnings("unchecked")
	public void remove(int index) {		
		T[] newArray = (T[]) new Object[array.length - 1];

		for (int i = 0, j = 0; i < newArray.length; i++, j++) {
			if (i == index) {
				j++;
			}
			newArray[i] = array[j];
		}
		array = newArray;
	}

	public void shuffle() {
		for (int i = 0; i < array.length; i++) {
			int j = (int) (Math.random() * array.length);
			T aux = array[i];
			array[i] = array[j];
			array[j] = aux;
		}
	}

	public void swap(int i, int j) {
		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	public int getMax() {
		int largest = (int) get(0);
		for (int i = 1; i < size(); i++) {
			int number = (int) get(i);
			if (number > largest) {
				largest = number;
			}
		}
		return largest;
	}
	
	public int getMaxDadoCovid(String method) throws Exception {  	
		int largest = (Integer) get(0).getClass().getMethod(method).invoke(get(0));
		for (int i = 1; i < size(); i++) {
			int number = (Integer) get(i).getClass().getMethod(method).invoke(get(i));
			if (number > largest) {
				largest = number;
			}
		}
		return largest;
	}
	
	@Override
	public String toString() {
		String string = "";
		for (int i = 0; i < array.length; i++) {
			string += array[i].toString() + "\n";
		}
		return string.substring(0, string.length() - 1);
	}

}