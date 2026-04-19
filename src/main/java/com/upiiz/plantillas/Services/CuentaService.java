package com.upiiz.Practica2.services;

import com.upiiz.Practica2.entities.Cuenta;
import com.upiiz.Practica2.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> listarTodas() { return cuentaRepository.findAll(); }
    public Cuenta guardar(Cuenta cuenta) { return cuentaRepository.save(cuenta); }
    public Cuenta obtenerPorId(Long id) { return cuentaRepository.findById(id).orElse(null); }
    public void eliminar(Long id) { cuentaRepository.deleteById(id); }
}