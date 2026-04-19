package com.upiiz.Practica2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cuenta;

    private String titular;
    private String tipo_cuenta;
    private BigDecimal saldo;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Transaccion> transacciones;
}