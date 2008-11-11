package testutil.servlet;

import static testutil.DummyProxy.dummy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StubHttpServletRequest {
    private StubHttpSession httpSession = new StubHttpSession();
    private String method;
    private Map<String, Object> attributes = new HashMap<String, Object>();
    private Map<String, List<String>> parameters = new HashMap<String, List<String>>();

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


    public String getParameter(String name){
        List<String> values = parameters.get(name);
        if (values == null) return null;
        return values.get(0);
    }

    public StubHttpServletRequest addParameter(String name, String value) {
        List<String> values = parameters.get(name);
        if (values == null) {
           values = new ArrayList<String>();
            parameters.put(name, values);
        }
        values.add(value);
        return this;
    }

    public StubHttpServletRequest andParameter(String name, String value){
        return addParameter(name, value);
    }


}

