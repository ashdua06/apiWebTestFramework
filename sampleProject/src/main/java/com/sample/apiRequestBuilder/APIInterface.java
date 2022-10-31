package com.sample.apiRequestBuilder;
import io.restassured.response.Response;
public interface APIInterface {

    RequestPojo getRequestPojo();

    ResponsePojo getResponsePojo();

    Response getApiResponse();
    void createRequestJsonAndExecute();

    interface ResponsePojo{
        int getCode();
        String getType();
        String getMessage();
    }



    interface RequestPojo{
    }

}