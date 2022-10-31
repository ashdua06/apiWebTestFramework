package com.sample.constants;

import com.sample.reporting.dataObjects.APIStatusTimeDTO;

import java.util.HashMap;
import java.util.Map;

public class EnvConstants {
    public static final long DEFAULT_IMPLICIT_TIMEOUT=15;
    public static final long DEFAULT_EXPLICIT_TIMEOUT=30;
    public static final String CSV_TESTDATA_BASE_PATH="./TestData/";
    public static final String TextComparisionFilePath="./TestData/TextComparisionFiles/TextComparision.csv";
    public static String Default_Viewport="Dotcom";
    public static String Default_environment="qa";
    public static String Default_platform="windows";
    public static String Default_Brand="Sample";
    public static String Default_domain="US";
    public static String Default_language="EN";
    public static String Default_incognito="false";
    public static String Default_browser="chrome";
    public static String Default_UILiteFlag="false";
    public static String REPORT_BASE_PATH="./Reports/";
    public static boolean FLAG_REMOVE_RETRIEDTESTS=true;
    public static boolean FLAG_UPDATE_SCREENSHOTS=true;
    public static String FILE_NAME_REPORT="Sample.html";
    public static String REPORT_TITLE="Sample Automation";
    public static Map<String, APIStatusTimeDTO> API_STATUS_TIME_DTOMAP = new HashMap<>();
}
