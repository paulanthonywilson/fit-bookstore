package testutil.servlet;

import testutil.DummyProxy;

import javax.servlet.http.HttpServletResponse;

public class StubHttpServletResponse {
    public HttpServletResponse asHttpServletResponse(){
        return DummyProxy.dummy(HttpServletResponse.class, this);
    }
}
