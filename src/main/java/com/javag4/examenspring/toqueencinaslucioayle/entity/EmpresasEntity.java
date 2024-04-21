package com.javag4.examenspring.toqueencinaslucioayle.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "empresa")
@Data
public class EmpresasEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "razon_social", nullable = false)
        private String razonSocial;

        @Column(name = "tipo_documento", nullable = false, length = 1)
        private char tipoDocumento;

        @Column(name = "numero_documento", nullable = false, length = 11)
        private String numeroDocumento;

        @Column(nullable = false, length = 10)
        private String condicion;

        @Column(nullable = false)
        private String direccion;

        @Column(nullable = false)
        private String distrito;

        @Column(nullable = false)
        private String provincia;

        @Column(nullable = false)
        private String departamento;

        @Column(name = "es_agente_retencion", nullable = false)
        private Boolean esAgenteRetencion;

        @Column(nullable = false)
        private Integer estado;

        @Column(name = "usua_crea", nullable = false)
        private String usuarioCrea;

        @Column(name = "date_create", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date fechaCreacion;

        @Column(name = "usua_modif")
        private String usuarioModifica;

        @Column(name = "date_modif")
        @Temporal(TemporalType.TIMESTAMP)
        private Date fechaModificacion;

        @Column(name = "usua_delet")
        private String usuarioElimina;

        @Column(name = "date_delet")
        @Temporal(TemporalType.TIMESTAMP)
        private Date fechaEliminacion;

}
