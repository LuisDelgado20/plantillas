package com.upiiz.plantillas.Controllers;

import com.upiiz.plantillas.entities.Cuenta;
import com.upiiz.plantillas.Services.CuentaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cuentas")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    // --- ESTE ES EL ÚNICO MÉTODO LISTAR QUE DEBE EXISTIR ---
    @GetMapping
    public String listar(Model model, HttpSession session) {
        // 1. Recuperamos el titular guardado en AuthController
        String nombreLogueado = (String) session.getAttribute("usuarioLogueado");

        // 2. Seguridad: Si no hay sesión activa, redirigir al login
        if (nombreLogueado == null) {
            return "redirect:/auth/login";
        }

        // 3. Buscamos SOLO la cuenta del titular logueado
        Cuenta cuentaUsuario = cuentaService.buscarPorTitular(nombreLogueado);

        // 4. Mandamos a la vista una lista que SOLO contiene su cuenta
        // Usamos List.of para que el th:each del HTML funcione correctamente
        if (cuentaUsuario != null) {
            model.addAttribute("cuentas", List.of(cuentaUsuario));
        } else {
            // Si por alguna razón no tiene cuenta, mandamos lista vacía
            model.addAttribute("cuentas", List.of());
        }

        model.addAttribute("usuarioLogueado", nombreLogueado);

        return "cuentas/listado";
    }

    @GetMapping("/nueva")
    public String formularioNueva(Model model) {
        model.addAttribute("cuenta", new Cuenta());
        return "cuentas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cuenta cuenta) {
        cuentaService.guardar(cuenta);
        return "redirect:/cuentas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        cuentaService.eliminar(id);
        return "redirect:/cuentas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Cuenta cuenta = cuentaService.buscarPorId(id);
        model.addAttribute("cuenta", cuenta);
        return "cuentas/formulario";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }

}
