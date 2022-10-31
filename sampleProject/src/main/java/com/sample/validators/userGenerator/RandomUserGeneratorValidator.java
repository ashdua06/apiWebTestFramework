package com.sample.validators.userGenerator;

import com.sample.apiRequestBuilder.userGenerator.RandomUserGenerator;
import com.sample.exceptions.UserGeneratorException;
import com.sample.reporting.assertions.CustomAssert;

public class RandomUserGeneratorValidator {
    private static volatile RandomUserGeneratorValidator instance;

    private RandomUserGeneratorValidator() {
    }

    public static RandomUserGeneratorValidator getInstance() {
        if (instance == null) {
            synchronized (RandomUserGeneratorValidator.class) {
                if (instance == null) {
                    instance = new RandomUserGeneratorValidator();
                }
            }
        }
        return instance;
    }

    public void validateRandomUserGenerator(RandomUserGenerator obj) {
        try {
            CustomAssert.assertEquals(obj.getApiResponse().getStatusCode(), 200, " HTTP Status code validation");
        } catch (Exception e) {
            throw new UserGeneratorException("Error in validating random user generator api response ", e);
        }
    }

}
