package controllers.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import models.BookingModel;
import services.BookingService;

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

@WebServlet(name = "BookingAPI")
public class BookingAPI extends HttpServlet {
    private final Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingService bookingService = new BookingService();
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

        String json = "";
        json = br.readLine();
        ObjectMapper mapper = new ObjectMapper();
        BookingModel newBooking = mapper.readValue(json, BookingModel.class);
        BookingModel booking = bookingService.getBooking(newBooking.getId());
        if (newBooking.equals(booking)){
           bookingService.updateBooking(newBooking);
        } else {
            bookingService.newBooking(newBooking);
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        mapper.writeValue(response.getOutputStream(),newBooking);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingService bookingService = new BookingService();
        List<BookingModel> listBooking = bookingService.getAllBooking();
        String json =this.gson.toJson(listBooking);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
    }
}
