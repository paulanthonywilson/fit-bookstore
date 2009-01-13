package testutil.servlet;

import static com.merecomplexities.dummyproxy.DummyProxy.dummy;
import static org.junit.Assert.assertNotNull;

import javax.servlet.*;
import java.io.IOException;

public class StubServletContext {

    public String forwardedPath;

    public ServletContext asServletContext(){
        return dummy(ServletContext.class, this);
    }


    public RequestDispatcher getRequestDispatcher(String path){
        return new StubRequestDispatcher(path);
    }

    private class StubRequestDispatcher implements RequestDispatcher{

        private String path;

        private StubRequestDispatcher(String path) {
            this.path = path;
        }

        public void forward(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
            assertNotNull(servletRequest);
            assertNotNull(servletResponse);
            forwardedPath = path;
        }

        public void include(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
            throw new UnsupportedOperationException("stub include not implemented");
        }
    }

}
