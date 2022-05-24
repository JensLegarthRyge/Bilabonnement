package repositories;

import org.apache.catalina.Service;
import org.apache.catalina.core.StandardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@SpringBootApplication
public class RequestMockingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        //SpringApplication.run(RequestMockingApplication.class, args);


        /*
        MockHttpServletRequest mockObject = new MockHttpServletRequest();
        mockObject.addParameter("test", "tester");
        HttpServletRequest request = new HttpServletRequestWrapper(mockObject);
        WebRequest wr = new ServletWebRequest(request);
        System.out.println(wr.getParameter("test"));*/

    }

    @Override
    public void run(String... args) throws Exception {
        //Making a HTTPServletRequest object
        MockHttpServletRequest mockObject = new MockHttpServletRequest();
        //Adding a parameter
        mockObject.addParameter("name", "Ye");
        //adding the "mocked" object to a request wrapper
        HttpServletRequest request = new HttpServletRequestWrapper(mockObject);
        //Creating a WebRequest object form the request wrapper (with the mocked servlet request inside)
        WebRequest wr = new ServletWebRequest(request);

        System.out.println(wr.getParameter("name"));
    }
}