package com.upiiz.plantillas.Controllers;

import com.upiiz.Practica2.entities.Cuenta;
import com.upiiz.Practica2.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cuentas")
public class


CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cuentas", cuentaService.listarTodas());
        // El nombre del usuario activo (Requisito imagen 4)
        model.addAttribute("usuarioLogueado", "Luis Daniel");
        return "cuentas/listado";
    }

    @GetMapping("/nuevo")
    public String formularioNueva(Model model) {
        model.addAttribute("cuenta", new Cuenta());
        return "cuentas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cuenta cuenta) {
        cuentaService.guardar(cuenta);
        return "redirect:/cuentas";
    }
}