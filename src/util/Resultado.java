package util;

public class Resultado {

	public Resultado() {}
	
	public static int executionTime(Long startTime, Long stopTime) {
		Long result = (stopTime - startTime) / 1000000L;
		return result.intValue();
	}
	
	public static void tabela(String titulo, Array<String> nomesLinhas, Array<String> nomesColunas, Array<Integer> valoresColuna1, Array<Integer> valoresColuna2, Array<Integer> valoresColuna3) {
		String format = "|%1$-35s|%2$-25s|%3$-25s|%4$-25s|\n";
		System.out.println("-".repeat(115));
		System.out.printf("%" + (115 + titulo.length())/2 + "s\n", titulo);
		System.out.println("-".repeat(115));
		System.out.format(format, nomesColunas.get(0), nomesColunas.get(1), nomesColunas.get(2), nomesColunas.get(3));
		System.out.println("-".repeat(115));
		
		for(int i = 0; i < nomesLinhas.size(); i++) {
			System.out.format(format, nomesLinhas.get(i), valoresColuna1.get(i) == 0 ? "-" : valoresColuna1.get(i) + "ms", valoresColuna2.get(i) == 0 ? "-" : valoresColuna2.get(i) + "ms", valoresColuna3.get(i) == 0 ? "-" : valoresColuna3.get(i) + "ms");
		}
		
		System.out.println("-".repeat(115));
	}	
	
}