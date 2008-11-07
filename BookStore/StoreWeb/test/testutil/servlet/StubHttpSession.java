package testutil.servlet;

import testutil.DummyProxy;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.HashMap;

public class StubHttpSession {
    private Map<String, Object> attributes = new HashMap<String, Object>();

    public HttpSession asSession() {
        return DummyProxy.dummy(HttpSession.class, this);
    }

    public void setAttribute(String name, Object attribute){
        attributes.put(name, attribute);
    }

    public Object getAttribute(String name){
        return attributes.get(name);
    }

}
