package com.laptrinhjavaweb.ultils;


import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class MessageUltils {

    public static void showMessage(HttpServletRequest request) {
        ResourceBundle resource = ResourceBundle.getBundle("message");
        if (request.getParameter("message") != null) {
            String messageResponse = "";
            String alert = "";
            String message = request.getParameter("message");
            if (message.equals("insert_success")) {
                messageResponse = resource.getString("insert_success");
                alert = "success";
            } else if (message.equals("delete_success")) {
                messageResponse = resource.getString("delete_success");
                alert = "success";
            } else if (message.equals("update_success")) {
                messageResponse = resource.getString("update_success");
                alert = "success";
            } else if (message.equals("error_system")) {
                messageResponse = resource.getString("error_system");
                alert = "danger";
            }
            request.setAttribute("messageResponse", messageResponse);
            request.setAttribute("alert", alert);
        }
    }
}
