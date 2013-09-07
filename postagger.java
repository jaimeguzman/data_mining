import java.util.*; 
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
*
* Por hacer pantalla de estadisticas
* http://www.ling.upenn.edu/courses/Fall_2003/ling001/penn_treebank_pos.html
*/


public class postagger{

//this array it will change for a input data text
static String texto = " there_EX must_MD be_VB some_DT word_NN today_NN from_IN my_PRP$ boyfriend_NN so_RB far_RB away_RB  ._. gov_NN websites_NNS 03_CD audi_NNS s6_NN 1_CD cemetery_NN rd_NN derry_NN nh_NN 10_CD reasons_NNS soccer_NN is_VBZ better_JJR than_IN football_NN 11_CD cooper_NN avenue_NN unit_NN 107_CD long_JJ branch_NN 18_CD and_CC over_IN clubs_NNS ";


//array with the suffix for work

static String[] posTaggerTags = {"_CC", "_CD", "_DT", "_EX", "_FW", "_IN", "_JJ", "_JJR", "_JJS", "_LS", "_MD", "_NN", "_NNS", "_NNP", "_NNPS", "_PDT", "_POS", "_PRP", "_PRP$", "_RB", "_RBR", "_RBS", "_RP", "_SYM", "_TO", "_UH", "_VB", "_VBD", "_VBG", "_VBN", "_VBP", "_VBZ", "_WDT", "_WP", "_WP$", "_WRB" };





public static void frecuencia( String data){

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

						if( (Integer)me.getValue() > 10000){  //System.out.println("EO");

							System.out.print(me.getKey() + ": "); 
							System.out.println(me.getValue() ); 

						 }

							System.out.print("< "+ me.getKey() + ": "+me.getValue()+" > \n"); 
				


				} 
			System.out.println(); 




}


	public static void main (String args[]){



	  // Location of file to read
        File file = new File( "RES_List.txt" );
 		String line =""; 
 		String granLine =""; 

		ArrayList<String> list = new ArrayList<String>(); 		
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {


            	//Hay que procesar la linea para poder quitar las stop words

                 line = scanner.nextLine();
                list.add( line );	

		       frecuencia( line );	
                //System.out.print( line );
              
            }
            //granLine =   line +granLine;

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
         




  // Location of file to read
		/*
        File file = new File("INF_lineALL.txt");
 		String line ="";
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                 line = scanner.nextLine();
                //System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

*/

       // texto = line;



		String arrayAux[] = texto.split(" ");


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


		if( args[0].equals( "op2") ){


			String[] words=texto.split(" ");
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

						if( (Integer)me.getValue() > 1){  //System.out.println("EO");

							System.out.print(me.getKey() + ": "); 
							System.out.println(me.getValue() ); 

						 }


				} 
			System.out.println(); 



		} // End if op2











//		System.out.println(  texto ) ;
/*
		for (int i =0; i<arrayAux.length; i++  ){
			//System.out.println( arrayAux[i] );
			String stringIterado = arrayAux[i];
			if( stringIterado.endsWith( "_JJ" )  == true ){ 
			//System.out.println( "EXITO" );
			//System.out.println( arrayAux[i] );
		}
		
		}*/


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




}


