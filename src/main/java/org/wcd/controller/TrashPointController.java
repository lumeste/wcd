package org.wcd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wcd.Repository.TrashPointRepository;
import org.wcd.Service.TrashPointService;
import org.wcd.model.TrashPoint;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/trashpoint")
public class TrashPointController {

    private final TrashPointRepository trashPointRepository;
    private final TrashPointService trashPointService;

    @Autowired
    public TrashPointController(TrashPointRepository trashPointRepository,
                                TrashPointService trashPointService) {
        this.trashPointRepository = trashPointRepository;
        this.trashPointService = trashPointService;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<TrashPoint> getTrashPoint() {
        return this.trashPointRepository.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public String getTrashPoint(@PathVariable("id") BigInteger id, Model model) {

        TrashPoint trashPoint = trashPointService.findTrashPointById(id);
        model.addAttribute(trashPoint);
        return "trashpoint-details";
    }

    @RequestMapping(value = "/addtrashpoint", method=RequestMethod.POST)
    public String createTrashpoint(@RequestBody TrashPoint trashpoint,
                                   BindingResult result,
                                   RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "country-edit";
        }

        TrashPoint savedTrashPoint = trashPointService.saveTrashPoint(trashpoint);
        redirectAttributes.addFlashAttribute("msg", String.format("Trash Point '%s' added successfully", trashpoint.getName()));
        return "redirect:/trashpoint/all" + savedTrashPoint.getId();
    }

}
