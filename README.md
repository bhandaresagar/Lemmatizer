# Lemmatizer
REST based web service and UI to provide lemma and part of speech of given text

#How to use
Build using maven and deploy the war
Call either post or get method as below 

GET : http://localhost:8080/lemmizer/getlemma/<text>
POST: http://localhost:8080/lemmizer/getlemma
post text as data

Response: [word : part of speech : lemma] ... 