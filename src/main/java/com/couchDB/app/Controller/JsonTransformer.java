package com.couchDB.app.Controller;

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    public String render(Object o) throws Exception {
        return new Gson().toJson(o);
    }
}