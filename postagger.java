import java.util.*; 
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap; 
import java.lang.Math;





public class postagger{

//this array it will change for a input data text FOR EXAMPLE
static String texto = 
" there_EX must_MD be_VB some_DT word_NN today_NN from_IN my_PRP$ boyfriend_NN so_RB far_RB away_RB  ._. gov_NN websites_NNS 03_CD audi_NNS s6_NN 1_CD cemetery_NN rd_NN derry_NN nh_NN 10_CD reasons_NNS soccer_NN is_VBZ better_JJR than_IN football_NN 11_CD cooper_NN avenue_NN unit_NN 107_CD long_JJ branch_NN 18_CD and_CC over_IN clubs_NNS ";

static HashMap<String,Integer> mapStopWords = new HashMap<String,Integer>();


//array with the suffix for work
static String[] posTaggerTags = 
{"_CC", "_CD", "_DT", "_EX", "_FW", "_IN", "_JJ", "_JJR", "_JJS", "_LS", "_MD", "_NN", "_NNS", "_NNP", "_NNPS", "_PDT", "_POS", "_PRP", "_PRP$", "_RB", "_RBR", "_RBS", "_RP", "_SYM", "_TO", "_UH", "_VB", "_VBD", "_VBG", "_VBN", "_VBP", "_VBZ", "_WDT", "_WP", "_WP$", "_WRB" };

static String stopwordsText[]=
{"a", "about", "above", "above", "across", "after", "afterwards", "again", "against", "all", "almost", "alone", "along", "already", "also","although","always","am","among", "amongst", "amoungst", "amount",  "an", "and", "another", "any","anyhow","anyone","anything","anyway", "anywhere", "are", "around", "as",  "at", "back","be","became", "because","become","becomes", "becoming", "been", "before", "beforehand", "behind", "being", "below", "beside", "besides", "between", "beyond", "bill", "both", "bottom","but", "by", "call", "can", "cannot", "cant", "co", "con", "could", "couldnt", "cry", "de", "describe", "detail", "do", "done", "down", "due", "during", "each", "eg", "eight", "either", "eleven","else", "elsewhere", "empty", "enough", "etc", "even", "ever", "every", "everyone", "everything", "everywhere", "except", "few", "fifteen", "fify", "fill", "find", "fire", "first", "five", "for", "former", "formerly", "forty", "found", "four", "from", "front", "full", "further", "get", "give", "go", "had", "has", "hasnt", "have", "he", "hence", "her", "here", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "him", "himself", "his", "how", "however", "hundred", "ie", "if", "in", "inc", "indeed", "interest", "into", "is", "it", "its", "itself", "keep", "last", "latter", "latterly", "least", "less", "ltd", "made", "many", "may", "me", "meanwhile", "might", "mill", "mine", "more", "moreover", "most", "mostly", "move", "much", "must", "my", "myself", "name", "namely", "neither", "never", "nevertheless", "next", "nine", "no", "nobody", "none", "noone", "nor", "not", "nothing", "now", "nowhere", "of", "off", "often", "on", "once", "one", "only", "onto", "or", "other", "others", "otherwise", "our", "ours", "ourselves", "out", "over", "own","part", "per", "perhaps", "please", "put", "rather", "re", "same", "see", "seem", "seemed", "seeming", "seems", "serious", "several", "she", "should", "show", "side", "since", "sincere", "six", "sixty", "so", "some", "somehow", "someone", "something", "sometime", "sometimes", "somewhere", "still", "such", "system", "take", "ten", "than", "that", "the", "their", "them", "themselves", "then", "thence", "there", "thereafter", "thereby", "therefore", "therein", "thereupon", "these", "they", "thickv", "thin", "third", "this", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "top", "toward", "towards", "twelve", "twenty", "two", "un", "under", "until", "up", "upon", "us", "very", "via", "was", "we", "well", "were", "what", "whatever", "when", "whence", "whenever", "where", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whoever", "whole", "whom", "whose", "why", "will", "with", "within", "without", "would", "yet", "you", "your", "yours", "yourself", "yourselves", "the"};











	public static void cleanTextSW ( String filepath){

		HashMap<String,Integer> mapTexto = new HashMap<String,Integer>();

		String arrayTexto[] = filepath.split(" ");

 	

		for ( int i=0; i< stopwordsText.length  ; i++){		mapStopWords.put( stopwordsText[i],1 );	}

		for( int j=0; j<arrayTexto.length;j++ ){			mapTexto.put(arrayTexto[j],0);			}

		for (int i=0; i < mapStopWords.size() -1; i++) {

			String key = (String)mapStopWords.keySet().toArray()[i];
			Integer val = (Integer)mapStopWords.values().toArray()[i];

		//System.out.println("key,val: " + key + "," + val);
		//System.out.println( key  );

		}

		//		System.out.println("\n(Line62) Listado de StopWords encontradas: \n");
		Set<String> keySet = mapStopWords.keySet();
		Iterator<String> keySetIterator = keySet.iterator();


		int countSW =0;
		while (keySetIterator.hasNext()) {

			String key = keySetIterator.next();
			if(  mapTexto.containsKey(key)  ){
		   		//System.out.println("k: " + key + "\t\t\t v: " + mapStopWords.get(key));	
		   		mapTexto.remove(key);
		   		++countSW;
			} 
		}
		//	System.out.println("\n(Line77) Total de StopWords encontradas: "+ countSW );



		//	System.out.println("\n(Line81)Listado sin StopWords :");
			//COn esta iteración se quitan las stopwords

			int countSinSW = 1;
			for (int i=0; i < mapTexto.size() -1; i++) {
					String key = (String)mapTexto.keySet().toArray()[i];
					//System.out.println("k :" + key );
					//System.out.println( key  );
					++countSinSW;
				}
		//	System.out.println("\n(Line91)Total de palabras sin Stopwords encontradas: "+ countSinSW);


	}//End of the method


	public static double elMenor(double a,double b,double c){
		double valor =0;

        if(a < b && a < c){  
			valor= a; 
        }else{  
            if(b < a && b < c){  
				valor= b;
			}else{  
				valor = c;
            }  
        }
        return valor;
	}


/*
*	args[0] = la opcion a elegir
*	args[1] = es el nombre o path del archivo	
*/



	public static void main (String args[]){



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
	
			//			System.out.println("(Line149) Listado total de frecuencia de palabras : \n");

			Set set = frequencies.entrySet(); 
			// Get an iterator 
			Iterator i = set.iterator(); 
			// Display elements from the hashmap
			int countTotalFrec = 0;
				while(i.hasNext()) { 
					Map.Entry me = (Map.Entry)i.next(); 
						if( (Integer)me.getValue() > 1){  //System.out.println("EO");
			//			System.out.print(me.getKey() + ": \t\t"+me.getValue() +"\n"); 						
						++countTotalFrec;
						 }


				} 

			//			System.out.println("(Line166)Cantidad de todas las palabras con frecuencia > 1: "+ countTotalFrec);



			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//			System.out.println("(Line172) Listado de frecuencia de palabras sin StopWords:");

			Set set2 = frequencies.entrySet(); 
			// Get an iterator 
			Iterator i2 = set2.iterator(); 

			int countTotalFrecSinSW = 0;
				while(i2.hasNext()) { 
					Map.Entry me = (Map.Entry)i2.next(); 

						if( (Integer)me.getValue() > 2){  //System.out.println("EO");

							//System.out.print(me.getKey() + ": \t\t"+me.getValue() +"\n"); 

							if(  mapStopWords.containsKey(me.getKey()  )== false  ){
								++countTotalFrecSinSW;
								//System.out.print("<"+me.getKey() + ","+me.getValue() +">\n"); 					
								//System.out.print(""+me.getKey() + ","+me.getValue() +"\n"); 	
								//System.out.print(""+me.getKey()  +" \n"); 									
							}		
						}
				} 
			//System.out.println("(Line193)Cantidad de todas las palabras con frecuencia > 1 sin StopWords: "+ countTotalFrecSinSW);




			Set set3 = frequencies.entrySet(); 
			// Get an iterator 
			Iterator i3 = set3.iterator(); 

			int countTotalFrecSinSWnolimit = 0;
			//System.out.print("{");
				while(i3.hasNext()) { 
					Map.Entry me = (Map.Entry)i3.next(); 

				
							if(  mapStopWords.containsKey(me.getKey()  )== false  ){
								++countTotalFrecSinSWnolimit;
								//Para converitr a vector
								//System.out.print("<"+me.getKey() + ", "+me.getValue() +">;\n");
								//System.out.print(me.getKey() +" ");  		
							}			
				}
			//System.out.print("}");	 
			//System.out.println("(Line217)Cantidad total de palabras, con frecuencia y sin StopWords: "+ countTotalFrecSinSWnolimit);
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		} // End if op2





		//En op3 dada un entrada perfecta se entrega un output en formato de CENTROIDE
		//LA entrada ya debe estar procesada sin SW

		if( args[0].equals("centroide") ){


	        File archivo 					= new File( args[1] );
	 		String linea 					= ""; 
			int totalejemplos		 		= 0;
			ArrayList<String> listAux		= new ArrayList<String>(); 		
	        
	        try {
	            Scanner scanner 						= new Scanner(archivo);
				HashMap<String,Integer> frecuencia 		= new HashMap<String,Integer>();
	            while (scanner.hasNextLine()) {

	                linea = scanner.nextLine();
	                String[] words2=linea.split(" ");

						for (String w: Arrays.asList(words2)){
						  Integer num=frecuencia.get(w);
						  if (num!=null)
						    frecuencia.put(w,num+1);
						  else
						    frecuencia.put(w,1);
						}

					Set set4 						= frecuencia.entrySet(); 
					Iterator i4 					= set4.iterator(); 	

					System.out.print("{");
					while(i4.hasNext()) { 
						Map.Entry me = (Map.Entry)i4.next(); 
									//++validadorCountlineas;
									//System.out.print("<"+me.getKey() + ", "+me.getValue() +">;");
								
								if(  mapStopWords.containsKey(me.getKey()  )== false  ){
									++totalejemplos;
									System.out.print("<"+me.getKey() + ", "+me.getValue() +">;");
								}
					}
					//frecuencia.clear(); lo comentamos porque debo acordarme de 
				System.out.print("\t} \t 1/"+totalejemplos+" \n" );	 
				//System.out.println("(Line217)Cantidad total de palabras, con frecuencia y sin StopWords: "+ countTotalFrecSinSWnolimit);

	            } 
	            System.out.println();

	            scanner.close();
	        } catch (FileNotFoundException e) {	 e.printStackTrace();	}
		}// End if centroide



		/*
		La entrada es el listado total de palabras

		Un ejemplo de llamado sería: java postagger manhattan List_NAV_line_sinSW.txt input.txt 
		*/
		if( args[0].equals("manhattan") ){

	        File queryfiles					= new File( args[1] ); // input
	        File archivo 					= new File( "List_NAV_line_sinSW.txt" ); // NAV
	        File filesRES					= new File( "List_RES_line_sinSW_v2.txt" );			 //RES
	        File filesINF					= new File( "List_INF_line_sinSW.txt" ); // IN

	 		String linea 					= ""; 
	 		String lineaRes					= ""; 
	 		String lineainf					= ""; 
	 		String lineaDeQuerys			= "";

			int totalejemplos		 		= 0;
			int totalNav					= 0;
			int totalInf					= 0;
			int totalRes 					= 0;
			double distManhattan			= 0;
			double distManhattanNav			= 0;
			double distManhattanInf			= 0;
			double distManhattanRes			= 10000;
	        
	        try {
	            Scanner scanner 						= new Scanner(archivo);
	            Scanner scannerQuerys					= new Scanner(queryfiles);
	            Scanner scannerRes						= new Scanner(archivo);
				Scanner scannerInf						= new Scanner(filesINF);


	            HashMap<String,Integer> frecuencia 		= new HashMap<String,Integer>(); // funciona como auxiliar


				HashMap<String,String> querysmap 		= new HashMap<String,String>();
				HashMap<String,Integer> centroideNav 	= new HashMap<String,Integer>();
				HashMap<String,Integer> centroideInf 		= new HashMap<String,Integer>();
				HashMap<String,Integer> centroideRes		= new HashMap<String,Integer>();


	            while(scanner.hasNextLine()) {
	                linea 								= scanner.nextLine();
	                String[] words2						= linea.split(" ");

					for (String w: Arrays.asList(words2)){
						  Integer num=frecuencia.get(w);
						  if (num!=null)
						    centroideNav.put(w,num+1);
						  else
						    centroideNav.put(w,1);
					}
					Set set4 							= centroideNav.entrySet(); 
					Iterator i4 						= set4.iterator(); 	
					while(i4.hasNext()) { 
						Map.Entry me = (Map.Entry)i4.next(); 
									//++validadorCountlineas;
									//System.out.print("<"+me.getKey() + ", "+me.getValue() +">;");
								
								if(  mapStopWords.containsKey(me.getKey()  )== false  ){
									++totalejemplos;
									++totalNav;
									//System.out.print("<"+me.getKey() + ", "+me.getValue() +">;");
								}
					}
				//frecuencia.clear();// lo comentamos porque debo acordarme de 
				//System.out.print("\t} \t 1/"+totalejemplos+" \n" );	 
	            }//while

	            while(     scannerInf.hasNextLine()      ) {
	                
					lineainf 					= scannerInf.nextLine();
	                String[] words2							= lineainf.split(" ");

						for (String w: Arrays.asList(words2)){
							  Integer num=centroideInf.get(w);
							  if (num!=null)
							    centroideInf.put(w,num+1);
							  else
							    centroideInf.put(w,1);
						}

					Set set4 							= centroideInf.entrySet(); 
					Iterator i4 						= set4.iterator(); 	
						while(i4.hasNext()) { 
							Map.Entry me = (Map.Entry)i4.next(); 
									
									if(  mapStopWords.containsKey(me.getKey()  )== false  ){ // si no es un stopword sumo una frecuencia
										++totalejemplos;
										++totalInf;
										//System.out.print("<"+me.getKey() + ", "+me.getValue() +">;");
									}
						}					
	            }//while

/*
	            while(     scannerRes.hasNextLine()      ) {
	                
					lineainf 								= scannerRes.nextLine();
	                String[] words2							= lineainf.split(" ");

						for (String w: Arrays.asList(words2)){
							  Integer num=frecuencia.get(w);
							  if (num!=null)
							    frecuencia.put(w,num+1);
							  else
							    frecuencia.put(w,1);
						}

					Set set4 							= frecuencia.entrySet(); 
					Iterator i4 						= set4.iterator(); 	
						while(i4.hasNext()) { 
							Map.Entry me = (Map.Entry)i4.next(); 
									
									if(  mapStopWords.containsKey(me.getKey()  )== false  ){ // si no es un stopword sumo una frecuencia
										++totalejemplos;
										++totalInf;
										//System.out.print("<"+me.getKey() + ", "+me.getValue() +">;");
									}
						}					
	            }//while

*/








				//primer intento de calculo de manhattan
					System.out.println( " totalejemplos "+totalejemplos );
					System.out.println( " total INF "+totalInf );
					System.out.println( " total NAV "+totalNav );
				 	System.out.println( " total RES " );


				while(  scannerQuerys.hasNextLine()  ){

					lineaDeQuerys 					= scannerQuerys.nextLine();
					String []querys 				= lineaDeQuerys.split(" ");

					double frec  					= 0;					
					double cociente					= 0;	

					for(int i=0; i< querys.length-1; i++){ 


						if( centroideNav.containsKey( querys[i] ) ){

							frec   	= (double)centroideNav.get( querys[i] );
							cociente = frec  /(double)totalNav;
							//System.out.println( querys[i]+ "  "+frec );	


							//querysmap.put( querys[i],1 );

							distManhattanNav = distManhattanNav + Math.abs(  cociente - 1           );							

						}else{	distManhattanNav = distManhattanNav + Math.abs(  cociente );	}
					
						if( centroideInf.containsKey( querys[i] ) ){
							

							frec   	= (double)centroideInf.get( querys[i] );
							cociente = frec  /(double)totalInf;
							//System.out.println( querys[i]+ "  "+frec );	
							//querysmap.put( querys[i],1 );
							distManhattanInf = distManhattanInf + Math.abs(  cociente - 1           );

						}else{	distManhattanInf = distManhattanInf + Math.abs(  cociente );	}




						double a = distManhattanNav;
						double b = distManhattanInf;
						double c = distManhattanRes;


						System.out.println(  "El menor es :" +elMenor(a,b,c) );


					}//end for
				} System.out.println();
				System.out.println( " distance distManhattanInf "+ distManhattanInf );
				System.out.println( " distance distManhattanNav "+ distManhattanNav );
				System.out.println( " distance distManhattanNav "+ distManhattanRes );


	            scanner.close();
	        } catch (FileNotFoundException e) {	 e.printStackTrace();	}
		
		/*
	        try {
	            Scanner scanner 						= new Scanner(archivo);
	            Scanner scannerQuerys					= new Scanner(queryfiles);
				HashMap<String,Integer> frecuencia 		= new HashMap<String,Integer>();
				HashMap<String,Integer> querysmap 		= new HashMap<String,Integer>();


	            while (scanner.hasNextLine()) {

	                linea2 								= scanner.nextLine();
	                String[] words2						= linea2.split(" ");

					for (String w: Arrays.asList(words2)){
						  Integer num=frecuencia.get(w);
						  if (num!=null)
						    frecuencia.put(w,num+1);
						  else
						    frecuencia.put(w,1);
					}

					Set set4 							= frecuencia.entrySet(); 
					Iterator i4 						= set4.iterator(); 	

					//System.out.print("{");
					while(i4.hasNext()) { 
						Map.Entry me = (Map.Entry)i4.next(); 
									//++validadorCountlineas;
									//System.out.print("<"+me.getKey() + ", "+me.getValue() +">;");
								
								if(  mapStopWords.containsKey(me.getKey()  )== false  ){
									++totalejemplos;
									//System.out.print("<"+me.getKey() + ", "+me.getValue() +">;");
								}
					}
					//frecuencia.clear(); lo comentamos porque debo acordarme de 
				//System.out.print("\t} \t 1/"+totalejemplos+" \n" );	 
			
	            }

				double distManhattan=0;

				while(  scannerQuerys.hasNextLine()  ){

					lineaDeQuerys 					= scannerQuerys.nextLine();
					String []querys 				= lineaDeQuerys.split(" ");

					
					//DEBUG VALUES

					//System.out.println( " totalejemplos "+totalejemplos );

					for(int i=0; i< querys.length; i++){ 
						System.out.println( querys[i] );

						double cociente = 1/ (double)totalejemplos;
						double frec 	= (double)frecuencia.get( querys[i] );
						
						if( frecuencia.containsKey( querys[i] ) ){
							querysmap.put( querys[i],1 );
							//System.out.println( querys[i] ); (Integer)frecuencia.get( querys[i] )

							distManhattan = distManhattan + Math.abs(  cociente*frec - 1           );

						}else{
							distManhattan = distManhattan + Math.abs(  cociente*frec - 0          );
						}
					}System.out.println( " distManhattan "+ distManhattan );

				} System.out.println();

	            scanner.close();
	        } catch (FileNotFoundException e) {	 e.printStackTrace();	}
		
*/

		}// End if manhattan




















		//COPIA DE OP3 para backups
		//En op3 dada un entrada perfecta se entrega un output en formato de centroid
		//Este 

		if( args[0].equals("op4") ){


	        File archivo 					= new File( args[1] );
	 		String linea 					= ""; 
			int validadorCountlineas 		= 0;
			ArrayList<String> listAux		= new ArrayList<String>(); 		
	        

	        try {
	            Scanner scanner 						= new Scanner(archivo);
				HashMap<String,Integer> frecuencia 		= new HashMap<String,Integer>();
	            while (scanner.hasNextLine()) {

	                linea = scanner.nextLine();
	                String[] words2=linea.split(" ");

						for (String w: Arrays.asList(words2)){
						  Integer num=frecuencia.get(w);
						  if (num!=null)
						    frecuencia.put(w,num+1);
						  else
						    frecuencia.put(w,1);
						}

					Set set4 						= frecuencia.entrySet(); 
					Iterator i4 					= set4.iterator(); 	

					System.out.print("{");
					while(i4.hasNext()) { 
						Map.Entry me = (Map.Entry)i4.next(); 
									//++validadorCountlineas;
									//System.out.print("<"+me.getKey() + ", "+me.getValue() +">;");
								
								if(  mapStopWords.containsKey(me.getKey()  )== false  ){
									//++validadorCountlineas;
									System.out.print("<"+me.getKey() + ", "+me.getValue() +">;");
								}
					}
					frecuencia.clear();
				System.out.print("\t}\n" );	 
				//System.out.println("(Line217)Cantidad total de palabras, con frecuencia y sin StopWords: "+ countTotalFrecSinSWnolimit);

	            } 
	            System.out.println();

	            scanner.close();
	        } catch (FileNotFoundException e) {	 e.printStackTrace();	}
	  




		}// End inf op3 



























		if( args[0].equals( "help") ){

				System.out.println( "WAZEEEE" );


		}



		if( args[0].equals( "op1") ){

		//	System.out.println(  "POS DAMN TAGGER" );
			int p =0;
			do{
			//	This iteration count all 36 tag and ocurrency
				System.out.println( " "+posTaggerTags[p]+" " +conteoPatron(line, posTaggerTags[p]  ) );

				p++;
			}while( p < posTaggerTags.length );



		}


	//	System.out.println( "conteoPatron :::" + conteoPatron(texto, "_JJ" ) );

	}//End main method


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




}


