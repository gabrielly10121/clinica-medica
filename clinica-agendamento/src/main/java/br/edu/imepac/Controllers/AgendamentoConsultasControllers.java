package br.edu.imepac.Controllers;

import br.edu.imepac.Model.AgendamentoConsultasModel;
import br.edu.imepac.Services.AgendamentoConsultasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/consultas")
//@Api(value = "AgendamentoConsultas", tags = "Agendamento Consultas")
public class AgendamentoConsultasControllers {
    @Autowired
    private AgendamentoConsultasServices service;

    @GetMapping
    ////@ApiOperation(value = "Lista todas as consultas")
    public String getAllConsultas(Model model) {
        List<AgendamentoConsultasModel> consultas = service.findAll();
        model.addAttribute("consultas", consultas);
        return "consultas/list";
    }

    @GetMapping("/new")
    ////@ApiOperation(value = "Mostra o formulário de criação de consulta")
    public String showCreateForm(Model model) {
        model.addAttribute("consulta", new AgendamentoConsultasModel());
        return "consultas/create";
    }

    @PostMapping
    ////@ApiOperation(value = "Cria uma nova consulta")
    public String createConsulta(@ModelAttribute AgendamentoConsultasModel consulta) {
        service.save(consulta);
        return "redirect:/consultas";
    }

    @GetMapping("/delete/{id}")
    ////@ApiOperation(value = "Deleta uma consulta pelo ID")
    public String deleteConsulta(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/consultas";
    }
}