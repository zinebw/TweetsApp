package com.couchDB.app.Controller;

import com.couchDB.app.Models.Tweet;
import com.couchDB.app.Response.ResponseType;
import com.couchDB.app.Services.TweetService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

import static spark.Spark.*;
import static spark.Spark.delete;

public class TweetController {



    public TweetController(final TweetService service) {

        //Get All Tweet
        get("/tweets", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                try {
                    List<Tweet> tweets = service.getAllTweets();
                    return new AppResponse<List<Tweet>>(ResponseType.success, tweets);
                } catch (Exception e) {
                    return new AppResponse<Exception>(ResponseType.failure, e);
                }
            }
        }, new JsonTransformer());

        // Add New Tweet
        post("/tweets", new Route() {
            public Object handle(Request request, Response response) throws Exception {

                try {
                    Gson gson = new GsonBuilder().create();
                    Tweet tweet = gson.fromJson(request.body() , Tweet.class);

                    org.lightcouch.Response couchResponse = service.addTweet(tweet);
                    if (couchResponse.getError() == null) {
                        return new AppResponse<org.lightcouch.Response>(ResponseType.success, couchResponse);
                    } else {
                        return new AppResponse<String>(ResponseType.failure, couchResponse.getReason());
                    }

                } catch (Exception e) {
                    return new AppResponse<Exception>(ResponseType.failure, e);
                }
            }
        }, new JsonTransformer());

        put("/tweets/:id", new Route() {

            public Object handle(Request request, Response response) throws Exception {
                try {
                    Gson gson = new GsonBuilder().create();
                    Tweet tweet = gson.fromJson(request.body() , Tweet.class);
                    tweet.set_id(request.params("id"));

                    org.lightcouch.Response couchResponse = service.updateTweet(tweet);

                    if (couchResponse.getError() == null) {
                        return new AppResponse<org.lightcouch.Response>(ResponseType.success, couchResponse);
                    } else {
                        return new AppResponse<String>(ResponseType.failure, couchResponse.getReason());
                    }

                } catch (Exception e) {
                    return new AppResponse<Exception>(ResponseType.failure, e);
                }
            }

        }, new JsonTransformer());

        delete("/tweets/:id", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                Gson gson = new GsonBuilder().create();
                Tweet tweet = gson.fromJson(request.body() , Tweet.class);
                tweet.set_id(request.params("id"));

                org.lightcouch.Response couchResponse = service.deleteTweet(tweet);

                try{
                    if (couchResponse.getError() == null) {
                        return new AppResponse<org.lightcouch.Response>(ResponseType.success, couchResponse);
                    } else {
                        return new AppResponse<String>(ResponseType.failure, couchResponse.getReason());
                    }
                } catch (Exception e) {
                    return new AppResponse<Exception>(ResponseType.failure, e);
                }

            }
        }, new JsonTransformer());
    }
}

