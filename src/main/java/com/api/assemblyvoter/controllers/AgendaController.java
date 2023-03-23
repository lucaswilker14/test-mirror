package com.api.assemblyvoter.controllers;

import com.api.assemblyvoter.dto.request.AgendaDTO;
import com.api.assemblyvoter.services.AgendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("AgendaController")
@RequestMapping(value = "agenda")
public class AgendaController {

    private AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping()
    public ResponseEntity<Object> createNewAgenda(@RequestBody @Valid AgendaDTO agendaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaService.createNewAgenda(agendaDTO));
    }

    @GetMapping()
    public ResponseEntity<Object> listAgenda() {
        return ResponseEntity.status(HttpStatus.OK).body(agendaService.getAgendas());
    }

    @GetMapping("/{id}/result")
    public ResponseEntity<Object> votingResult(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaService.votingResult(id));
    }
}
