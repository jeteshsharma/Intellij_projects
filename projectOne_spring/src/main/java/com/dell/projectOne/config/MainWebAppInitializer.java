package com.dell.projectOne.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MainWebAppInitializer implements WebApplicationInitializer{


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigApplicationContext root=new AnnotationConfigApplicationContext();

        root.scan("com.dell.projectOne");

        servletContext.addListener(new ContextLoaderListener((WebApplicationContext) root));

        ServletRegistration.Dynamic appServlet= servletContext.addServlet("mvc",new DispatcherServlet(new GenericWebApplicationContext()));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");



    }
}
