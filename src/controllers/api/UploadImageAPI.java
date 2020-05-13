package controllers.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import models.BookingModel;
import org.apache.commons.codec.digest.DigestUtils;
import services.BookingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.List;
import org.apache.commons.io.FileUtils;

@WebServlet(name = "UploadImageAPI")
public class UploadImageAPI extends HttpServlet {
    private final Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "";
        try {
            Part filePart = request.getPart("file");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            InputStream fileContent = filePart.getInputStream();


            String rootPath = System.getProperty("catalina.home") + "/webapps";
            String ModulePath = "/hotel/assets/images/rooms/";
            String extension = "";
            int i = fileName.lastIndexOf('.');
            if (i > 0) {
                extension = "." + fileName.substring(i+1);
            }
            String encodeFileName = DigestUtils.md5Hex(fileName + System.currentTimeMillis());

            String filePath = rootPath + ModulePath + encodeFileName + extension;

            File targetFile = new File(filePath);

            FileUtils.copyInputStreamToFile(fileContent, targetFile);

            json = "{\"status\": \"succes\", \"fileName\": \""+ModulePath + encodeFileName + extension+"\"}";

        } catch (NullPointerException e) {
            json = "{\"status\": \"failed\", \"error\": "+e.getMessage()+"}";
        }

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
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
