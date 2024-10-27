package com.v1.consultorio.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pedidos_laboratorios")
public class PedidoLaboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido_laboratorio;

    private String texto;  // Hemograma, perfil lipídico, etc.

 public int getIdPedido_laboratorio(){return this.idPedido_laboratorio;}
    public void setIdPedido_laboratorio(int idPedido_laboratorio){this.idPedido_laboratorio=idPedido_laboratorio;}
    public String getTexto(){return this.texto;}
    public void setTexto(String texto){this.texto=texto;}

}
