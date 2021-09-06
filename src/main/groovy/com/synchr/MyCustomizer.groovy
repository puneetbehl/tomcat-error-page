package com.synchr

import org.apache.catalina.Container
import org.apache.catalina.Context
import org.apache.catalina.core.StandardHost
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.stereotype.Component

class MyCustomizer
        implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Override
    void customize(TomcatServletWebServerFactory factory) {
        factory.addContextCustomizers((TomcatContextCustomizer) { Context context ->
            final Container parent = context.getParent()
            if (parent instanceof StandardHost) {
                ((StandardHost) parent).setErrorReportValveClass(CustomErrorReportValve.class.name)
            }
        });
    }
}