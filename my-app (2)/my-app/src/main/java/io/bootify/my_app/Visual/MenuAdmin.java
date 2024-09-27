package io.bootify.my_app.Visual;

import io.bootify.my_app.domain.Usuario;
import io.bootify.my_app.repos.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
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
        return "redirect:/admin";
    }

    @GetMapping("/deleteUser")
    public String deleteUserForm() {
        return "delete_user";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam String nombre, Model model) {
        if ("admin".equalsIgnoreCase(nombre)) {
            model.addAttribute("mensaje", "No se puede borrar el usuario 'admin'.");
            return "delete_user";
        }

        boolean usuarioEliminado = usuarioRepository.findByNombre(nombre)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return true;
                })
                .orElse(false);

        if (usuarioEliminado) {
            return "redirect:/admin";
        } else {
            model.addAttribute("mensaje", "El usuario no existe.");
            return "delete_user";
        }
    }

    @GetMapping("/viewUserDatabase")
    public String viewUserDatabase() {
        return "view_user_database_admin";
    }

    @GetMapping("/viewEventDatabaseAdmin")
public String viewEventDatabaseAdmin() {
    return "view_event_database_admin";
}

    @GetMapping("/showCriticalEvents")
    public String showCriticalEvents() {
        return "show_critical_events";
    }

    @GetMapping("/filterCriticalEvents")
    public String filterCriticalEvents() {
        return "filter_critical_events";
    }

    @GetMapping("/adminLogout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/admin/backToMenu")
    public String backToMenu(HttpSession session) {
        if (session.getAttribute("admin") != null) {
            return "redirect:/admin";
        } else {
            return "redirect:/user";
        }
    }
}