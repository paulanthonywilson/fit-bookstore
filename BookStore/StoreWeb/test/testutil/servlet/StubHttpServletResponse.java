package testutil.servlet;

import com.merecomplexities.dummyproxy.DummyProxy;

import javax.servlet.http.HttpServletResponse;

public class StubHttpServletResponse {
    public boolean committed;
    public String redirectedTo;

    public HttpServletResponse asHttpServletResponse() {
        return DummyProxy.dummy(HttpServletResponse.class, this);
    }

    public boolean isCommitted() {
        return committed;
    }

    public void sendRedirect(String redirect) {
        redirectedTo = redirect;
    }
}
