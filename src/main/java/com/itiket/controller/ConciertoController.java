/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itiket.controller;

import com.itiket.entity.Concierto;
import com.itiket.entity.Lugar;
import com.itiket.service.IConciertoService;
import com.itiket.service.ILugarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author User
 */
@Controller
public class ConciertoController {

    @Autowired
    private IConciertoService conciertoService;

    @Autowired
    private ILugarService lugarService;

    @GetMapping("/concierto")
    public String index(Model model) {
        List<Concierto> listaConcierto = conciertoService.getAllConcierto();
        model.addAttribute("tituloVisualizacion", "Siguientes tandas");
        model.addAttribute("tituloArtistas", "Próximos Estrenos");
        model.addAttribute("concierto", listaConcierto);
        return "concierto";
    }

    @GetMapping("/conciertoN")
    public String crearConcierto(Model model) {
        List<Lugar> listaLugar = lugarService.listLugar();
        model.addAttribute("concierto", new Concierto());
        model.addAttribute("lugar", listaLugar);
        return "crear";
    }

    @GetMapping("/CrearConcierto")
    public String nuevoConcierto(Concierto concierto) {
        return "modificarConcierto";
    }

    @PostMapping("/GuardarConcierto")
    public String GuardarConcierto(Concierto concierto) {
        conciertoService.saveConcierto(concierto);
        return "redirect:/";
    }

    @GetMapping("/editConcierto/{id}")
    public String modificarConcierto(Concierto concierto, Model model) {
        concierto = conciertoService.getConcierto(concierto);
        model.addAttribute("concierto", concierto);
        return "modificarConcierto";
    }

    @GetMapping("/delete/{id}")
    public String delete(Concierto concierto, Model model) {
        conciertoService.delete(concierto);
        return "redirect:/";
    }
}
