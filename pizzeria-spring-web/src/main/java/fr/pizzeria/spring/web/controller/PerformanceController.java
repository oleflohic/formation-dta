package fr.pizzeria.spring.web.controller;

import fr.pizzeria.dao.performance.IPerformanceRepository;
import fr.pizzeria.model.performance.Performance;
import org.apache.commons.lang3.CharSetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

@Controller
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired private IPerformanceRepository performanceRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String viewList(Model model) {
        List<Performance> perfs = performanceRepository.findAll();
        model.addAttribute("performanceList", perfs);
        return "performance/performanceList";
    }

    @RequestMapping(path="/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String delete(@RequestParam("id") Integer performanceId, Model model) {
        performanceRepository.delete(performanceId);
        model.addAttribute("msg", "Performance supprimée");
        return "redirect:/mvc/performance";
    }

    @RequestMapping(path="/deleteall", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String delete(Model model) throws UnsupportedEncodingException {
        performanceRepository.deleteAll();
        model.addAttribute("msg", "Toutes les données sont supprimées");
        return "redirect:/mvc/performance";
    }

}
