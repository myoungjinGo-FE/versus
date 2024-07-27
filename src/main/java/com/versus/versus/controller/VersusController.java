package com.versus.versus.controller;

import com.versus.versus.domain.entity.SnackVersus;
import com.versus.versus.domain.entity.User;
import com.versus.versus.domain.service.SnackVersusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.Map;

@Controller
@RequestMapping("/versus")
public class VersusController {
    @Autowired
    SnackVersusService versusService;

    @GetMapping()
    public String showVersus(
            @ModelAttribute("versus") SnackVersus versus,
            @SessionAttribute("user") User user,
            Model model
    ) {
        model.addAttribute("versus", versus);
        model.addAttribute("user", user);
        return "versus";
    }

    @PostMapping("/{versusId}/vote")
    @ResponseBody
    public void voteForSnack(
            @PathVariable Integer versusId,
            @RequestBody Map<String, String> payload
    ) throws SQLException {
        Integer userId = Integer.parseInt(payload.get("userId"));
        Integer snackId = Integer.parseInt(payload.get("snackId"));
        versusService.voteForSnack(versusId, snackId, userId);
    }

    @GetMapping("/{versusId}")
    public String getVersus(
            @PathVariable("versusId") Integer versusId,
            RedirectAttributes redirectAttributes
    ) throws SQLException {
        SnackVersus snackVersus =  versusService.getSnackVersus(versusId);
        redirectAttributes.addFlashAttribute("versus", snackVersus);
        return "redirect:/versus";
    }


}
