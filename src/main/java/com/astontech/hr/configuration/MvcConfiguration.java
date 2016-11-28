package com.astontech.hr.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

//      This allows for mapping the DispatcherServlet to "/" (thus overriding the mapping of
//      the container’s default Servlet), while still allowing static resource requests to be
//      handled by the container’s default Servlet. It configures a DefaultServletHttpRequestHandler
//      with a URL mapping of "/**" and the lowest priority relative to other URL mappings.
//
//      This handler will forward all requests to the default Servlet. Therefore it is important
//      that it remains last in the order of all other URL HandlerMappings. That will be the case
//      if you use <mvc:annotation-driven> or alternatively if you are setting up your own customized
//      HandlerMapping instance be sure to set its order property to a value lower than that of the
//      DefaultServletHttpRequestHandler, which is Integer.MAX_VALUE.

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
