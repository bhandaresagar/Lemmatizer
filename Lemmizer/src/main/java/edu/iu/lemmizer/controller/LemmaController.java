package edu.iu.lemmizer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.iu.lemmizer.response.SimpleResponse;
import edu.iu.lemmizer.service.LemmaService;

@Controller
public class LemmaController
{
	final static Logger logger = Logger.getLogger(LemmaController.class);

	@Autowired
	LemmaService lemmaService;

	@RequestMapping(value = "/getlemma", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SimpleResponse getLemma(@RequestBody String text)
	{
		try
		{
			StringBuilder builder = new StringBuilder();
			for (String lemma : lemmaService.getLemma(text))
			{
				builder.append(lemma + " ");
			}
			return new SimpleResponse(true, builder.toString());
		} catch (Exception e)
		{
			return new SimpleResponse(false, e.getMessage());
		}
	}

	@RequestMapping(value = "/getlemma/{word}", method = RequestMethod.GET)
	public @ResponseBody SimpleResponse getLemmaForWord(@PathVariable String word)
	{
		try
		{
			StringBuilder builder = new StringBuilder();
			for (String lemma : lemmaService.getLemma(word))
			{
				builder.append(lemma + " ");
			}
			return new SimpleResponse(true, builder.toString());
		} catch (Exception e)
		{
			return new SimpleResponse(false, e.getMessage());
		}
	}

}
