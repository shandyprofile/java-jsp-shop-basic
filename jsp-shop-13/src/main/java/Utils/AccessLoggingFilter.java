package Utils;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "AccessLoggingFilter")
public class AccessLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        // Log request details
        String requestURI = httpRequest.getRequestURI();
        String remoteAddr = httpRequest.getRemoteAddr();
        String method = httpRequest.getMethod();
        
        LoggerUtil.log(String.format("Request: %s %s from IP: %s",
                method, requestURI, remoteAddr));

        // Pass request along the filter chain
        chain.doFilter(request, response);
    }

}
