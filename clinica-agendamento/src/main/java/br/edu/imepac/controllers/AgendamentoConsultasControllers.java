package br.edu.imepac.controllers;

import br.edu.imepac.Dtos.AgendamentoConsultasCreateRequest;
import br.edu.imepac.Dtos.AgendamentoConsultasDto;
import br.edu.imepac.Services.AgendamentoConsultasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class AgendamentoConsultasControllers {

    @Autowired
    private AgendamentoConsultasServices agendamentoConsultasServices;

    @GetMapping
    public ResponseEntity<List<AgendamentoConsultasDto>> listAllConsultas() {
        List<AgendamentoConsultasDto> agendamentoconsultas = agendamentoConsultasServices.findAll();
        return new ResponseEntity<>(agendamentoconsultas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoConsultasDto> getConsultaById(@PathVariable Long id) {
        AgendamentoConsultasDto agendamentoConsultasDto = agendamentoConsultasServices.findById(id);
        if (agendamentoConsultasDto != null) {
            return ResponseEntity.ok(agendamentoConsultasDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AgendamentoConsultasDto> agendarConsulta(@RequestBody AgendamentoConsultasCreateRequest agendamentoConsultasCreateRequest) {
        AgendamentoConsultasDto consultaDto = agendamentoConsultasServices.agendarConsulta(agendamentoConsultasCreateRequest);
        return new ResponseEntity<>(consultaDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<AgendamentoConsultasDto> cancelarConsulta(@PathVariable Long id, @RequestParam String motivoCancelamento) {
        AgendamentoConsultasDto consultaDto = agendamentoConsultasServices.cancelarConsulta(id, motivoCancelamento);
        return new ResponseEntity<>(consultaDto, HttpStatus.OK);
    }

    @PutMapping("/{id}/retorno")
    public ResponseEntity<AgendamentoConsultasDto> registrarRetorno(@PathVariable Long id, @RequestParam String data, @RequestParam String hora) {
        AgendamentoConsultasDto consultaDto = agendamentoConsultasServices.registrarRetorno(id, data, hora);
        return new ResponseEntity<>(consultaDto, HttpStatus.OK);
    }
}