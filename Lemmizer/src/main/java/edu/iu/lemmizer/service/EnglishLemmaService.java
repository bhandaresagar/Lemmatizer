package edu.iu.lemmizer.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.iu.lemmizer.exceptions.LemmaException;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

@Service("lemmaService")
public class EnglishLemmaService implements LemmaService
{
	@Autowired
	StanfordCoreNLP stanfordCoreNLP;

	@Override
	public List<String> getLemma(String text)
	{
		try
		{
			List<String> result = new LinkedList<String>();
			Annotation annotation = new Annotation(text.toString());
			stanfordCoreNLP.annotate(annotation);

			List<CoreMap> sentences = annotation.get(SentencesAnnotation.class);
			for (CoreMap sentence : sentences)
			{
				for (CoreLabel token : sentence.get(TokensAnnotation.class))
				{
					// this is the text of the token
					String word = token.get(TextAnnotation.class);
					String pos = token.get(PartOfSpeechAnnotation.class);
					String lemma = token.get(LemmaAnnotation.class);
					String tk = "[ " + word + " : " + pos + " : " + lemma + " ]";
					result.add(tk);
				}
			}

			return result;
		} catch (Exception e)
		{
			throw new LemmaException();
		}
	}

}
