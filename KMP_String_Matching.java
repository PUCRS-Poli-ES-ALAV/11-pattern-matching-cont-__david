public class KMP_String_Matching { 

	public static long contador = 0;

  public static void main(String[] args) {
    
		KMPSearch(geraString(50,5) + "Z", geraString(5,2) + "Z");
		System.out.println(contador + " iteracoes - n = 50");
    
		KMPSearch(geraString(500,5) + "Z", geraString(50,20) + "Z");
		System.out.println(contador + " iteracoes - n = 500");
    
		KMPSearch(geraString(5000,5) + "Z", geraString(500,200) + "Z");
		System.out.println(contador + " iteracoes - n = 5k");
    
		KMPSearch(geraString(50000,5) + "Z", geraString(5000,2000) + "Z");
		System.out.println(contador + " iteracoes - n = 50k");
    
		KMPSearch(geraString(500000,5) + "Z", geraString(50000,20000) + "Z");
		System.out.println(contador + " iteracoes - n = 500k");
    
		KMPSearch(geraString(5000000,5) + "Z", geraString(500000,200000) + "Z");
		System.out.println(contador + " iteracoes - n = 5M");
		
		/**
		 * 65 iteracoes - n = 50
     * 650 iteracoes - n = 500
     * 6000 iteracoes - n = 5k
     * 60000 iteracoes - n = 50k
     * 600000 iteracoes - n = 500k
     * 6000000 iteracoes - n = 5M
		 * complexidade no pior caso: n
		 */

	}

	public static void KMPSearch(String pat, String txt) 
	{ 
		contador = 0;
		int M = pat.length(); 
		int N = txt.length(); 

		int lps[] = new int[M]; 
		int j = 0; 

		computeLPSArray(pat, M, lps); 

		int i = 0;
		while (i < N) { 
			contador++;
			if (pat.charAt(j) == txt.charAt(i)) { 
				j++; 
				i++; 
			} 
			if (j == M) { 
				System.out.println("Found pattern "	+ "at index " + (i - j)); 
				j = lps[j - 1]; 
			} 

			else if (i < N && pat.charAt(j) != txt.charAt(i)) { 
				if (j != 0) 
					j = lps[j - 1]; 
				else
					i = i + 1; 
			} 
		} 
	} 

	public static void computeLPSArray(String pat, int M, int lps[]) 
	{ 
		int len = 0; 
		int i = 1; 
		lps[0] = 0;

		while (i < M) { 
			contador++;
			if (pat.charAt(i) == pat.charAt(len)) { 
				len++; 
				lps[i] = len; 
				i++; 
			} 
			else { 
				if (len != 0) 
					len = lps[len - 1]; 
				else { 
					lps[i] = len; 
					i++; 
				} 
			} 
    }
	}
	
	private static String geraString(int size, int rep) {

		StringBuilder res = new StringBuilder();
		String charStr = "ABCDEFGHIJKLMOPQRSTWXYZ";
		int posCharStr = 0;

		if (size > 0 && rep > 0 && rep < charStr.length()) {
			for (int i = 0; i < size; i++) {
				res.append(charStr.charAt(posCharStr));
				posCharStr++;
				if (posCharStr == rep)
					posCharStr = 0;
			}
		}
		return res.toString();
	}
} 
