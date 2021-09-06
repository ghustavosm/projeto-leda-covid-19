package app;

import data.DadoCovid;
import sort.CountingSort;
import sort.HeapSort;
import sort.InsertionSort;
import sort.MergeSort;
import sort.QuickSort;
import sort.QuickSortMedianaDeTres;
import sort.SelectionSort;
import sort.Sort;
import util.Resultado;
import util.Array;
import data.CSV;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		
		Array<DadoCovid> data;
		Sort algoritmo;
		Long startTime = 0L;
		Long stopTime = 0L;
		Array<Integer> cidadeTemposMedioCaso = new Array<Integer>();
		Array<Integer> obitosTemposMedioCaso = new Array<Integer>();
		Array<Integer> confirmadosTemposMedioCaso = new Array<Integer>();
		QuickSortMedianaDeTres qsort;
		
		// prepara os arquivos para os melhores casos
		System.out.println("Preparando os arquivos para os melhores casos...");
		
		data = CSV.ler("db/covid19.csv");
		qsort = new QuickSortMedianaDeTres();
		qsort.sortString(data, "getCidade");
		CSV.gravar(data, "db/cases/covid19-cidade-asc.csv");
		
		data = CSV.ler("db/covid19.csv");
		qsort = new QuickSortMedianaDeTres();
		qsort.sortInteger(data, "getObitosAcumulados");
		CSV.gravar(data, "db/cases/covid19-obitos-acumulados-asc.csv");
		
		data = CSV.ler("db/covid19.csv");
		qsort = new QuickSortMedianaDeTres();
		qsort.sortInteger(data, "getConfirmadosAcumulados");
		CSV.gravar(data, "db/cases/covid19-confirmados-acumulados-asc.csv");
		
		// prepara o arquivo para os casos médios
		System.out.println("Preparando o arquivo para os casos médios...");
		
		data = CSV.ler("db/covid19.csv");
		data.shuffle();
		CSV.gravar(data, "db/cases/covid19-shuffled.csv");
		
		// prepara os arquivos para os piores casos
		System.out.println("Preparando os arquivos para os piores casos...");
		
		data = CSV.ler("db/covid19.csv");
		qsort = new QuickSortMedianaDeTres();
		qsort.sortStringDesc(data, "getCidade");
		CSV.gravar(data, "db/cases/covid19-cidade-desc.csv");
		
		data = CSV.ler("db/covid19.csv");
		qsort = new QuickSortMedianaDeTres();
		qsort.sortIntegerDesc(data, "getObitosAcumulados");
		CSV.gravar(data, "db/cases/covid19-obitos-acumulados-desc.csv");
		
		data = CSV.ler("db/covid19.csv");
		qsort = new QuickSortMedianaDeTres();
		qsort.sortIntegerDesc(data, "getConfirmadosAcumulados");
		CSV.gravar(data, "db/cases/covid19-confirmados-acumulados-desc.csv");
		
		System.out.println();
		System.out.println("Iniciando ordenações para os casos médios...");
		
		/*
		 * CountingSort
		 */		
		System.out.println("Ordenando com CountingSort...");
		
		// Adiciona 0 no tempo de ordenação das cidades, pois o CountingSort não ordena strings
		cidadeTemposMedioCaso.add(0);
		
		// getObitosAcumulados
		data = CSV.ler("db/cases/covid19-shuffled.csv");
		startTime = System.nanoTime();
		CountingSort countingSort = new CountingSort();
		Array<DadoCovid> dataSorted = countingSort.sortInteger(data, "getObitosAcumulados");
		stopTime = System.nanoTime();		
		obitosTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));
		CSV.gravar(data, "db/sorted/countingsort-obitos-acumulados.csv");
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		countingSort = new CountingSort();
		dataSorted = countingSort.sortInteger(data, "getConfirmadosAcumulados");	
		stopTime = System.nanoTime();		
		confirmadosTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));
		CSV.gravar(data, "db/sorted/countingsort-confirmados-acumulados.csv");
		
		/*
		 * MergeSort
		 */		
		System.out.println("Ordenando com MergeSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new MergeSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));
		CSV.gravar(data, "db/sorted/mergesort-cidade.csv");
		
		// getObitosAcumulados
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new MergeSort();
		algoritmo.sortInteger(data, "getObitosAcumulados");
		stopTime = System.nanoTime();
		obitosTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/mergesort-obitos-acumulados.csv");
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new MergeSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/mergesort-confirmados-acumulados.csv");
		
		/*
		 * QuickSortMedianaDeTres
		 */		
		System.out.println("Ordenando com QuickSortMedianaDeTres...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new QuickSortMedianaDeTres();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/quicksort-md3-cidade.csv");
		
		// getObitosAcumulados
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new QuickSortMedianaDeTres();
		algoritmo.sortInteger(data, "getObitosAcumulados");
		stopTime = System.nanoTime();
		obitosTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/quicksort-md3-obitos-acumulados.csv");
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new QuickSortMedianaDeTres();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/quicksort-md3-confirmados-acumulados.csv");
		
		/*
		 * HeapSort
		 */		
		System.out.println("Ordenando com HeapSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new HeapSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/heapsort-cidade.csv");
		
		// getObitosAcumulados
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new HeapSort();
		algoritmo.sortInteger(data, "getObitosAcumulados");
		stopTime = System.nanoTime();
		obitosTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/heapsort-obitos-acumulados.csv");
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new HeapSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/heapsort-confirmados-acumulados.csv");
		
		/*
		 * QuickSort
		 */		
		System.out.println("Ordenando com QuickSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new QuickSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/quicksort-cidade.csv");
		
		// getObitosAcumulados
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new QuickSort();
		algoritmo.sortInteger(data, "getObitosAcumulados");
		stopTime = System.nanoTime();
		obitosTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/quicksort-obitos-acumulados.csv");
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new QuickSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/quicksort-confirmados-acumulados.csv");
		
		/*
		 * InsertionSort
		 */		
		System.out.println("Ordenando com InsertionSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new InsertionSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/insertionsort-cidade.csv");
		
		// getObitosAcumulados
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new InsertionSort();
		algoritmo.sortInteger(data, "getObitosAcumulados");
		stopTime = System.nanoTime();
		obitosTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/insertionsort-obitos-acumulados.csv");
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new InsertionSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/insertionsort-confirmados-acumulados.csv");
		
		/*
		 * SelectionSort
		 */		
		System.out.println("Ordenando com SelectionSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new SelectionSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/selectionsort-cidade.csv");
		
		// getObitosAcumulados
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new SelectionSort();
		algoritmo.sortInteger(data, "getObitosAcumulados");
		stopTime = System.nanoTime();
		obitosTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/selectionsort-obitos-acumulados.csv");
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-shuffled.csv");		
		startTime = System.nanoTime();
		algoritmo = new SelectionSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposMedioCaso.add(Resultado.executionTime(startTime, stopTime));		
		CSV.gravar(data, "db/sorted/selectionsort-confirmados-acumulados.csv");		
		
		System.out.println("Ordenações finalizadas com sucesso!");
		
		
		//----------------------------------------------- PARTE DO PROGRAMA QUE RODA OS ALGORTIMOS COM O ARQUIVO DECRESCENTE (PIOR CASO) ----------------------------------------------
		
		Array<Integer> cidadeTemposPiorCaso = new Array<Integer>();
		Array<Integer> confirmadosTemposPiorCaso = new Array<Integer>();
		
		System.out.println();
		System.out.println("Iniciando ordenações para piores casos...");
		
		/*
		 * CountingSort
		 */		
		System.out.println("Ordenando com CountingSort...");
		
		// Adiciona 0 no tempo de ordenação do CountingSort
		cidadeTemposPiorCaso.add(0);		
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-confirmados-acumulados-desc.csv");		
		startTime = System.nanoTime();
		 countingSort = new CountingSort();
		 dataSorted = countingSort.sortInteger(data, "getConfirmadosAcumulados");	
		stopTime = System.nanoTime();
		confirmadosTemposPiorCaso.add(Resultado.executionTime(startTime, stopTime));
		
		/*
		 * MergeSort
		 */		
		System.out.println("Ordenando com MergeSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-cidade-desc.csv");		
		startTime = System.nanoTime();
		algoritmo = new MergeSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposPiorCaso.add(Resultado.executionTime(startTime, stopTime));
	
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-confirmados-acumulados-desc.csv");		
		startTime = System.nanoTime();
		algoritmo = new MergeSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposPiorCaso.add(Resultado.executionTime(startTime, stopTime));
		
		/*
		 * QuickSortMedianaDeTres
		 */		
		System.out.println("Ordenando com QuickSortMedianaDeTres...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-cidade-desc.csv");		
		startTime = System.nanoTime();
		algoritmo = new QuickSortMedianaDeTres();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposPiorCaso.add(Resultado.executionTime(startTime, stopTime));
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-confirmados-acumulados-desc.csv");		
		startTime = System.nanoTime();
		algoritmo = new QuickSortMedianaDeTres();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposPiorCaso.add(Resultado.executionTime(startTime, stopTime));
		
		/*
		 * HeapSort
		 */		
		System.out.println("Ordenando com HeapSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-cidade-desc.csv");		
		startTime = System.nanoTime();
		algoritmo = new HeapSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposPiorCaso.add(Resultado.executionTime(startTime, stopTime));		
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-confirmados-acumulados-desc.csv");		
		startTime = System.nanoTime();
		algoritmo = new HeapSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposPiorCaso.add(Resultado.executionTime(startTime, stopTime));		
		
		/*
		 * QuickSort
		 */		
		System.out.println("Ordenando com QuickSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-cidade-desc.csv");		
		startTime = System.nanoTime();
		algoritmo = new QuickSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposPiorCaso.add(Resultado.executionTime(startTime, stopTime));		
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-confirmados-acumulados-desc.csv");		
		startTime = System.nanoTime();
		algoritmo = new QuickSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposPiorCaso.add(Resultado.executionTime(startTime, stopTime));		

		/*
		 * InsertionSort
		 */		
		System.out.println("Ordenando com InsertionSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-cidade-desc.csv");		
		startTime = System.nanoTime();
		algoritmo = new InsertionSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposPiorCaso.add(Resultado.executionTime(startTime, stopTime));		
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-confirmados-acumulados-desc.csv");		
		startTime = System.nanoTime();
		algoritmo = new InsertionSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposPiorCaso.add(Resultado.executionTime(startTime, stopTime));		;
		
		/*
		 * SelectionSort
		 */		
		System.out.println("Ordenando com SelectionSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-cidade-desc.csv");		
		startTime = System.nanoTime();
		algoritmo = new SelectionSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposPiorCaso.add(Resultado.executionTime(startTime, stopTime));		
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-confirmados-acumulados-desc.csv");		
		startTime = System.nanoTime();
		algoritmo = new SelectionSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposPiorCaso.add(Resultado.executionTime(startTime, stopTime));		
		
		System.out.println("Ordenações  de piores casos finalizadas com sucesso!");
		
		
		//----------------------------------------------- PARTE DO PROGRAMA QUE RODA OS ALGORTIMOS COM O ARQUIVO CRESCENTE (MELHOR CASO) ----------------------------------------------
		
		Array<Integer> cidadeTemposMelhorCaso = new Array<Integer>();
		Array<Integer> confirmadosTemposMelhorCaso = new Array<Integer>();
		
		System.out.println();
		System.out.println("Iniciando ordenações para melhores casos...");
		
		/*
		 * CountingSort
		 */		
		System.out.println("Ordenando com CountingSort...");
		
		// Adiciona 0 no tempo de ordenação do CountingSort
		cidadeTemposMelhorCaso.add(0);		
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-confirmados-acumulados-asc.csv");		
		startTime = System.nanoTime();
		 countingSort = new CountingSort();
		 dataSorted = countingSort.sortInteger(data, "getConfirmadosAcumulados");	
		stopTime = System.nanoTime();
		confirmadosTemposMelhorCaso.add(Resultado.executionTime(startTime, stopTime));
		
		/*
		 * MergeSort
		 */		
		System.out.println("Ordenando com MergeSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-cidade-asc.csv");		
		startTime = System.nanoTime();
		algoritmo = new MergeSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposMelhorCaso.add(Resultado.executionTime(startTime, stopTime));
	
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-confirmados-acumulados-asc.csv");		
		startTime = System.nanoTime();
		algoritmo = new MergeSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposMelhorCaso.add(Resultado.executionTime(startTime, stopTime));
		
		/*
		 * QuickSortMedianaDeTres
		 */		
		System.out.println("Ordenando com QuickSortMedianaDeTres...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-cidade-asc.csv");		
		startTime = System.nanoTime();
		algoritmo = new QuickSortMedianaDeTres();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposMelhorCaso.add(Resultado.executionTime(startTime, stopTime));				
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-confirmados-acumulados-asc.csv");		
		startTime = System.nanoTime();
		algoritmo = new QuickSortMedianaDeTres();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposMelhorCaso.add(Resultado.executionTime(startTime, stopTime));		
		
		/*
		 * HeapSort
		 */		
		System.out.println("Ordenando com HeapSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-cidade-asc.csv");		
		startTime = System.nanoTime();
		algoritmo = new HeapSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposMelhorCaso.add(Resultado.executionTime(startTime, stopTime));		
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-confirmados-acumulados-asc.csv");		
		startTime = System.nanoTime();
		algoritmo = new HeapSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposMelhorCaso.add(Resultado.executionTime(startTime, stopTime));		
		
		/*
		 * QuickSort
		 */		
		System.out.println("Ordenando com QuickSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-cidade-asc.csv");		
		startTime = System.nanoTime();
		algoritmo = new QuickSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposMelhorCaso.add(Resultado.executionTime(startTime, stopTime));		
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-confirmados-acumulados-asc.csv");		
		startTime = System.nanoTime();
		algoritmo = new QuickSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposMelhorCaso.add(Resultado.executionTime(startTime, stopTime));		

		/*
		 * InsertionSort
		 */		
		System.out.println("Ordenando com InsertionSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-cidade-asc.csv");		
		startTime = System.nanoTime();
		algoritmo = new InsertionSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposMelhorCaso.add(Resultado.executionTime(startTime, stopTime));		
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-confirmados-acumulados-asc.csv");		
		startTime = System.nanoTime();
		algoritmo = new InsertionSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposMelhorCaso.add(Resultado.executionTime(startTime, stopTime));		;
		
		/*
		 * SelectionSort
		 */		
		System.out.println("Ordenando com SelectionSort...");
		
		// getCidade
		data = CSV.ler("db/cases/covid19-cidade-asc.csv");		
		startTime = System.nanoTime();
		algoritmo = new SelectionSort();
		algoritmo.sortString(data, "getCidade");
		stopTime = System.nanoTime();
		cidadeTemposMelhorCaso.add(Resultado.executionTime(startTime, stopTime));		
		
		// getConfirmadosAcumulados
		data = CSV.ler("db/cases/covid19-confirmados-acumulados-asc.csv");
		startTime = System.nanoTime();
		algoritmo = new SelectionSort();
		algoritmo.sortInteger(data, "getConfirmadosAcumulados");
		stopTime = System.nanoTime();
		confirmadosTemposMelhorCaso.add(Resultado.executionTime(startTime, stopTime));
		
		System.out.println("Ordenações de melhores casos finalizadas com sucesso!");
		System.out.println();
		

		//--------------------------------------------------------- COM O MELHOR E PIOR CASO POSSO CRIAR AS DUAS TABELAS RESTANTES ----------------------------------------------------
		
		System.out.println();
		Array<String> nomesLinhas = new Array<String>(new String[] {"CountingSort","MergeSort","QuickSortMedianaDeTres","HeapSort","QuickSort","InsertionSort","SelectionSort"});
		Array<String> nomesColunas = new Array<String>(new String[] {"ALGORITMOS","TEMPO CIDADES","TEMPO ÓBITOS ACUMULADOS","TEMPO CASOS ACUMULADOS"});
		Resultado.tabela("TEMPO DE EXECUÇÃO DOS ALGORITMOS", nomesLinhas, nomesColunas, cidadeTemposMedioCaso, obitosTemposMedioCaso, confirmadosTemposMedioCaso);
		System.out.println();
		
		System.out.println();
		nomesColunas = new Array<String>(new String[] {"ALGORITMOS","TEMPO  MELHOR CASO","TEMPO MÉDIO CASO ","TEMPO PIOR CASO"});
		Resultado.tabela("TEMPO DE EXECUÇÃO DOS ALGORITMOS PARA ORDENAÇÃO DE NÚMEROS", nomesLinhas, nomesColunas, confirmadosTemposMelhorCaso, confirmadosTemposMedioCaso, confirmadosTemposPiorCaso);
		System.out.println();
		
		System.out.println();
		nomesColunas = new Array<String>(new String[] {"ALGORITMOS","TEMPO MELHOR CASO","TEMPO MÉDIO CASO ","TEMPO PIOR CASO"});
		Resultado.tabela("TEMPO DE EXECUÇÃO DOS ALGORITMOS PARA ORDENAÇÃO DE STRINGS", nomesLinhas, nomesColunas, cidadeTemposMelhorCaso , cidadeTemposMedioCaso, cidadeTemposPiorCaso);
		System.out.println();
	}
	
}