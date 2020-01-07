package com.couchDB.app;


import com.couchDB.app.Controller.TweetController;
import com.couchDB.app.Services.TweetService;
import org.lightcouch.CouchDbClient;
import spark.Filter;
import spark.Request;
import spark.Response;

import static spark.Spark.*;


public class SparkMiddleware {

    public static void Setup() {

        // Listen Port
        port(9090);

        //  s'exécute avant request handled
        before(new Filter() {
            public void handle(Request request, Response response) throws Exception {
                System.out.println("Middleware - BEFORE");
            }
        });

        //  s'exécute après request handled et avant l'envoi au Client
        after(new Filter() {
            public void handle(Request request, Response response) throws Exception {
                response.type("application/json");
                System.out.println("Middleware - AFTER");
            }
        });
    }

    public static void SetupRoutes() {

        CouchDbClient dbClient = DB.getInstance();

        new TweetController(new TweetService(dbClient));

    }
}
