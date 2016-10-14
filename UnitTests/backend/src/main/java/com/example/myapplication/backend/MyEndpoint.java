/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;


//import sun.net.www.http.HttpClient;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "trainingApi",
        version = "2016",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.example.com",
                ownerName = "backend.myapplication.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    public static final String STATS_URL = "https://dl.dropboxusercontent.com/u/20755008/response.json";

    @ApiMethod(name = "getStats")
    public MyBean getStats() {
        MyBean response = new MyBean();
        String data = new HttpClient().get(STATS_URL);
        response.setData(data);
        return response;
    }


}
