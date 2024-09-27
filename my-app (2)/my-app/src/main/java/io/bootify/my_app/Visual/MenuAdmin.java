package io.bootify.my_app.Visual;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuAdmin {

    @GetMapping("/admin")
    public String showAdminMenu() {
        return "admin_menu";
    }

    @GetMapping("/addUser")
    public String addUser() {
        // Lógica para añadir usuario
        return "add_user";
    }

    @GetMapping("/viewUserDatabase")
    public String viewUserDatabase() {
        // Lógica para ver la base de datos del usuario
        return "view_user_database";
    }

    @GetMapping("/viewEventDatabase")
    public String viewEventDatabase() {
        // Lógica para ver la base de datos de eventos
        return "view_event_database";
    }

    @GetMapping("/deleteUser")
    public String deleteUser() {
        // Lógica para borrar usuario
        return "delete_user";
    }

    @GetMapping("/showCriticalEvents")
    public String showCriticalEvents() {
        // Lógica para mostrar eventos críticos
        return "show_critical_events";
    }

    @GetMapping("/filterCriticalEvents")
    public String filterCriticalEvents() {
        // Lógica para filtrar tipo de evento crítico
        return "filter_critical_events";
    }

    @GetMapping("/logout")
    public String logout() {
        // Lógica para salir
        return "logout";
    }
}