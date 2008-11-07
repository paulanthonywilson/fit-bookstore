package testutil.servlet;

import testutil.DummyProxy;

import javax.servlet.http.HttpServletResponse;

public class StubHttpServletResponse {
    public boolean committed;

    public HttpServletResponse asHttpServletResponse(){
        return DummyProxy.dummy(HttpServletResponse.class, this);
    }

    public boolean isCommitted() {
        return committed;
    }
}
