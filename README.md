
------ ------   TweetsApp  ------  ------

This is a CRUD application using java and couchDB to manipulate Tweets.
The operations supported by the application are the:
- insertion
- update
- display 
- deletion.

These operations are applied on a document (a Tweet) and carried out using command lines that are typed on the terminal using curl :

>>  ------ To Get All Tweets  ------

curl -X GET -H "http://localhost:9090/tweets"


>>  ------ To Display a Tweet by id  ------

curl -X GET "http://127.0.0.1:5984/tweets/bdcdc626bc374bb0851e3c6daa403652"

	
>>    ------ To Delete a Tweet by Id  ------

curl -X DELETE -H "Content-Type: application/json" -d '{
    "_rev" : "1-8bf53838836664cbff131b07ad2c407d"
}' "http://localhost:9090/tweets/e69cf3b1520a443e9deda3eade476a2a"


>>   ------ To Add a new Tweet  ------

curl -X POST -H "Content-Type: application/json" -d '{
     "Utilisateur" : "Hajar",
     "Contenu" : "Australia is burning",
     "Hashtag" : " #fire"
 }' "http://localhost:9090/tweets"


 >>   ------ To Update a Tweet by Id   ------

curl -H 'Content-Type: application/json' \  -X PUT http://127.0.0.1:5984/tweets/bdcdc626bc374bb0851e3c6daa403652/ -d'{"Utilisateur": "Zainab", "Contenu" : " updated hello Australia", "_rev":"1-645692c7fbe392958a28708a48336de3"}' 






