package br.edu.imepac.controllers;

import br.edu.imepac.dtos.*;
import br.edu.imepac.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ConvenioService convenioService;

    @Autowired
    private EspecialidadeService especialidadeService;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String getAllEntities(Model model) {
        model.addAttribute("convenios", convenioService.getAllConvenios());
        model.addAttribute("especialidades", especialidadeService.getAllEspecialidades());
        model.addAttribute("funcionarios", funcionarioService.getAllFuncionarios());
        model.addAttribute("medicos", medicoService.findAll());
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        model.addAttribute("convenioCreateRequest", new ConvenioCreateRequest());
        model.addAttribute("especialidadeCreateRequest", new EspecialidadeCreateRequest());
        model.addAttribute("funcionarioCreateRequest", new FuncionarioCreateRequest());
        model.addAttribute("medicoCreateRequest", new MedicoCreateRequest());
        model.addAttribute("usuarioCreateRequest", new UsuarioCreateRequest());
        return "admin";
    }

    @PostMapping("/convenios/add")
    public String addConvenio(@ModelAttribute ConvenioCreateRequest request) {
        convenioService.createConvenio(request);
        return "redirect:/admin";
    }

    @PostMapping("/especialidades/add")
    public String addEspecialidade(@ModelAttribute EspecialidadeCreateRequest request) {
        especialidadeService.createEspecialidade(request);
        return "redirect:/admin";
    }

    @PostMapping("/funcionarios/add")
    public String addFuncionario(@ModelAttribute FuncionarioCreateRequest request) {
        funcionarioService.createFuncionario(request);
        return "redirect:/admin";
    }

    @PostMapping("/medicos/add")
    public String addMedico(@ModelAttribute MedicoCreateRequest request) {
        medicoService.save(request);
        return "redirect:/admin";
    }

    @PostMapping("/usuarios/add")
    public String addUsuario(@ModelAttribute UsuarioCreateRequest request) {
        usuarioService.createUsuario(request);
        return "redirect:/admin";
    }


}