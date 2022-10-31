package com.sample.apiRequestBuilder.userGenerator;

import com.sample.api.constants.ContentType;
import com.sample.api.constants.MethodType;
import com.sample.api.core.BaseApi;
import com.sample.api.utils.jsonProcessor.JacksonJsonImpl;
import com.sample.apiRequestBuilder.APIInterface;
import com.sample.constants.APIEndpoints;
import com.sample.constants.LocalConfig;
import com.sample.exceptions.UserGeneratorException;
import com.sample.model.request.UserGeneratorRequestPojo;
import com.sample.model.response.UserGeneratorResponsePojo;
import io.restassured.response.Response;

public class RandomUserGenerator extends BaseApi implements APIInterface {
    private Response response;
    private UserGeneratorResponsePojo userGeneratorResponsePojo;
    private UserGeneratorRequestPojo userGeneratorRequestPojo;

    public RandomUserGenerator(){
        setMethod(MethodType.GET);
        setContentType(ContentType.JSON);
        setBaseUri(LocalConfig.USER_GENERATOR_URL);
        setBasePath(APIEndpoints.USER_GENERATOR.CREATE_RANDOM_USERS);
        addQueryParam("nat","US");
    }
    @Override
    public UserGeneratorRequestPojo getRequestPojo() {
        return this.userGeneratorRequestPojo;
    }

    @Override
    public UserGeneratorResponsePojo getResponsePojo() {
        return this.userGeneratorResponsePojo;
    }

    @Override
    public Response getApiResponse() {
        return response;
    }

    @Override
    public void createRequestJsonAndExecute() {
        try{
            response=execute();
            this.userGeneratorResponsePojo= JacksonJsonImpl.getInstance().fromJson(response.asString(),UserGeneratorResponsePojo.class);
        }
        catch (Exception e){
            throw new UserGeneratorException("Error in user generator api ",e);
        }
    }
}
