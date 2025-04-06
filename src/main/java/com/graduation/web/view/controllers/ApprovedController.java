package com.graduation.web.view.controllers;

import com.graduation.data.entity.Approved;
import com.graduation.data.entity.Request;
import com.graduation.dto.ApprovedDTO;
import com.graduation.dto.RequestDTO;
import com.graduation.services.ApprovedService;
import com.graduation.services.RequestService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/approveds")
public class ApprovedController {

    private final ApprovedService approvedService;
    private final ModelMapper modelMapper;
    private final RequestService requestService;





    @GetMapping
    public String getApproveds(Model model) {
        final List <ApprovedDTO> approveds = approvedService.getApproveds();

        model.addAttribute("approveds", approveds);
        return "approveds/approveds";
    }

    //SPECIFIC
    //Unapproved requests
    @GetMapping("/approve-requests")
    public String getApproveRequests(Model model) {
        final List<RequestDTO> unapprovedRequests = approvedService.findNotApproved();

        model.addAttribute("unapprovedRequests", unapprovedRequests);
        return "approveds/approve-requests";
    }



    //Approve a given request
    //@ModelAttribute("unapprovedRequest") Request request,
    @GetMapping("/approve-request/{id}")
    public String approveRequest(@PathVariable Long id) {

        ApprovedDTO approved = new ApprovedDTO();

        RequestDTO requestDTO = requestService.getRequest(id);


        approved.setTitle(requestDTO.getTitle() );
        approved.setDate(LocalDate.now() );
        approved.setRequest( modelMapper.map(requestDTO, Request.class) );


        approvedService.create(approved );

        return "redirect:/approveds";
    }



    //Search approved by lecturer ID
    @GetMapping("lecturer-search/{lecturerId}")
    public String showSearchByLecturerForm(Model model, @PathVariable Long lecturerId) {
        final List<ApprovedDTO> approved = approvedService.findByRequestLecturerId(lecturerId);

        model.addAttribute("approveds", approved);
        return "approveds/approveds";
    }


    @GetMapping("date-search/date1/{date1}/date2/{date2}")
    public String getApproveds(Model model,
                               @PathVariable("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date1,
                               @PathVariable("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date2) {


        final List <ApprovedDTO> approveds = approvedService.findByDateBetween(date1, date2);


        model.addAttribute("approveds", approveds);
        return "approveds/approveds";
    }

    /*
    @GetMapping("/create-approved")
    public String showCreateApprovedForm(Model model) {
        model.addAttribute("approved", new ApprovedDTO());

        return "/approveds/create-approved";
    }

    @GetMapping("/edit-approved/{id}")
    public String showEditApprovedForm(Model model, @PathVariable Long id) {
        model.addAttribute("approved", modelMapper.map(approvedService.getApproved(id),
                ApprovedDTO.class));
        return "/approveds/edit-approved";
    }


    @PostMapping("/create")
    public String createApproved(@ModelAttribute("approved") ApprovedDTO approved) {

        approvedService.create(modelMapper.map(approved, ApprovedDTO.class));
        return "redirect:/approveds";
    }


    @PostMapping("/update/{id}")
    public String updateApproved(@PathVariable long id, @ModelAttribute("approved") ApprovedDTO approved) {

        approvedService.updateApproved(id, modelMapper.map(approved, ApprovedDTO.class));
        return "redirect:/approveds";
    }


    @GetMapping("/delete/{id}")
    public String deleteApproved(@PathVariable int id) {
        approvedService.deleteApproved(id);
        return "redirect:/approveds";
    }
     */
}
