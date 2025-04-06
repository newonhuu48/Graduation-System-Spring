package com.graduation.web.api;

import com.graduation.data.entity.Request;
import com.graduation.dto.RequestDTO;
import com.graduation.services.RequestService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Web pages should be with
//@Controller

@RestController
@AllArgsConstructor
public class RequestApiController {

    private RequestService requestService;

    @RequestMapping("/api/requests/titleContaining/{substr}")
    public List<RequestDTO> getRequestsByTitleContaining(@PathVariable("substr") String substr) {
        return requestService.findAllByTitleContaining(substr);
    }


    @GetMapping(value = "/api/requests")
    public List<RequestDTO> getRequests() {

        return requestService.getRequests();
    }


    @RequestMapping("/api/requests/{id}")
    public RequestDTO getRequest(@PathVariable("id") long id) {

        return requestService.getRequest(id);
    }

    /*
    @PostMapping(value = "/api/requests")
    public Request createRequest(@RequestBody Request request) {

        return requestService.create(request);
    }


    @PutMapping(value = "/api/requests/{id}")
    public Request updateRequest(@PathVariable("id") long id, @RequestBody Request request) {

        return requestService.updateRequest(id, request);
    }


    @DeleteMapping(value = "/api/requests/{id}")
    public void deleteRequest(@PathVariable("id") long id) {
        requestService.deleteRequest(id);
    }


    @RequestMapping("/api/requests/titleContaining/{substr}")
    public List<Request> getRequestsByTitleContaining(@PathVariable("substr") String substr) {
        return requestService.findAllByTitleContaining(substr);
    }


    @RequestMapping("/api/requests/studentId/{id}")
    public Request getRequestByStudentId(@PathVariable("id") long id) {
        return requestService.findByStudentId(id);
    }

    /*
    @RequestMapping("/api/requests/lecturerId/{id}")
    public Request getRequestByLecturerId(@PathVariable("id") long id) {
        return requestService.findBLecturerId(id);
    }

     */
}
