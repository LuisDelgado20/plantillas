package com.upiiz.plantillas.Controllers;

import com.upiiz.Practica2.entities.Transaccion;
import com.upiiz.Practica2.services.CuentaService;
import com.upiiz.Practica2.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transacciones")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    @Autowired
    private CuentaService cuentaService;

    // 5. Pagina - Listado de la tabla secundaria
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("transacciones", transaccionService.listarTodas());
        model.addAttribute("usuarioLogueado", "Luis Daniel"); // Requisito visual
        return "transacciones/listado";
    }

    // 6. Pagina - Agregar registro a la tabla secundaria
    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("transaccion", new Transaccion());
        // Necesitamos la lista de cuentas para el selector (Foreign Key)
        model.addAttribute("cuentas", cuentaService.listarTodas());
        return "transacciones/formulario";
    }

    // 7. Pagina - Actualizar registros
    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("transaccion", transaccionService.obtenerPorId(id));
        model.addAttribute("cuentas", cuentaService.listarTodas());
        return "transacciones/formulario";
    }

    // Guardar cambios
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Transaccion transaccion) {
        transaccionService.guardar(transaccion);
        return "redirect:/transacciones";
    }

    // 8. Pagina - Eliminar registro
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        transaccionService.eliminar(id);
        return "redirect:/transacciones";
    }
}