package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.Array;

class ArrayTest {

	Array<Integer> numerosVazio;
	Array<String> stringsVazio;
	Array<Integer> numeros;
	Array<String> strings;
	int testMaxSize;

	public ArrayTest() {
		testMaxSize = 1000000;
		numerosVazio = new Array<Integer>(new Integer[0]);
		stringsVazio = new Array<String>(new String[0]);
		numeros = new Array<Integer>(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		strings = new Array<String>(new String[] {"a", "e", "i", "o", "u"});
	}

	@Test
	void testSize() {
		assertEquals(numerosVazio.size(), 0);
		assertEquals(stringsVazio.size(), 0);
		assertEquals(numeros.size(), 10);
		assertEquals(strings.size(), 5);

		Array<String> umaPosicao = new Array<String>(new String[1]);
		assertEquals(umaPosicao.size(), 1);

		for (int i = 1; i < testMaxSize; i = i * 10) {
			assertEquals((new Array<String>(new String[i])).size(), i);
		}

	}

	@Test
	void testGet() {
		for (int i = 0; i < numeros.size(); i++) {
			assertEquals(numeros.get(i), i + 1);
		}
		assertEquals(strings.get(0), "a");
		assertEquals(strings.get(1), "e");
		assertEquals(strings.get(2), "i");
		assertEquals(strings.get(3), "o");
		assertEquals(strings.get(4), "u");
	}

	@Test
	void testSet() {
		for (int i = 0; i < numeros.size(); i++) {
			numeros.set(i, 20);
			assertEquals(numeros.get(i), 20);
		}
		for (int i = 0; i < strings.size(); i++) {
			strings.set(i, "b");
			assertEquals(strings.get(i), "b");
		}
	}

	@Test
	void testHas() {
		for (int i = 1; i < 10; i++) {
			assertEquals(numeros.has(i), i - 1);
		}
		assertEquals(numeros.has(-1), -1);
		assertEquals(numeros.has(11), -1);

		assertEquals(strings.has("a"), 0);
		assertEquals(strings.has("e"), 1);
		assertEquals(strings.has("i"), 2);
		assertEquals(strings.has("o"), 3);
		assertEquals(strings.has("u"), 4);
		assertEquals(strings.has("b"), -1);
	}

	@Test
	void testGetArray() {
		int[] auxNumeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		String[] auxLetras = {"a", "e", "i", "o", "u"};

		for (int i = 0; i < numeros.size(); i++) {
			assertEquals(numeros.get(i), auxNumeros[i]);
		}
		for (int i = 0; i < strings.size(); i++) {
			assertEquals(strings.get(i), auxLetras[i]);
		}
	}

	@Test
	void testAdd() {
		int tamanhoInicial = numeros.size();
		numeros.add(20);
		int tamanhoFinal = numeros.size();
		assertEquals(tamanhoInicial, 10);
		assertEquals(tamanhoFinal, 11);
		assertEquals(numeros.get(tamanhoInicial), 20);

		tamanhoInicial = strings.size();
		strings.add("b");
		tamanhoFinal = strings.size();
		assertEquals(tamanhoInicial, 5);
		assertEquals(tamanhoFinal, 6);
		assertEquals(strings.get(tamanhoInicial), "b");

		assertEquals(strings.has("a"), 0);
		assertEquals(strings.has("e"), 1);
		assertEquals(strings.has("i"), 2);
		assertEquals(strings.has("o"), 3);
		assertEquals(strings.has("u"), 4);
		assertEquals(strings.has("b"), 5);

		tamanhoInicial = numeros.size();
		numeros.add(0, 30);
		tamanhoFinal = numeros.size();
		assertEquals(tamanhoInicial, 11);
		assertEquals(tamanhoFinal, 12);
		assertEquals(numeros.get(0), 30);
		assertEquals(numeros.get(tamanhoInicial), 20);

		tamanhoInicial = strings.size();
		strings.add(0, "c");
		tamanhoFinal = strings.size();
		assertEquals(tamanhoInicial, 6);
		assertEquals(tamanhoFinal, 7);
		assertEquals(strings.get(0), "c");
		assertEquals(strings.get(tamanhoInicial), "b");

		assertEquals(strings.has("c"), 0);
		assertEquals(strings.has("a"), 1);
		assertEquals(strings.has("e"), 2);
		assertEquals(strings.has("i"), 3);
		assertEquals(strings.has("o"), 4);
		assertEquals(strings.has("u"), 5);
		assertEquals(strings.has("b"), 6);

		tamanhoInicial = numeros.size();
		numeros.add(5, 40);
		tamanhoFinal = numeros.size();
		assertEquals(tamanhoInicial, 12);
		assertEquals(tamanhoFinal, 13);
		assertEquals(numeros.get(0), 30);
		assertEquals(numeros.get(5), 40);
		assertEquals(numeros.get(tamanhoInicial), 20);

		tamanhoInicial = strings.size();
		strings.add(4, "d");
		tamanhoFinal = strings.size();
		assertEquals(tamanhoInicial, 7);
		assertEquals(tamanhoFinal, 8);
		assertEquals(strings.get(0), "c");
		assertEquals(strings.get(4), "d");
		assertEquals(strings.get(tamanhoInicial), "b");

		assertEquals(strings.has("c"), 0);
		assertEquals(strings.has("a"), 1);
		assertEquals(strings.has("e"), 2);
		assertEquals(strings.has("i"), 3);
		assertEquals(strings.has("d"), 4);
		assertEquals(strings.has("o"), 5);
		assertEquals(strings.has("u"), 6);
		assertEquals(strings.has("b"), 7);
	}

	@Test
	void testAppend() {
		int tamanhoInicial = numeros.size();
		numeros.append(20);
		int tamanhoFinal = numeros.size();
		assertEquals(tamanhoInicial, 10);
		assertEquals(tamanhoFinal, 11);
		assertEquals(numeros.get(tamanhoInicial), 20);

		tamanhoInicial = strings.size();
		strings.append("b");
		tamanhoFinal = strings.size();
		assertEquals(tamanhoInicial, 5);
		assertEquals(tamanhoFinal, 6);
		assertEquals(strings.get(tamanhoInicial), "b");

		assertEquals(strings.has("a"), 0);
		assertEquals(strings.has("e"), 1);
		assertEquals(strings.has("i"), 2);
		assertEquals(strings.has("o"), 3);
		assertEquals(strings.has("u"), 4);
		assertEquals(strings.has("b"), 5);
	}

	@Test
	void testPrepend() {
		int tamanhoInicial = numeros.size();
		numeros.prepend(30);
		int tamanhoFinal = numeros.size();
		assertEquals(tamanhoInicial, 10);
		assertEquals(tamanhoFinal, 11);
		assertEquals(numeros.get(0), 30);

		tamanhoInicial = strings.size();
		strings.prepend("c");
		tamanhoFinal = strings.size();
		assertEquals(tamanhoInicial, 5);
		assertEquals(tamanhoFinal, 6);
		assertEquals(strings.get(0), "c");

		assertEquals(strings.has("c"), 0);
		assertEquals(strings.has("a"), 1);
		assertEquals(strings.has("e"), 2);
		assertEquals(strings.has("i"), 3);
		assertEquals(strings.has("o"), 4);
		assertEquals(strings.has("u"), 5);
	}

	@Test
	void testRemove() {
		int tamanhoInicial = numeros.size();
		numeros.remove(3);
		int tamanhoFinal = numeros.size();
		assertEquals(tamanhoInicial, 10);
		assertEquals(tamanhoFinal, 9);
		assertEquals(numeros.get(0), 1);
		assertEquals(numeros.get(3), 5);
		assertEquals(numeros.get(tamanhoFinal - 1), 10);

		tamanhoInicial = numeros.size();
		numeros.remove(0);
		tamanhoFinal = numeros.size();
		assertEquals(tamanhoInicial, 9);
		assertEquals(tamanhoFinal, 8);
		assertEquals(numeros.get(0), 2);
		assertEquals(numeros.get(tamanhoFinal - 1), 10);

		tamanhoInicial = numeros.size();
		numeros.remove(tamanhoInicial - 1);
		tamanhoFinal = numeros.size();
		assertEquals(tamanhoInicial, 8);
		assertEquals(tamanhoFinal, 7);
		assertEquals(numeros.get(0), 2);
		assertEquals(numeros.get(tamanhoFinal - 1), 9);
	}

	@Test
	void testShuffle() {
		int[] auxNumeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		numeros.shuffle();

		boolean diferente = false;
		for (int i = 0; i < numeros.size(); i++) {
			if (numeros.get(i) != auxNumeros[i]) {
				diferente = true;
			}
			assertNotEquals(numeros.has(i + 1), -1);
		}

		if (diferente == false) {
			fail("O array n�o mudou!");
		}
	}

	@Test
	void testSwap() {
		numeros.swap(0, 1);
		assertEquals(numeros.get(0), 2);
		assertEquals(numeros.get(1), 1);

		numeros.swap(8, 9);
		assertEquals(numeros.get(8), 10);
		assertEquals(numeros.get(9), 9);
	}

	@Test
	void testGetMax() {
		assertEquals(numeros.getMax(), 10);
	}

	@Test
	void testToString() {
		assertEquals(numeros.toString(), "1\n2\n3\n4\n5\n6\n7\n8\n9\n10");
		assertEquals(strings.toString(), "a\ne\ni\no\nu");
	}

}