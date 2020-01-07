package com.couchDB.app;

import java.util.Date;


public class App {

    public static void main(String[] args) {
        System.out.println("App Started at : " + new Date());

        // Configuration du Middleware  Spark
        SparkMiddleware.Setup();

        // Config HTTP Routes.
        SparkMiddleware.SetupRoutes();

    }
}
