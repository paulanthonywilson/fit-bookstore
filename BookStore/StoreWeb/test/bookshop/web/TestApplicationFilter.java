package bookshop.web;

import bookshop.BookStoreApplication;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import testutil.servlet.*;

import javax.servlet.ServletException;
import java.io.IOException;

public class TestApplicationFilter {
    private StubHttpServletRequest stubHttpServletRequest;
    private StubHttpServletResponse stubHttpServletResponse;
    private StubServletContext stubServletContext;
    private ApplicationFilter testee;
    private StubFilterChain stubFilterChain;

    @Before
    public void setUp() throws ServletException {
        stubHttpServletRequest = new StubHttpServletRequest();
        stubHttpServletResponse = new StubHttpServletResponse();
        stubServletContext = new StubServletContext();
        stubFilterChain = new StubFilterChain();
        testee = new ApplicationFilter();
        testee.init(new StubFilterConfig(stubServletContext).asFilterConfig());
    }

    @Test
    public void applicationSouldBeAddedToSessionIfNotPresent() throws IOException, ServletException {
        testee.doFilter(stubHttpServletRequest.asHttpServletRequest(),
                stubHttpServletResponse.asHttpServletResponse(),
                stubFilterChain.asFilterChain());
        assertNotNull(stubHttpServletRequest.getSession().getAttribute("application"));
    }

    @Test
    public void applicationShouldNotBeAddedToSessionIfAlreadyPresent() throws IOException, ServletException {
        BookStoreApplication existingApplication = new BookStoreApplication();
        stubHttpServletRequest.getSession().setAttribute("application", existingApplication);
        testee.doFilter(stubHttpServletRequest.asHttpServletRequest(),
                stubHttpServletResponse.asHttpServletResponse(),
                stubFilterChain.asFilterChain());

        assertEquals(existingApplication, stubHttpServletRequest.getSession().getAttribute("application"));
    }

    @Test
    public void shouldBeSentAlongFilterChain() throws IOException, ServletException {
        testee.doFilter(stubHttpServletRequest.asHttpServletRequest(),
                stubHttpServletResponse.asHttpServletResponse(),
                stubFilterChain.asFilterChain());

        assertNotNull(stubFilterChain.servletRequest);
        assertNotNull(stubFilterChain.servletResponse);
    }

    
    @Test
    public void shouldFinallyBeForwardedToLayoutJsp() throws Exception{

        testee.doFilter(stubHttpServletRequest.asHttpServletRequest(),
                stubHttpServletResponse.asHttpServletResponse(),
                stubFilterChain.asFilterChain());
        assertEquals("/WEB-INF/application_layout.jsp", stubServletContext.forwardedPath);

    }


    @Test
    public void shouldNotForwardIfResponseIsCommitted() throws Exception {
        stubHttpServletResponse.committed = true;
        testee.doFilter(stubHttpServletRequest.asHttpServletRequest(),
                stubHttpServletResponse.asHttpServletResponse(),
                stubFilterChain.asFilterChain());
        assertNull(stubServletContext.forwardedPath);

    }


}