package net.itsmanishagarwal.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author manish
 */
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] {
      ApplicationConfig.class
    };
  }

  /**
   * ApplicationContext beans are added here. <br>
   * Specify {@link org.springframework.context.annotation.Configuration @Configuration} and/or
   * {@link org.springframework.stereotype.Component @Component} classes to be provided to the
   * {@linkplain #createServletApplicationContext() dispatcher servlet application context}.
   * 
   * @return the configuration classes for the dispatcher servlet application context (may not be empty or {@code null})
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] {
      ApplicationConfig.class
    };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {
      "/"
    };
  }
  
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    super.onStartup(servletContext);
    this.registerRequestContextListener(servletContext);
  }

  private void registerRequestContextListener(ServletContext servletContext) {
    servletContext.addListener(new RequestContextListener());
  }
}
