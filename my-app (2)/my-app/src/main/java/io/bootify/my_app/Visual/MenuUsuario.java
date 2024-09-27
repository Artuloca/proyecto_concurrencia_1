// File: src/main/java/io/bootify/my_app/Visual/MenuUsuario.java
package io.bootify.my_app.Visual;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuUsuario {

    @GetMapping("/user/viewUserDatabase")
    public String viewUserDatabase() {
        // Logic to view the user database
        return "view_user_database";
    }

    @GetMapping("/user/viewEventDatabase")
    public String viewEventDatabase() {
        // Logic to view the event database
        return "view_event_database";
    }

    @GetMapping("/user/showCriticalEvents")
    public String showCriticalEvents() {
        // Logic to show critical events
        return "show_critical_events";
    }

    @GetMapping("/user/filterCriticalEvents")
    public String filterCriticalEvents() {
        // Logic to filter critical events
        return "filter_critical_events";
    }

    @GetMapping("/userLogout")
    public String logout(HttpSession session) {
        // Invalidate the session to clear the user data
        session.invalidate();
        // Redirect to the main menu
        return "redirect:/";
    }
}