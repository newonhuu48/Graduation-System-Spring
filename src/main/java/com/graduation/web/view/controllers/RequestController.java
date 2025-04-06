package com.graduation.web.view.controllers;

import com.graduation.data.entity.Request;
import com.graduation.dto.RequestDTO;
import com.graduation.services.RequestService;
import com.graduation.services.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/requests")
public class RequestController {

    private final RequestService requestService;
    private final ModelMapper modelMapper;





    @GetMapping
    public String getRequests(Model model) {
        final List <RequestDTO> requests = requestService.getRequests();


        model.addAttribute("requests", requests);
        return "requests/requests";
    }

    private Request convertToRequest(RequestDTO requestDTO) {
        return modelMapper.map(requestDTO, Request.class);
    }



    @GetMapping("/create-request")
    public String showCreateRequestForm(Model model) {
        model.addAttribute("request", new RequestDTO());

        return "/requests/create-request";
    }

    @GetMapping("/edit-request/{id}")
    public String showEditRequestForm(Model model, @PathVariable Long id) {
        model.addAttribute("request", modelMapper.map(requestService.getRequest(id),
                RequestDTO.class));
        return "/requests/edit-request";
    }


    @PostMapping("/create")
    public String createRequest(@Valid @ModelAttribute("request") RequestDTO request,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/requests/create-request";
        }

        requestService.create(modelMapper.map(request, RequestDTO.class));
        return "redirect:/requests";
    }

    @PostMapping("/update/{id}")
    public String updateRequest(@PathVariable long id, @Valid @ModelAttribute("request") RequestDTO request,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/requests/edit-request";
        }

        requestService.updateRequest(id, modelMapper.map(request, RequestDTO.class));
        return "redirect:/requests";
    }


    /*
    @PostMapping("/create")
    public String createRequest(@ModelAttribute("request") RequestDTO request) {

        requestService.create(modelMapper.map(request, RequestDTO.class));
        return "redirect:/requests";
    }


    @PostMapping("/update/{id}")
    public String updateRequest(@PathVariable long id, @ModelAttribute("request") RequestDTO request) {

        requestService.updateRequest(id, modelMapper.map(request, RequestDTO.class));
        return "redirect:/requests";
    }
    */


    @GetMapping("/delete/{id}")
    public String deleteRequest(@PathVariable int id) {
        requestService.deleteRequest(id);
        return "redirect:/requests";
    }




    //SPECIFIC
    //Find by title substring
    /*
    //Raboti
    //Sashto v substr-search-form tryabva da se promeni url-a

    @GetMapping("/substr-search/{substr}")
    public String searchBySubstr(Model model, @PathVariable("substr") String substr) {
        final List <RequestDTO> requests = requestService.findAllByTitleContaining(substr);


        model.addAttribute("requests", requests);
        return "requests/requests";
    }
    */


    @GetMapping("/substr-search-form")
    public String showSearchBySubstrForm(Model model) {

        return "requests/substr-search-form";
    }

    @GetMapping("/substr-search/{substr}")
    public String searchBySubstr(Model model, @PathVariable("substr") String substr) {


        final List <RequestDTO> requests = requestService.findAllByTitleContaining(substr);


        model.addAttribute("requests", requests);
        return "requests/requests";
    }
}