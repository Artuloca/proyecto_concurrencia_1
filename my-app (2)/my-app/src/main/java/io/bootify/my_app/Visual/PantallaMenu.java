package io.bootify.my_app.Visual;

import io.bootify.my_app.ControlAcceso.AuthenticationService;
import io.bootify.my_app.ASINCRONO.ConfiguracionAsincrona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PantallaMenu {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ConfiguracionAsincrona configuracionAsincrona;

    @GetMapping("/")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestParam String nombreUsuario, @RequestParam String contraseña, Model model) {
        String mensaje = authenticationService.authenticate(nombreUsuario, contraseña);
        model.addAttribute("mensaje", mensaje);

        // Llamar a los métodos asíncronos
        configuracionAsincrona.verificarMovimiento(true);
        configuracionAsincrona.verificarTemperatura(25);
        configuracionAsincrona.verificarAcceso(true);
        configuracionAsincrona.mostrarPantallaUsuario(nombreUsuario, contraseña, model);

        // Retornar la vista del menú
        return "menu";
    }
}