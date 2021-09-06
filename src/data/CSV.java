package data;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

import util.Array;

public class CSV {
	
	public static String getCabecalho() {
		return "epidemiological_week,date,order_for_place,state,city,city_ibge_code,place_type,last_available_confirmed,last_available_confirmed_per_100k_inhabitants,new_confirmed,last_available_deaths,new_deaths,last_available_death_rate,estimated_population,is_last,is_repeated";
	}
	
	public static Array<DadoCovid> ler(String fileName) {
        Array<DadoCovid> data = new Array<DadoCovid>();        
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int count = 0;
            String row;
            while((row = bufferedReader.readLine()) != null) {
            	String[] col = row.split(",");
                if (count != 0) {
                	data.add(new DadoCovid(col));
                }
                count++;
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception error) {
            System.err.println("Erro ao ler o arquivo.");
        }
        return data;
	}
	
	public static void gravar(Array<DadoCovid> data, String fileName) {
        try {
			FileOutputStream  file = new FileOutputStream(fileName);
			PrintWriter writer = new PrintWriter(file);
			writer.println(CSV.getCabecalho() + "\n" + data.toString());
			writer.close();
			file.close();
		} catch(Exception e) {
			System.out.println("Erro ao gravar o arquivo.");
		}
	}

}