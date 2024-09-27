package io.bootify.my_app.Visual;

import io.bootify.my_app.domain.Usuario;
import io.bootify.my_app.repos.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuAdmin {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/admin")
    public String showAdminMenu() {
        return "admin_menu";
    }

    @GetMapping("/addUser")
    public String addUserForm() {
        return "add_user";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String nombre, @RequestParam String contraseña, Model model) {
        if ("admin".equalsIgnoreCase(nombre)) {
            model.addAttribute("mensaje", "El nombre de usuario no puede ser 'admin'.");
            return "add_user";
        }

        if (usuarioRepository.findByNombre(nombre).isPresent()) {
            model.addAttribute("mensaje", "El nombre de usuario ya existe.");
            return "add_user";
        }

        Usuario nuevoUsuario = new Usuario(nombre, contraseña, false);
        usuarioRepository.save(nuevoUsuario);
        model.addAttribute("mensaje", "Usuario añadido exitosamente.");
        return "add_user";
    }

    @GetMapping("/viewUserDatabase")
    public String viewUserDatabase() {
        return "view_user_database";
    }

    @GetMapping("/viewEventDatabase")
    public String viewEventDatabase() {
        return "view_event_database";
    }

    @GetMapping("/deleteUser")
    public String deleteUser() {
        return "delete_user";
    }

    @GetMapping("/showCriticalEvents")
    public String showCriticalEvents() {
        return "show_critical_events";
    }

    @GetMapping("/filterCriticalEvents")
    public String filterCriticalEvents() {
        return "filter_critical_events";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }
}