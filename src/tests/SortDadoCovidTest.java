package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.DadoCovid;
import sort.CountingSort;
import sort.HeapSort;
import sort.InsertionSort;
import sort.MergeSort;
import sort.QuickSort;
import sort.QuickSortMedianaDeTres;
import sort.SelectionSort;
import sort.Sort;
import util.Array;

class SortDadoCovidTest {

	Array<DadoCovid> confirmadosAcumuladosOrdenadosAsc;
	Array<DadoCovid> cidadesOrdenadasAsc;
	Array<DadoCovid> confirmadosAcumuladosOrdenadosDesc;
	Array<DadoCovid> cidadesOrdenadasDesc;
	Array<DadoCovid> dadosDesordenados;

	public SortDadoCovidTest() {

		confirmadosAcumuladosOrdenadosAsc = new Array<DadoCovid>(new DadoCovid[] {
				new DadoCovid("202113,2021-03-31,330,MG,Wenceslau Braz,3172202,city,108,4238.61852,2,0,0,0.0,2548,True,False".split(",")),
				new DadoCovid("202115,2021-04-15,292,RN,Sítio Novo,2413706,city,120,2157.88527,0,6,0,0.05,5561,True,False".split(",")),
				new DadoCovid("202113,2021-03-31,299,MG,União de Minas,3170438,city,144,3361.34454,0,2,0,0.0139,4284,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,313,MT,Reserva do Cabaçal,5107156,city,200,7291.28691,2,5,0,0.025,2743,True,False".split(",")),
				new DadoCovid("202115,2021-04-15,292,RN,Água Nova,2400406,city,204,6234.71883,0,2,0,0.0098,3272,True,False".split(",")),
				new DadoCovid("202113,2021-03-31,279,MG,Datas,3121001,city,207,3818.48367,3,5,0,0.0242,5421,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,330,PI,Patos do Piauí,2207777,city,236,3684.04621,7,4,0,0.0169,6406,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,323,RS,Quinze de Novembro,4315354,city,403,10596.89719,3,5,0,0.0124,3803,True,False".split(",")),
				new DadoCovid("202118,2021-05-05,363,PR,Abatiá,4100103,city,621,8382.82937,27,9,0,0.0145,7408,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,331,BA,Caatiba,2904803,city,718,11066.58446,1,8,0,0.0111,6488,True,False".split(",")),
				new DadoCovid("202118,2021-05-02,360,AL,São Luís do Quitunde,2708501,city,1052,3032.3994,3,22,0,0.0209,34692,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,370,CE,Mucambo,2309003,city,1171,8048.66314,12,19,3,0.0162,14549,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,364,SP,Tabatinga,3552700,city,1416,8507.5703,11,44,0,0.0311,16644,True,False".split(",")),
				new DadoCovid("202118,2021-05-03,407,SC,Içara,4207007,city,5765,10070.3967,22,77,0,0.0134,57247,True,False".split(",")),
				new DadoCovid("202118,2021-05-03,373,AM,Humaitá,1301704,city,7362,13112.71017,7,136,0,0.0185,56144,True,False".split(","))
		});
		
		cidadesOrdenadasAsc = new Array<DadoCovid>(new DadoCovid[] {
				new DadoCovid("202118,2021-05-05,363,PR,Abatiá,4100103,city,621,8382.82937,27,9,0,0.0145,7408,True,False".split(",")),
				new DadoCovid("202115,2021-04-15,292,RN,Água Nova,2400406,city,204,6234.71883,0,2,0,0.0098,3272,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,331,BA,Caatiba,2904803,city,718,11066.58446,1,8,0,0.0111,6488,True,False".split(",")),
				new DadoCovid("202113,2021-03-31,279,MG,Datas,3121001,city,207,3818.48367,3,5,0,0.0242,5421,True,False".split(",")),
				new DadoCovid("202118,2021-05-03,373,AM,Humaitá,1301704,city,7362,13112.71017,7,136,0,0.0185,56144,True,False".split(",")),
				new DadoCovid("202118,2021-05-03,407,SC,Içara,4207007,city,5765,10070.3967,22,77,0,0.0134,57247,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,370,CE,Mucambo,2309003,city,1171,8048.66314,12,19,3,0.0162,14549,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,330,PI,Patos do Piauí,2207777,city,236,3684.04621,7,4,0,0.0169,6406,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,323,RS,Quinze de Novembro,4315354,city,403,10596.89719,3,5,0,0.0124,3803,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,313,MT,Reserva do Cabaçal,5107156,city,200,7291.28691,2,5,0,0.025,2743,True,False".split(",")),
				new DadoCovid("202118,2021-05-02,360,AL,São Luís do Quitunde,2708501,city,1052,3032.3994,3,22,0,0.0209,34692,True,False".split(",")),
				new DadoCovid("202115,2021-04-15,292,RN,Sítio Novo,2413706,city,120,2157.88527,0,6,0,0.05,5561,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,364,SP,Tabatinga,3552700,city,1416,8507.5703,11,44,0,0.0311,16644,True,False".split(",")),
				new DadoCovid("202113,2021-03-31,299,MG,União de Minas,3170438,city,144,3361.34454,0,2,0,0.0139,4284,True,False".split(",")),
				new DadoCovid("202113,2021-03-31,330,MG,Wenceslau Braz,3172202,city,108,4238.61852,2,0,0,0.0,2548,True,False".split(","))
		});
		
		confirmadosAcumuladosOrdenadosDesc = new Array<DadoCovid>(new DadoCovid[] {
				new DadoCovid("202118,2021-05-03,373,AM,Humaitá,1301704,city,7362,13112.71017,7,136,0,0.0185,56144,True,False".split(",")),
				new DadoCovid("202118,2021-05-03,407,SC,Içara,4207007,city,5765,10070.3967,22,77,0,0.0134,57247,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,364,SP,Tabatinga,3552700,city,1416,8507.5703,11,44,0,0.0311,16644,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,370,CE,Mucambo,2309003,city,1171,8048.66314,12,19,3,0.0162,14549,True,False".split(",")),
				new DadoCovid("202118,2021-05-02,360,AL,São Luís do Quitunde,2708501,city,1052,3032.3994,3,22,0,0.0209,34692,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,331,BA,Caatiba,2904803,city,718,11066.58446,1,8,0,0.0111,6488,True,False".split(",")),
				new DadoCovid("202118,2021-05-05,363,PR,Abatiá,4100103,city,621,8382.82937,27,9,0,0.0145,7408,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,323,RS,Quinze de Novembro,4315354,city,403,10596.89719,3,5,0,0.0124,3803,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,330,PI,Patos do Piauí,2207777,city,236,3684.04621,7,4,0,0.0169,6406,True,False".split(",")),
				new DadoCovid("202113,2021-03-31,279,MG,Datas,3121001,city,207,3818.48367,3,5,0,0.0242,5421,True,False".split(",")),
				new DadoCovid("202115,2021-04-15,292,RN,Água Nova,2400406,city,204,6234.71883,0,2,0,0.0098,3272,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,313,MT,Reserva do Cabaçal,5107156,city,200,7291.28691,2,5,0,0.025,2743,True,False".split(",")),
				new DadoCovid("202113,2021-03-31,299,MG,União de Minas,3170438,city,144,3361.34454,0,2,0,0.0139,4284,True,False".split(",")),
				new DadoCovid("202115,2021-04-15,292,RN,Sítio Novo,2413706,city,120,2157.88527,0,6,0,0.05,5561,True,False".split(",")),
				new DadoCovid("202113,2021-03-31,330,MG,Wenceslau Braz,3172202,city,108,4238.61852,2,0,0,0.0,2548,True,False".split(","))
		});
		
		cidadesOrdenadasDesc = new Array<DadoCovid>(new DadoCovid[] {
				new DadoCovid("202113,2021-03-31,330,MG,Wenceslau Braz,3172202,city,108,4238.61852,2,0,0,0.0,2548,True,False".split(",")),
				new DadoCovid("202113,2021-03-31,299,MG,União de Minas,3170438,city,144,3361.34454,0,2,0,0.0139,4284,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,364,SP,Tabatinga,3552700,city,1416,8507.5703,11,44,0,0.0311,16644,True,False".split(",")),
				new DadoCovid("202115,2021-04-15,292,RN,Sítio Novo,2413706,city,120,2157.88527,0,6,0,0.05,5561,True,False".split(",")),
				new DadoCovid("202118,2021-05-02,360,AL,São Luís do Quitunde,2708501,city,1052,3032.3994,3,22,0,0.0209,34692,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,313,MT,Reserva do Cabaçal,5107156,city,200,7291.28691,2,5,0,0.025,2743,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,323,RS,Quinze de Novembro,4315354,city,403,10596.89719,3,5,0,0.0124,3803,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,330,PI,Patos do Piauí,2207777,city,236,3684.04621,7,4,0,0.0169,6406,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,370,CE,Mucambo,2309003,city,1171,8048.66314,12,19,3,0.0162,14549,True,False".split(",")),
				new DadoCovid("202118,2021-05-03,407,SC,Içara,4207007,city,5765,10070.3967,22,77,0,0.0134,57247,True,False".split(",")),
				new DadoCovid("202118,2021-05-03,373,AM,Humaitá,1301704,city,7362,13112.71017,7,136,0,0.0185,56144,True,False".split(",")),
				new DadoCovid("202113,2021-03-31,279,MG,Datas,3121001,city,207,3818.48367,3,5,0,0.0242,5421,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,331,BA,Caatiba,2904803,city,718,11066.58446,1,8,0,0.0111,6488,True,False".split(",")),
				new DadoCovid("202115,2021-04-15,292,RN,Água Nova,2400406,city,204,6234.71883,0,2,0,0.0098,3272,True,False".split(",")),
				new DadoCovid("202118,2021-05-05,363,PR,Abatiá,4100103,city,621,8382.82937,27,9,0,0.0145,7408,True,False".split(",")),
		});
		
		dadosDesordenados = new Array<DadoCovid>(new DadoCovid[] {
				new DadoCovid("202118,2021-05-04,331,BA,Caatiba,2904803,city,718,11066.58446,1,8,0,0.0111,6488,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,370,CE,Mucambo,2309003,city,1171,8048.66314,12,19,3,0.0162,14549,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,313,MT,Reserva do Cabaçal,5107156,city,200,7291.28691,2,5,0,0.025,2743,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,330,PI,Patos do Piauí,2207777,city,236,3684.04621,7,4,0,0.0169,6406,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,323,RS,Quinze de Novembro,4315354,city,403,10596.89719,3,5,0,0.0124,3803,True,False".split(",")),
				new DadoCovid("202118,2021-05-03,407,SC,Içara,4207007,city,5765,10070.3967,22,77,0,0.0134,57247,True,False".split(",")),
				new DadoCovid("202115,2021-04-15,292,RN,Água Nova,2400406,city,204,6234.71883,0,2,0,0.0098,3272,True,False".split(",")),
				new DadoCovid("202113,2021-03-31,279,MG,Datas,3121001,city,207,3818.48367,3,5,0,0.0242,5421,True,False".split(",")),
				new DadoCovid("202113,2021-03-31,299,MG,União de Minas,3170438,city,144,3361.34454,0,2,0,0.0139,4284,True,False".split(",")),
				new DadoCovid("202113,2021-03-31,330,MG,Wenceslau Braz,3172202,city,108,4238.61852,2,0,0,0.0,2548,True,False".split(",")),
				new DadoCovid("202115,2021-04-15,292,RN,Sítio Novo,2413706,city,120,2157.88527,0,6,0,0.05,5561,True,False".split(",")),
				new DadoCovid("202118,2021-05-02,360,AL,São Luís do Quitunde,2708501,city,1052,3032.3994,3,22,0,0.0209,34692,True,False".split(",")),
				new DadoCovid("202118,2021-05-03,373,AM,Humaitá,1301704,city,7362,13112.71017,7,136,0,0.0185,56144,True,False".split(",")),
				new DadoCovid("202118,2021-05-04,364,SP,Tabatinga,3552700,city,1416,8507.5703,11,44,0,0.0311,16644,True,False".split(",")),
				new DadoCovid("202118,2021-05-05,363,PR,Abatiá,4100103,city,621,8382.82937,27,9,0,0.0145,7408,True,False".split(","))
		});
	}

	@Test
	void testSelectionSortInteger() throws Exception {
		Sort algoritmo = new SelectionSort();
		algoritmo.sortInteger(dadosDesordenados, "getConfirmadosAcumulados");

		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(confirmadosAcumuladosOrdenadosAsc.get(i).getConfirmadosAcumulados(), dadosDesordenados.get(i).getConfirmadosAcumulados(), "A ordenação do SelectionSort falhou para inteiros!");
		}
	}

	@Test
	void testSelectionSortString() throws Exception {
		Sort algoritmo = new SelectionSort();
		algoritmo.sortString(dadosDesordenados, "getCidade");

		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(cidadesOrdenadasAsc.get(i).getCidade(), dadosDesordenados.get(i).getCidade(), "A ordenação do SelectionSort falhou para strings!");
		}
	}

	@Test
	void testInsertionSortInteger() throws Exception {
		Sort algoritmo = new InsertionSort();
		algoritmo.sortInteger(dadosDesordenados, "getConfirmadosAcumulados");

		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(confirmadosAcumuladosOrdenadosAsc.get(i).getConfirmadosAcumulados(), dadosDesordenados.get(i).getConfirmadosAcumulados(), "A ordenação do InsertionSort falhou para inteiros!");
		}
	}

	@Test
	void testInsertionSortString() throws Exception {
		Sort algoritmo = new InsertionSort();
		algoritmo.sortString(dadosDesordenados, "getCidade");

		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(cidadesOrdenadasAsc.get(i).getCidade(), dadosDesordenados.get(i).getCidade(), "A ordenação do InsertionSort falhou para strings!");
		}
	}

	@Test
	void testMergeSortInteger() throws Exception {
		Sort algoritmo = new MergeSort();
		algoritmo.sortInteger(dadosDesordenados, "getConfirmadosAcumulados");

		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(confirmadosAcumuladosOrdenadosAsc.get(i).getConfirmadosAcumulados(), dadosDesordenados.get(i).getConfirmadosAcumulados(), "A ordenação do MergeSort falhou para inteiros!");
		}
	}

	@Test
	void testMergeSortString() throws Exception {
		Sort algoritmo = new MergeSort();
		algoritmo.sortString(dadosDesordenados, "getCidade");

		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(cidadesOrdenadasAsc.get(i).getCidade(), dadosDesordenados.get(i).getCidade(), "A ordenação do MergeSort falhou para strings!");
		}
	}

	@Test
	void testQuickSortInteger() throws Exception {
		Sort algoritmo = new QuickSort();
		algoritmo.sortInteger(dadosDesordenados, "getConfirmadosAcumulados");

		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(confirmadosAcumuladosOrdenadosAsc.get(i).getConfirmadosAcumulados(), dadosDesordenados.get(i).getConfirmadosAcumulados(), "A ordenação do QuickSort falhou para inteiros!");
		}
	}

	@Test
	void testQuickSortString() throws Exception {
		Sort algoritmo = new QuickSort();
		algoritmo.sortString(dadosDesordenados, "getCidade");

		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(cidadesOrdenadasAsc.get(i).getCidade(), dadosDesordenados.get(i).getCidade(), "A ordenação do QuickSort falhou para strings!");
		}
	}

	@Test
	void testQuickSortMedianaDeTresIntegerAsc() throws Exception {
		QuickSortMedianaDeTres algoritmo = new QuickSortMedianaDeTres();
		algoritmo.sortInteger(dadosDesordenados, "getConfirmadosAcumulados");
		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(confirmadosAcumuladosOrdenadosAsc.get(i).getConfirmadosAcumulados(), dadosDesordenados.get(i).getConfirmadosAcumulados(), "A ordenação do QuickSortMedianaDeTres falhou para inteiros!");
		}
	}

	@Test
	void testQuickSortMedianaDeTresStringAsc() throws Exception {
		QuickSortMedianaDeTres algoritmo = new QuickSortMedianaDeTres();
		algoritmo.sortString(dadosDesordenados, "getCidade");

		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(cidadesOrdenadasAsc.get(i).getCidade(), dadosDesordenados.get(i).getCidade(), "A ordenação do QuickSortMedianaDeTres falhou para strings!");
		}
	}
	
	@Test
	void testQuickSortMedianaDeTresIntegerDesc() throws Exception {
		QuickSortMedianaDeTres algoritmo = new QuickSortMedianaDeTres();
		algoritmo.sortIntegerDesc(dadosDesordenados, "getConfirmadosAcumulados");
		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(confirmadosAcumuladosOrdenadosDesc.get(i).getConfirmadosAcumulados(), dadosDesordenados.get(i).getConfirmadosAcumulados(), "A ordenação do QuickSortMedianaDeTres falhou para inteiros!");
		}
	}

	@Test
	void testQuickSortMedianaDeTresStringDesc() throws Exception {
		QuickSortMedianaDeTres algoritmo = new QuickSortMedianaDeTres();
		algoritmo.sortStringDesc(dadosDesordenados, "getCidade");

		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(cidadesOrdenadasDesc.get(i).getCidade(), dadosDesordenados.get(i).getCidade(), "A ordenação do QuickSortMedianaDeTres falhou para strings!");
		}
	}

	@Test
	void testCountingSortInteger() throws Exception {
		CountingSort algoritmo = new CountingSort();
		dadosDesordenados = algoritmo.sortInteger(dadosDesordenados, "getConfirmadosAcumulados");

		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(confirmadosAcumuladosOrdenadosAsc.get(i).getConfirmadosAcumulados(), dadosDesordenados.get(i).getConfirmadosAcumulados(), "A ordenação do CountingSort falhou para inteiros!");
		}
	}

	@Test
	void testHeapSortInteger() throws Exception {
		Sort algoritmo = new HeapSort();
		algoritmo.sortInteger(dadosDesordenados, "getConfirmadosAcumulados");

		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(confirmadosAcumuladosOrdenadosAsc.get(i).getConfirmadosAcumulados(), dadosDesordenados.get(i).getConfirmadosAcumulados(), "A ordenação do HeapSort falhou para inteiros!");
		}
	}

	@Test
	void testHeapSortString() throws Exception {
		Sort algoritmo = new HeapSort();
		algoritmo.sortString(dadosDesordenados, "getCidade");

		for (int i = 0; i < dadosDesordenados.size(); i++) {
			assertEquals(cidadesOrdenadasAsc.get(i).getCidade(), dadosDesordenados.get(i).getCidade(), "A ordenação do HeapSort falhou para strings!");
		}
	}

}