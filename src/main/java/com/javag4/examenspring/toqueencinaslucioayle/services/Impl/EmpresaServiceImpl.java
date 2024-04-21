package com.javag4.examenspring.toqueencinaslucioayle.services.Impl;


import com.javag4.examenspring.toqueencinaslucioayle.dao.EmpresaRepository;
import com.javag4.examenspring.toqueencinaslucioayle.entity.EmpresasEntity;
import com.javag4.examenspring.toqueencinaslucioayle.services.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Override
    public EmpresasEntity crear(EmpresasEntity empresasEntity, String usuarioCrea) {

        EmpresasEntity empresaNuevo = new EmpresasEntity();
        empresaNuevo.setRazonSocial(empresasEntity.getRazonSocial());
        empresaNuevo.setTipoDocumento(empresasEntity.getTipoDocumento());
        empresaNuevo.setNumeroDocumento(empresasEntity.getNumeroDocumento());
        empresaNuevo.setCondicion(empresasEntity.getCondicion());
        empresaNuevo.setDireccion(empresasEntity.getDireccion());
        empresaNuevo.setDistrito(empresasEntity.getDistrito());
        empresaNuevo.setProvincia(empresasEntity.getProvincia());
        empresaNuevo.setDepartamento(empresasEntity.getDepartamento());
        empresaNuevo.setEsAgenteRetencion(empresasEntity.getEsAgenteRetencion());

        empresaNuevo.setEstado(1);
        empresaNuevo.setUsuarioCrea(usuarioCrea);
        empresaNuevo.setFechaCreacion(new Date());

        return empresaRepository.save(empresaNuevo);
    }

    @Override
    public Optional<EmpresasEntity> buscarPorId(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public List<EmpresasEntity> buscarTodos() {
        return empresaRepository.findAll();
    }

    @Override
    public EmpresasEntity actualizar(Long id, EmpresasEntity empresasEntity, String usuarioModifica) {
        Optional<EmpresasEntity> empresaRecuperada = empresaRepository.findById(id);
        if (empresaRecuperada.isPresent()) {
            EmpresasEntity empresaExistente = empresaRecuperada.get();
            empresaExistente.setRazonSocial(empresasEntity.getRazonSocial());
            empresaExistente.setTipoDocumento(empresasEntity.getTipoDocumento());
            empresaExistente.setNumeroDocumento(empresasEntity.getNumeroDocumento());
            empresaExistente.setCondicion(empresasEntity.getCondicion());
            empresaExistente.setDireccion(empresasEntity.getDireccion());
            empresaExistente.setDistrito(empresasEntity.getDistrito());
            empresaExistente.setProvincia(empresasEntity.getProvincia());
            empresaExistente.setDepartamento(empresasEntity.getDepartamento());
            empresaExistente.setEsAgenteRetencion(empresasEntity.getEsAgenteRetencion());

            empresaExistente.setUsuarioModifica(usuarioModifica);
            empresaExistente.setFechaModificacion(new Date());

            return empresaRepository.save(empresaExistente);
        } else {

            return null;
        }
    }

    @Override
    public EmpresasEntity borrar(Long id, String usuarioElimina) {

        Optional<EmpresasEntity> empresaRecuperada = empresaRepository.findById(id);
        if (empresaRecuperada.isPresent()){
            empresaRecuperada.get().setEstado(0);
            empresaRecuperada.get().setUsuarioElimina(usuarioElimina);
            empresaRecuperada.get().setFechaEliminacion(new Date());
            return empresaRepository.save(empresaRecuperada.get());
        }
        return null;
    }
}
