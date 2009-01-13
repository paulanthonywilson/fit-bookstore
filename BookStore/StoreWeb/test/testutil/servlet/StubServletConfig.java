package testutil.servlet;

import static com.merecomplexities.dummyproxy.DummyProxy.dummy;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class StubServletConfig {
    private StubServletContext stubServletContext = new StubServletContext();

    public ServletConfig asServletConfig() {
        return dummy(ServletConfig.class, this);
    }

    public ServletContext getServletContext(){
        return stubServletContext.asServletContext();
    }
}
