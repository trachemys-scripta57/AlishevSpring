package ru.banana.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return null; // пока не будем использовать
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
// класс заменяет web.xml