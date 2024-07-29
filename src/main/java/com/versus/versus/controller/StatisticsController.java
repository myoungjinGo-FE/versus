package com.versus.versus.controller;

import com.versus.versus.domain.entity.Snack;
import com.versus.versus.domain.entity.SnackStatistics;
import com.versus.versus.domain.entity.SnackVersus;
import com.versus.versus.domain.service.SnackVersusService;
import com.versus.versus.domain.service.StatisticsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    private static final Logger log = LoggerFactory.getLogger(StatisticsController.class);
    @Autowired
    StatisticsService statisticsService;

    @Autowired
    SnackVersusService snackVersusService;

    @GetMapping()
    public String showStatistics(
            @ModelAttribute("statistics") Map<Snack, SnackStatistics> snackStatistics,
            Model model
    ) {
        model.addAttribute("statistics", snackStatistics);
        return "statistics";
    }

    @GetMapping("/{versusId}")
    public String showStatistics(
            @PathVariable("versusId") Integer versusId,
            RedirectAttributes redirectAttributes
    ) throws SQLException {
        SnackVersus snackVersus = snackVersusService.getSnackVersus(versusId);
        Map<Snack, SnackStatistics> snackStatistics = new HashMap<>();
        for (Snack snack : snackVersus.getSnacks()) {
            SnackStatistics statistics = statisticsService.getVoteStatistics(snack.getId(), versusId);
            snackStatistics.put(snack, statistics);
        }
        redirectAttributes.addFlashAttribute("statistics", snackStatistics);
        return "redirect:/statistics";
    }
}
