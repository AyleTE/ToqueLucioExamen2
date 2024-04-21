package com.javag4.examenspring.toqueencinaslucioayle.services;


import com.javag4.examenspring.toqueencinaslucioayle.entity.EmpresasEntity;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    EmpresasEntity crear(EmpresasEntity empresasEntity, String usuarioCrea);
    Optional<EmpresasEntity> buscarPorId(Long id);
    List<EmpresasEntity> buscarTodos();
    EmpresasEntity actualizar(Long id, EmpresasEntity empresasEntity, String usuarioModifica);
    EmpresasEntity borrar(Long id, String usuarioElimina);
}
