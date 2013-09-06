
import edu.stanford.*;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class testPostagger {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		
		  if (args.length != 2) {
		      System.err.println("usage: java TaggerDemo modelFile fileToTag");
		      return;
		    }
		    MaxentTagger tagger = new MaxentTagger(args[0] );
		    List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new FileReader(args[1])));
		    for (List<HasWord> sentence : sentences) {
		    ArrayList<TaggedWord> tSentence = tagger.tagSentence(sentence);
		    System.out.println(Sentence.listToString(tSentence, false));

		    
		    }
		  
		
	}

}
