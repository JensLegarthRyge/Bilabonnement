package repositories;

import com.example.bilabonnement.repositories.interfaces.CRUDInterface;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginServiceTestRepository implements CRUDInterface{

    ArrayList<WebRequest> falseRequests = new ArrayList<>(
            Arrays.asList(
                    getWebRequest("1", "mads123"),
                    getWebRequest("10", "jensemand1234"),
                    getWebRequest("15", "johan321")

            )
    );

    ArrayList<WebRequest> trueRequests = new ArrayList<>(
            Arrays.asList(
                    getWebRequest("1", "mbhxluna1998"),
                    getWebRequest("10", "jensejense1337"),
                    getWebRequest("15", "johannes123")

            )
    );


    public WebRequest getWebRequest(String userLogin, String password) {
        MockHttpServletRequest mockObject = new MockHttpServletRequest();
        mockObject.addParameter("id", userLogin);
        mockObject.addParameter("password", password);
        HttpServletRequest request = new HttpServletRequestWrapper(mockObject);
        WebRequest webRequest = new ServletWebRequest(request);
        return webRequest;
    }

    public ArrayList<WebRequest> getAllFalseRequests(){
        return falseRequests;
    }

    public ArrayList<WebRequest> getAllTrueRequests(){
        return trueRequests;
    }



    @Override
    public boolean create(Object entity) {
        return false;
    }

    @Override
    public ArrayList<WebRequest> getAll() {
        return null;
    }

    @Override
    public WebRequest getSingleById(int id) {
        return null;
    }

    @Override
    public boolean update(Object entity) {
        return false;
    }


    @Override
    public void delete(int id) {

    }
}
