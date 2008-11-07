package testutil.servlet;

import static testutil.DummyProxy.dummy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class StubHttpServletRequest {
    private StubHttpSession httpSession = new StubHttpSession();
    private String method;
    private Map<String, Object> attributes = new HashMap<String, Object>();

    public HttpServletRequest asHttpServletRequest() {
        return dummy(HttpServletRequest.class, this);
    }


    public HttpSession getSession() {
        return httpSession.asSession();
    }


    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }


    public void setAttribute(String name, Object attribute){
        attributes.put(name, attribute);
    }


    public Object getAttribute(String name) {
        return attributes.get(name);
    }
}
