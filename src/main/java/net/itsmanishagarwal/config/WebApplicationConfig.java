package net.itsmanishagarwal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author manish
 */
@EnableWebMvc
@Configuration
public class WebApplicationConfig extends WebMvcConfigurerAdapter {

}
