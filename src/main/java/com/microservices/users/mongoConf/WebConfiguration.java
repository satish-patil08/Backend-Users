package com.microservices.users.mongoConf;

import com.microservices.users.filters.ClientRequestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean<ClientRequestFilter> clientFilter() {
        FilterRegistrationBean<ClientRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ClientRequestFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
