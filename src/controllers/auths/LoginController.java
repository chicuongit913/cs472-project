package controllers.auths;

import models.UserModel;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils;

@WebServlet(name = "IndexController")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        List<String> errorMessages = new ArrayList<String>();

        if (email == null || email.isEmpty()) {
            errorMessages.add("Please enter username");
        }

        if (password == null || password.isEmpty()) {
            errorMessages.add("Please enter password");
        }

        if (errorMessages.size() == 0) {
            UserModel user = userService.getUserByEmail(email);
            System.out.println(DigestUtils.md5Hex(password));
            if (user != null) {
                if(user.getPassword().equals(DigestUtils.md5Hex(password))) {
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect(request.getContextPath() + "/home");
                    return;
                } else {
                    errorMessages.add("Email or Password was wrong, please try again!");
                }

            } else {
                errorMessages.add("Email account doesn't exist on system, please try again!");
            }
        }

        request.setAttribute("errorMessages", errorMessages);
        request.getRequestDispatcher("/WEB-INF/views/auths/login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/auths/login.jsp").forward(request, response);
    }
}
