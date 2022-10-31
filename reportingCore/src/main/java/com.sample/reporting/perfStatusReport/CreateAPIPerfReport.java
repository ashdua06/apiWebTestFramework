package com.sample.reporting.perfStatusReport;

import com.sample.constants.EnvConstants;
import com.sample.constants.TestNGParams;
import com.sample.reporting.dataObjects.APIStatusTimeDTO;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class CreateAPIPerfReport {

    public static String APIPerfReportPath;
    private static Boolean apiPerfReport = false;


    public static void setApiPerfReport(Boolean apiPerfReport) {
        CreateAPIPerfReport.apiPerfReport = apiPerfReport;
    }

    public static Boolean getApiPerfReport() {
        return apiPerfReport;
    }

    public static String getAPIPerfReportPath() {
        return APIPerfReportPath;
    }

    public static void createHTMLReport(String apiPerfReportFileName, String apiPerfReportTitle) {
        File destFolderPath = new File(EnvConstants.REPORT_BASE_PATH + "APIPerf");
        try {
            if (destFolderPath.mkdir()) {
            } else {
                FileUtils.forceDelete(destFolderPath);
                destFolderPath.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = null;
        try {
            file = new File(destFolderPath, apiPerfReportFileName);
            file.createNewFile();
            APIPerfReportPath = file.getAbsolutePath();
            FileOutputStream consolidateHtmlFile = new FileOutputStream(file, true);
            PrintStream PrintHtml = new PrintStream(consolidateHtmlFile);
            PrintHtml.println("<html>");
            PrintHtml.println("<head>");
            PrintHtml.println("<title>" + apiPerfReportTitle + "</title>");
            PrintHtml.println("</head>");
            PrintHtml.println("<body>");
            PrintHtml.println("<style>th {color:black;background-color:#abe;} td {background-color: #FAFAD2;}</style>");

            PrintHtml.println("<h1 style = 'color:black; font-size:150%; text-align:center;'> <u>" + apiPerfReportTitle + " </h1></u>");
            for (String key : TestNGParams.systemInfo.keySet()) {
                PrintHtml.println("<h3 style = 'color:black; font-size:120%; text-align:left;'> " + key + " :- "
                        + TestNGParams.systemInfo.get(key) + "</h3>");
            }
            PrintHtml.println("<br><table border=\"0.5\" style='width:100%;'>");
            PrintHtml.println(
                    "<tr><th colspan=\"6\" style='color:black; background-color: #000000; color:#FFFFFF'>MicroService Based Summary</th></tr>");
            PrintHtml.println(
                    "<tr align='center'><th>API Base Path </th><th>Total Number of Hits </th><th>Average Response Time </th><th>Max Response Time</th><th>Minimum Response Time</th>" +
                            "</tr>");
            for (String apiBasePath : EnvConstants.API_STATUS_TIME_DTOMAP.keySet()) {
                Long totalHits = EnvConstants.API_STATUS_TIME_DTOMAP.get(apiBasePath).getTotalHits();
                Long averageResponseTime = EnvConstants.API_STATUS_TIME_DTOMAP.get(apiBasePath).getAverageResponseTime();
                Long maxTime = EnvConstants.API_STATUS_TIME_DTOMAP.get(apiBasePath).getMaxTime();
                Long minTime = EnvConstants.API_STATUS_TIME_DTOMAP.get(apiBasePath).getMinTime();
                PrintHtml.println("<tr align='center'><td><b>" + apiBasePath
                        + "</td><td><b>" + totalHits
                        + "</td><td><b>" + averageResponseTime
                        + "</td><td><b>" + maxTime
                        + "</td><td><b>" + minTime
                        + "</td></tr>");
            }
            PrintHtml.println("</table>");
            PrintHtml.println("<br>");
            PrintHtml.println("</body>");
            PrintHtml.println("</html>");
            PrintHtml.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void captureAPIStatusTimeDTO(String basePath, Long timeInMilliSeconds) {
        if (EnvConstants.API_STATUS_TIME_DTOMAP.containsKey(basePath)) {
            APIStatusTimeDTO apiStatusTimeDTO = EnvConstants.API_STATUS_TIME_DTOMAP.get(basePath);
            apiStatusTimeDTO.setResponseTime(timeInMilliSeconds);
        } else {
            APIStatusTimeDTO apiStatusTimeDTO = new APIStatusTimeDTO(basePath);
            apiStatusTimeDTO.setResponseTime(timeInMilliSeconds);
            EnvConstants.API_STATUS_TIME_DTOMAP.put(basePath, apiStatusTimeDTO);
        }

    }


}
