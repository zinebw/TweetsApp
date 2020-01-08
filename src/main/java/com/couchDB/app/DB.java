package com.couchDB.app;

import org.lightcouch.CouchDbClient;

public class DB {
    private static CouchDbClient dbClient = null;

    public DB() {
        dbClient = new CouchDbClient("tweets", true, "http", "127.0.0.1", 5984, "username", "pswd");
    }

    public static CouchDbClient getInstance() {
        if (dbClient == null) {
            new DB();
        }
        return dbClient;
    }
}
