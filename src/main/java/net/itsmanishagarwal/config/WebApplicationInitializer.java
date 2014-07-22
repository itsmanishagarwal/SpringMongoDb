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
   * ApplicationContext beans are added here.
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] {
        WebApplicationConfig.class, ApplicationConfig.class
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
