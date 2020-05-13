package controllers.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import models.RoomModel;
import services.RoomService;

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

@WebServlet(name = "RoomAPI")
public class    RoomAPI extends HttpServlet {
    private final Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomService roomService = new RoomService();
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String action = request.getParameter("action");
        String json = "";

        if(action != null && action.equals("delete")) {
            String roomId = request.getParameter("roomId");
            roomService.deleteRoom(Integer.parseInt(roomId));
            json = "{\"status\": \"succes\"}";
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(json);
            out.flush();
        } else {
            json = br.readLine();
            ObjectMapper mapper = new ObjectMapper();
            RoomModel newRoom = mapper.readValue(json, RoomModel.class);
            RoomModel room = roomService.getRoom(newRoom.getId());
            if (newRoom.getId() != 0){
                roomService.updateRoom(newRoom);
            } else {
                roomService.newRoom(newRoom);
            }
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            mapper.writeValue(response.getOutputStream(),newRoom);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomId = request.getParameter("roomId");
        String json = "";
        if(roomId == null){
            RoomService roomService = new RoomService();
            List<RoomModel> listRoom = roomService.getAllRoom();
            json =this.gson.toJson(listRoom);
        } else {
            RoomService roomService = new RoomService();
            RoomModel room = roomService.getRoom(Integer.parseInt(roomId));
            json =this.gson.toJson(room);
        }


        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
    }
}
