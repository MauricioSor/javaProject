package com.v1.consultorio.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pedidos_laboratorios")
public class PedidoLaboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido_laboratorio;

    private String texto;  // Hemograma, perfil lipídico, etc.

    @Temporal(TemporalType.DATE)
    private Date fechaPedido;

}
