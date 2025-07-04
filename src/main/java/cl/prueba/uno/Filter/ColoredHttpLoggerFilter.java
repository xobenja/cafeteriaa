package cl.prueba.uno.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class ColoredHttpLoggerFilter implements Filter {

    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";  // GET
    private static final String BLUE = "\u001B[34m";   // POST
    private static final String YELLOW = "\u001B[33m"; // PUT
    private static final String RED = "\u001B[31m";    // DELETE
    private static final String CYAN = "\u001B[36m";   // Otros

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String method = httpRequest.getMethod();
        String uri = httpRequest.getRequestURI();

        String color = switch (method) {
            case "GET" -> GREEN;
            case "POST" -> BLUE;
            case "PUT" -> YELLOW;
            case "DELETE" -> RED;
            default -> CYAN;
        };

        log.info(color + "HTTP {} -> {}" + RESET, method, uri);

        chain.doFilter(request, response);
    }
}
