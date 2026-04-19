package com.upiiz.Practica2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transacciones")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transaccion;

    private LocalDate fecha;
    private String tipo;
    private BigDecimal monto;

    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private Cuenta cuenta;
}