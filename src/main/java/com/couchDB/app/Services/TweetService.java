package com.couchDB.app.Services;

import com.couchDB.app.Models.Tweet;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import java.util.List;


public class TweetService {

    CouchDbClient dbClient = null;

    public TweetService(CouchDbClient dbClient) {
        this.dbClient = dbClient;
    }

    public List<Tweet> getAllTweets() {
        List<Tweet> tweets = dbClient.view("_all_docs").includeDocs(true).query(Tweet.class);
        return tweets;
    }

    public Response addTweet(Tweet tweet) {
        Response response = dbClient.save(tweet);
        return response;
    }

    public Response updateTweet(Tweet tweet) {
        Response response = dbClient.update(tweet);
        return  response;
    }

    public Response deleteTweet(Tweet tweet) {
        return dbClient.remove(tweet);
    }

}
