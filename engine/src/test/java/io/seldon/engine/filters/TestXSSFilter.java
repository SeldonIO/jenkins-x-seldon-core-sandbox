package io.seldon.engine.filters;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;

public class TestXSSFilter {
  @Test
  public void testSecurityHeaders() throws ServletException, IOException {
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    FilterChain chain = mock(FilterChain.class);

    XSSFilter filter = new XSSFilter();
    filter.doFilter(request, response, chain);

    verify(response).addHeader("X-Content-Type-Options", "nosniff");
    verify(chain).doFilter(request, response);
  }
}
