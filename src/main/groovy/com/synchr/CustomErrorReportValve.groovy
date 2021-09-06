package com.synchr

import org.apache.catalina.connector.Request
import org.apache.catalina.connector.Response
import org.apache.catalina.valves.ErrorReportValve

import java.util.logging.Logger

class CustomErrorReportValve extends ErrorReportValve {

    final String CUSTOM_ERROR_PAGE_PATH = "templates/error.html"
    final Logger log = Logger.getLogger(CustomErrorReportValve.class.getName());

    @Override
    protected void report(Request request, Response response, Throwable t) {
        try {
            final InputStream inputStream = CustomErrorReportValve.class.getClassLoader().getResourceAsStream(CUSTOM_ERROR_PAGE_PATH)
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
            out << inputStream
            out.close();

            log.severe("Uncaught throwable was thrown: " + t.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
