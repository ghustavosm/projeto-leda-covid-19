package sort;

import data.DadoCovid;
import util.Array;

public interface Sort {

	void sortInteger(Array<DadoCovid> A, String method) throws Exception;
	void sortString(Array<DadoCovid> A, String method) throws Exception;

}