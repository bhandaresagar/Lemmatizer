package edu.iu.lemmizer.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

@Configuration
public class ConfigLoader
{
	@Bean
	public StanfordCoreNLP getStanfordCoreNLP()
	{
		Properties properties = new Properties();
		properties.put("annotators", "tokenize, ssplit, pos, lemma");
		StanfordCoreNLP stanfordCoreNLP = new StanfordCoreNLP(properties);
		return stanfordCoreNLP;
	}
}
