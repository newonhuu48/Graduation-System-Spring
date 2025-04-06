package com.graduation.web.api;

import com.graduation.data.entity.Approved;
import com.graduation.dto.ApprovedDTO;
import com.graduation.services.ApprovedService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Web pages should be with
//@Controller

@RestController
@AllArgsConstructor
public class ApprovedApiController {

    private ApprovedService approvedService;


    //Create, Read , Update, Delete
    @GetMapping(value = "/api/approveds")
    public List<ApprovedDTO> getApproveds() {

        return approvedService.getApproveds();
    }

    /*
    @RequestMapping("/api/approveds/{id}")
    public Approved getApproved(@PathVariable("id") long id) {

        return approvedService.getApproved(id);
    }


    @PostMapping(value = "/api/approveds")
    public Approved createApproved(@RequestBody Approved approved) {

        return approvedService.create(approved);
    }


    @PutMapping(value = "/api/approveds/{id}")
    public Approved updateApproved(@PathVariable("id") long id, @RequestBody Approved approved) {

        return approvedService.updateApproved(id, approved);
    }


    @DeleteMapping(value = "/api/approveds/{id}")
    public void deleteApproved(@PathVariable("id") long id) {
        approvedService.deleteApproved(id);
    }



    //Specific Queries
    @RequestMapping("/api/approveds/titleContaining/{substr}")
    public List<Approved> getApprovedsByTitleContaining(@PathVariable("substr") String substr) {
        return approvedService.findAllByTitleContaining(substr);
    }


    @RequestMapping("/api/approveds/requestId/{id}")
    public Approved getApprovedByRequestId(@PathVariable("id") long id) {
        return approvedService.findByRequestId(id);
    }


    @RequestMapping("/api/approveds/lecturerId/{id}")
    public Approved getApprovedByLecturerId(@PathVariable("id") long id) {
        return approvedService.findByLecturerId(id);
    }


    */

}
