package testutil.servlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class StubFilterChain implements FilterChain {
    public ServletRequest servletRequest;
    public ServletResponse servletResponse;

    public FilterChain asFilterChain() {
        return this;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {

        this.servletRequest = servletRequest;
        this.servletResponse = servletResponse;
    }
}
