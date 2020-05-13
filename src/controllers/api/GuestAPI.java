package controllers.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import models.GuestModel;
import services.GuestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GuestAPI")
public class GuestAPI extends HttpServlet {
    private final Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GuestService guestService = new GuestService();

        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        json = br.readLine();
        ObjectMapper mapper = new ObjectMapper();
        GuestModel newGuest = mapper.readValue(json, GuestModel.class);
        GuestModel guest = guestService.getGuest(newGuest.getId());
        if (newGuest.equals(guest)) {
            guestService.updateGuest(newGuest);
        } else {
            guestService.createGuest(newGuest);
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        mapper.writeValue(response.getOutputStream(), newGuest);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GuestService guestService = new GuestService();
        List<GuestModel> guestList = guestService.getAllGuest();
        String json = this.gson.toJson(guestList);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
    }
}