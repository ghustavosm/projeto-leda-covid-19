package data;

public class DadoCovid {
	
	private String semanaEpidemiologica;
	private String data;
	private int diasPrimeiroCaso;
	private String estado;
	private String cidade;
	private int cidadeCodigoIBGE;
	private String tipoLugar;
	private int confirmadosAcumulados;
	private float confirmadosAcumuladosPor100k;
	private int novosConfirmados;
	private int obitosAcumulados;
	private int novasMortes;
	private float obitosPorConfirmados;
	private int populacaoEstimada;
	private boolean ultimaAtualizacao;
	private boolean dadoRepetido;
	
	public DadoCovid() {}

	public DadoCovid(String[] col) {
		semanaEpidemiologica = col[0];
		data = col[1];
		diasPrimeiroCaso = col[2].equals("") ? 0 : Integer.parseInt(col[2]);
		estado = col[3];
		cidade = col[4];
		cidadeCodigoIBGE = col[5].equals("") ? 0 : Integer.parseInt(col[5]);
		tipoLugar = col[6];
		confirmadosAcumulados = col[7].equals("") ? 0 : Integer.parseInt(col[7]);
		confirmadosAcumuladosPor100k = col[8].equals("") ? 0 : Float.parseFloat(col[8]);
		novosConfirmados = col[9].equals("") ? 0 : Integer.parseInt(col[9]);
		obitosAcumulados = col[10].equals("") ? 0 : Integer.parseInt(col[10]);
		novasMortes = col[11].equals("") ? 0 : Integer.parseInt(col[11]);
		obitosPorConfirmados = col[12].equals("") ? 0 : Float.parseFloat(col[12]);
		populacaoEstimada = col[13].equals("") ? 0 : Integer.parseInt(col[13]);
		ultimaAtualizacao = Boolean.parseBoolean(col[14]);
		dadoRepetido = Boolean.parseBoolean(col[15]);
	}

	public String getSemanaEpidemiologica() {
		return semanaEpidemiologica;
	}
	
	public String getData() {
		return data;
	}
	
	public int getDiasPrimeiroCaso() {
		return diasPrimeiroCaso;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public int getCidadeCodigoIBGE() {
		return cidadeCodigoIBGE;
	}
	
	public String getTipoLugar() {
		return tipoLugar;
	}
	
	public int getConfirmadosAcumulados() {
		return confirmadosAcumulados;
	}
	
	public float getConfirmadosAcumuladosPor100k() {
		return confirmadosAcumuladosPor100k;
	}
	
	public int getNovosConfirmados() {
		return novosConfirmados;
	}
	
	public int getObitosAcumulados() {
		return obitosAcumulados;
	}
	
	public int getNovasMortes() {
		return novasMortes;
	}
	
	public float getObitosPorConfirmados() {
		return obitosPorConfirmados;
	}
	
	public int getPopulacaoEstimada() {
		return populacaoEstimada;
	}
	
	public boolean getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}
	
	public boolean getDadoRepetido() {
		return dadoRepetido;
	}
	
	@Override
	public String toString() {
		String string = "";
		string += getSemanaEpidemiologica() + ",";
		string += getData() + ",";
		string += getDiasPrimeiroCaso() + ",";
		string += getEstado() + ",";
		string += getCidade() + ",";
		string += getCidadeCodigoIBGE() + ",";
		string += getTipoLugar() + ",";
		string += getConfirmadosAcumulados() + ",";
		string += getConfirmadosAcumuladosPor100k() + ",";
		string += getNovosConfirmados() + ",";
		string += getObitosAcumulados() + ",";
		string += getNovasMortes() + ",";
		string += getObitosPorConfirmados() + ",";
		string += getPopulacaoEstimada() + ",";
		string += getUltimaAtualizacao() + ",";
		string += getDadoRepetido();
		return string;
	}

}