package com.simpli.learner.config;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class CustomLoginSuccessHandler  extends SimpleUrlAuthenticationSuccessHandler {

  @Override
  protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException {
    String targetUrl = determineTargetUrl(authentication);
    if(response.isCommitted()) return;
    RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    redirectStrategy.sendRedirect(request, response, targetUrl);
  }

  protected String determineTargetUrl(Authentication authentication){
    return "/admin/dashboard";
  }

}
