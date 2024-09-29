// File: src/main/java/io/bootify/my_app/Visual/MenuUsuario.java
package io.bootify.my_app.Visual;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuUsuario {

    @GetMapping("/user/viewUserDatabase")
    public String viewUserDatabase() {
        return "view_user_database_user";
    }

   @GetMapping("/user/viewEventDatabaseUser")
public String viewEventDatabaseUser() {
    return "view_event_database_user";
}

    @GetMapping("/user/showCriticalEvents")
    public String showCriticalEvents() {
        return "show_critical_events";
    }

    @GetMapping("/user/filterCriticalEvents")
    public String filterCriticalEvents() {
        return "filter_critical_events";
    }

    @GetMapping("/userLogout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/user/backToMenu")
    public String backToMenu(HttpSession session) {
        if (session.getAttribute("admin") != null) {
            return "redirect:/admin";
        } else {
            return "redirect:/user";
        }
    }
}