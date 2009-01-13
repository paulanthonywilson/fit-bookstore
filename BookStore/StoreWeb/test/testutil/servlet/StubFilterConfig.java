package testutil.servlet;

import static com.merecomplexities.dummyproxy.DummyProxy.dummy;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;

public class StubFilterConfig {
    private StubServletContext stubServletContext ;

    public StubFilterConfig(StubServletContext stubServletContext) {
        this.stubServletContext = stubServletContext;
    }

    public FilterConfig asFilterConfig() {
        return dummy(FilterConfig.class, this);
    }

    public ServletContext getServletContext(){
        return stubServletContext.asServletContext();
    }
}