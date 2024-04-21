package com.javag4.examenspring.toqueencinaslucioayle.controller;

import com.javag4.examenspring.toqueencinaslucioayle.entity.EmpresasEntity;
import com.javag4.examenspring.toqueencinaslucioayle.services.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("examenSpring/v1/empresas")
@AllArgsConstructor
@Tag(
        name = "API DE MANTENIMIENTO EMPRESAS",
        description = "Esta api contine todos los end points para realizar el mantenimiento de la entidad empresas"
)
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping("/crear")
    @Operation(summary = "Crear una nueva Empresa")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa Creada exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresasEntity.class))})
    })
    public ResponseEntity<EmpresasEntity> crear(@RequestBody EmpresasEntity empresasEntity,
    @RequestParam("usuarioCrea") String usuarioCrea){
        EmpresasEntity empresaCreada = empresaService.crear(empresasEntity, usuarioCrea);
        return new ResponseEntity<>(empresaCreada, HttpStatus.OK);
    }

    @Operation(summary = "Buscar Una Empresa Por ID")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Persona Encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresasEntity.class))})
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmpresasEntity>> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(empresaService.buscarPorId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<EmpresasEntity>> buscarTodos(){
        return ResponseEntity.ok(empresaService.buscarTodos());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EmpresasEntity> actualizar(@PathVariable Long id,
                                                     @RequestBody EmpresasEntity empresasEntity,
                                                     @RequestParam("usuarioModifica") String usuarioModifica){
        return ResponseEntity.ok(empresaService.actualizar(id,empresasEntity,usuarioModifica));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<EmpresasEntity> eliminar(@PathVariable Long id,
                                                   @RequestParam("usuarioElimina") String usuarioElimina){
        return ResponseEntity.ok(empresaService.borrar(id,usuarioElimina));
    }

}
