package pigeo.fr.services;

import org.apache.commons.dbcp.DriverConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pigeo.fr.domain.User;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.List;


@Controller
public class MainController {

    @RequestMapping(value="/tellmyname/{firstname}", method=RequestMethod.GET)
    @ResponseBody
    public String getName(
            @PathVariable("firstname") String firstname,
            HttpServletRequest request, HttpServletResponse response) throws SQLException {

        EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        String res = null;
        Query query = entityManager.createQuery("From User u where u.firstname=:arg1");
        query.setParameter("arg1", firstname);

        List<User> resultList = query.getResultList();
        for (User next : resultList) {
            res = next.getLastname();
        }
        if(res == null) {
            res = "No user " + firstname;
        }
        return res;
    }
}
