import java.util.*; 
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap; 


/**
*
* Por hacer pantalla de estadisticas
* http://www.ling.upenn.edu/courses/Fall_2003/ling001/penn_treebank_pos.html
* HACER STOP WORDS
*/


public class postagger{

//this array it will change for a input data text
static String texto = " there_EX must_MD be_VB some_DT word_NN today_NN from_IN my_PRP$ boyfriend_NN so_RB far_RB away_RB  ._. gov_NN websites_NNS 03_CD audi_NNS s6_NN 1_CD cemetery_NN rd_NN derry_NN nh_NN 10_CD reasons_NNS soccer_NN is_VBZ better_JJR than_IN football_NN 11_CD cooper_NN avenue_NN unit_NN 107_CD long_JJ branch_NN 18_CD and_CC over_IN clubs_NNS ";


//array with the suffix for work

static String[] posTaggerTags = {"_CC", "_CD", "_DT", "_EX", "_FW", "_IN", "_JJ", "_JJR", "_JJS", "_LS", "_MD", "_NN", "_NNS", "_NNP", "_NNPS", "_PDT", "_POS", "_PRP", "_PRP$", "_RB", "_RBR", "_RBS", "_RP", "_SYM", "_TO", "_UH", "_VB", "_VBD", "_VBG", "_VBN", "_VBP", "_VBZ", "_WDT", "_WP", "_WP$", "_WRB" };

static String stopwordsText[]={"a", "about", "above", "above", "across", "after", "afterwards", "again", "against", "all", "almost", "alone", "along", "already", "also","although","always","am","among", "amongst", "amoungst", "amount",  "an", "and", "another", "any","anyhow","anyone","anything","anyway", "anywhere", "are", "around", "as",  "at", "back","be","became", "because","become","becomes", "becoming", "been", "before", "beforehand", "behind", "being", "below", "beside", "besides", "between", "beyond", "bill", "both", "bottom","but", "by", "call", "can", "cannot", "cant", "co", "con", "could", "couldnt", "cry", "de", "describe", "detail", "do", "done", "down", "due", "during", "each", "eg", "eight", "either", "eleven","else", "elsewhere", "empty", "enough", "etc", "even", "ever", "every", "everyone", "everything", "everywhere", "except", "few", "fifteen", "fify", "fill", "find", "fire", "first", "five", "for", "former", "formerly", "forty", "found", "four", "from", "front", "full", "further", "get", "give", "go", "had", "has", "hasnt", "have", "he", "hence", "her", "here", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "him", "himself", "his", "how", "however", "hundred", "ie", "if", "in", "inc", "indeed", "interest", "into", "is", "it", "its", "itself", "keep", "last", "latter", "latterly", "least", "less", "ltd", "made", "many", "may", "me", "meanwhile", "might", "mill", "mine", "more", "moreover", "most", "mostly", "move", "much", "must", "my", "myself", "name", "namely", "neither", "never", "nevertheless", "next", "nine", "no", "nobody", "none", "noone", "nor", "not", "nothing", "now", "nowhere", "of", "off", "often", "on", "once", "one", "only", "onto", "or", "other", "others", "otherwise", "our", "ours", "ourselves", "out", "over", "own","part", "per", "perhaps", "please", "put", "rather", "re", "same", "see", "seem", "seemed", "seeming", "seems", "serious", "several", "she", "should", "show", "side", "since", "sincere", "six", "sixty", "so", "some", "somehow", "someone", "something", "sometime", "sometimes", "somewhere", "still", "such", "system", "take", "ten", "than", "that", "the", "their", "them", "themselves", "then", "thence", "there", "thereafter", "thereby", "therefore", "therein", "thereupon", "these", "they", "thickv", "thin", "third", "this", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "top", "toward", "towards", "twelve", "twenty", "two", "un", "under", "until", "up", "upon", "us", "very", "via", "was", "we", "well", "were", "what", "whatever", "when", "whence", "whenever", "where", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whoever", "whole", "whom", "whose", "why", "will", "with", "within", "without", "would", "yet", "you", "your", "yours", "yourself", "yourselves", "the"};



static HashMap<String,Integer> mapStopWords = new HashMap<String,Integer>();




/*
*
*	This return a count of some pattern in a text
*
*/
public static int conteoPatron(String cadena, String patron){

		int count = 0, start = 0, len = patron.length();
			
		while((start = cadena.indexOf(patron, start+=len)) > -1) count++;
				return count;
	

}





public static void printFrecuencia( String data ){

			String[] words=data.split(" ");
			HashMap<String,Integer> frequencies=new HashMap<String,Integer>();
			for (String w: Arrays.asList(words)){
			  Integer num=frequencies.get(w);
			  if (num!=null)
			    frequencies.put(w,num+1);
			  else
			    frequencies.put(w,1);
			}

			Set set = frequencies.entrySet(); 
			// Get an iterator 
			Iterator i = set.iterator(); 
			// Display elements from the hashmap
				while(i.hasNext()) { 
					Map.Entry me = (Map.Entry)i.next(); 

						/*
						if( (Integer)me.getValue() > 10000){  //System.out.println("EO");

							System.out.print(me.getKey() + ": "); 
							System.out.println(me.getValue() ); 
							//System.out.print("< "+ me.getKey() + ": "+me.getValue()+" > \n"); 
						 }
						 */

							System.out.print(""+ me.getKey() + ": "+me.getValue()+"\n"); 

				} 
			System.out.println(); 




}



public static void cleanTextSW ( String filepath){

	


	HashMap<String,Integer> mapTexto = new HashMap<String,Integer>();

	String arrayTexto[] = filepath.split(" ");

 	

	for ( int i=0; i< stopwordsText.length  ; i++){
			mapStopWords.put( stopwordsText[i],1 );
	}

	for( int j=0; j<arrayTexto.length;j++ ){
			//System.out.print(" "+ arrayTexto[j]+" " );
			mapTexto.put(arrayTexto[j],0);
	}

	for (int i=0; i < mapStopWords.size() -1; i++) {

			String key = (String)mapStopWords.keySet().toArray()[i];
			Integer val = (Integer)mapStopWords.values().toArray()[i];

//		System.out.println("key,val: " + key + "," + val);
		//System.out.println( key  );

	}

	System.out.println("\n\n Listado de StopWords encontradas: \n");

	Set<String> keySet = mapStopWords.keySet();
	Iterator<String> keySetIterator = keySet.iterator();


	int countSW =0;

	while (keySetIterator.hasNext()) {
		String key = keySetIterator.next();

		if(  mapTexto.containsKey(key)  ){

	   		System.out.println("k: " + key + "\t\t\t v: " + mapStopWords.get(key));	
	   		mapTexto.remove(key);
	   		++countSW;
		} 


	}
	System.out.println("\n Total de StopWords encontradas: "+ countSW);
	System.out.println("\n\n\n");

	int countSinSW = 0;


	System.out.println("\n\n Listado sin StopWords : \n");
	//COn esta iteración se quitan las stopwords
	for (int i=0; i < mapTexto.size() -1; i++) {
			String key = (String)mapTexto.keySet().toArray()[i];
			System.out.println("k :" + key );
			//System.out.println( key  );
			++countSinSW;
		}
	System.out.println("\n Total de palabras sin Stopwords encontradas: "+ countSinSW);
	System.out.println("\n\n\n");







}



	public static void main (String args[]){


	//args[0] = la opcion a elegir
	//args[1] = es el nombre o path del archivo	

	// Location of file to read
        File file = new File( args[1] );
 		String line =""; 
 
		ArrayList<String> list = new ArrayList<String>(); 		
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

            	//Hay que procesar la linea para poder quitar las stop words
                line = scanner.nextLine();
                //cleanTextSW( line );


            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
  

       // texto = line;



		String arrayAux[] = texto.split(" ");


		if( args[0].equals( "op2") ){

			cleanTextSW( line );
			String[] words=line.split(" ");


			HashMap<String,Integer> frequencies=new HashMap<String,Integer>();
			for (String w: Arrays.asList(words)){
			  Integer num=frequencies.get(w);
			  if (num!=null)
			    frequencies.put(w,num+1);
			  else
			    frequencies.put(w,1);
			}
	
			System.out.println("\n\n Listado total de frecuencia de palabras : \n");

			Set set = frequencies.entrySet(); 
			// Get an iterator 
			Iterator i = set.iterator(); 
			// Display elements from the hashmap

			int countTotalFrec = 0;
				while(i.hasNext()) { 
					Map.Entry me = (Map.Entry)i.next(); 

						if( (Integer)me.getValue() > 1){  //System.out.println("EO");

						System.out.print(me.getKey() + ": \t\t"+me.getValue() +"\n"); 
						
						++countTotalFrec;
						 }


				} 

			System.out.println("\n Cantidad de todas las palabras con frecuencia > 1: "+ countTotalFrec);
			System.out.println("\n\n\n");




			System.out.println("\n\n Listado de frecuencia de palabras sin StopWords: \n");

			Set set2 = frequencies.entrySet(); 
			// Get an iterator 
			Iterator i2 = set2.iterator(); 

			int countTotalFrecSinSW = 0;
				while(i2.hasNext()) { 
					Map.Entry me = (Map.Entry)i2.next(); 

						if( (Integer)me.getValue() > 1){  //System.out.println("EO");

							//System.out.print(me.getKey() + ": \t\t"+me.getValue() +"\n"); 

							if(  mapStopWords.containsKey(me.getKey()  )== false  ){
								++countTotalFrecSinSW;
								System.out.print(me.getKey() + ": \t\t"+me.getValue() +"\n"); 							}			
								
						 }


				} 
			System.out.println("\n Cantidad de todas las palabras con frecuencia > 1 sin StopWords: "+ countTotalFrecSinSW);
			System.out.println("\n\n\n");



		} // End if op2



		if( args[0].equals( "help") ){

				System.out.println( "WAZEEEE" );


		}



		if( args[0].equals( "op1") ){

		//	System.out.println(  "POS DAMN TAGGER" );
			int p =0;
			do{
			//	This iteration count all 36 tag and ocurrency
				System.out.println( " "+posTaggerTags[p]+" " +conteoPatron(texto, posTaggerTags[p]  ) );

				p++;
			}while( p < posTaggerTags.length );



		}


	//	System.out.println( "conteoPatron :::" + conteoPatron(texto, "_JJ" ) );

	}//End main method







}


