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
    //Johannes Forsting
    ArrayList<WebRequest> falseRequests = new ArrayList<>(
            Arrays.asList(
                    getWebRequest("Madssaasdfasdsfsdfasdasdf@BA.com", "mads123"),
                    getWebRequest("jens.l.ryge@pol.dk", "jensemand1234"),
                    getWebRequest("johan@johanes.com", "johannes123")

            )
    );

    ArrayList<WebRequest> trueRequests = new ArrayList<>(
            Arrays.asList(
                    getWebRequest("Madssaasdfasdsfsdfasdasdf@BA.com", "mbhxluna1998"),
                    getWebRequest("jens.l.ryge@pol.dk", "jensejense1337"),
                    getWebRequest("johannes@johannes.com", "johannes123")

            )
    );


    public WebRequest getWebRequest(String userLogin, String password) {
        MockHttpServletRequest mockObject = new MockHttpServletRequest();
        mockObject.addParameter("email", userLogin);
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
