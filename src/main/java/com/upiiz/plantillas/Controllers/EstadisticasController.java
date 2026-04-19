package com.upiiz.plantillas.Controllers;

import com.upiiz.Practica2.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstadisticasController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/estadisticas")
    public String verEstadisticas(Model model) {
        // En un caso real, aquí calcularías los totales desde la BD
        // model.addAttribute("totalCuentas", cuentaService.contar());

        model.addAttribute("usuarioLogueado", "Luis"); // Requisito de tu imagen
        return "estadisticas";
    }
}