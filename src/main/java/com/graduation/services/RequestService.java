package com.graduation.services;

import com.graduation.data.entity.Request;
import com.graduation.data.repository.RequestRepository;
import com.graduation.dto.RequestDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;
    private final ModelMapper modelMapper;



    public List<RequestDTO> getRequests() {
        return requestRepository.findAll()
                .stream()
                .map(this::convertToRequestDTO)
                .collect(toList());

    }

    private RequestDTO convertToRequestDTO(Request request) {
        return modelMapper.map(request, RequestDTO.class);
    }


    public RequestDTO getRequest(long id) {
        return modelMapper.map(requestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid request Id:" + id)), RequestDTO.class);
    }


    public Request create(RequestDTO RequestDTO) {
        return requestRepository.save(modelMapper.map(RequestDTO, Request.class));
    }


    public Request updateRequest(long id, RequestDTO requestDTO) {
        Request request = modelMapper.map(requestDTO, Request.class);
        request.setId(id);
        return requestRepository.save(request);
    }


    public void deleteRequest(long id) {
        requestRepository.deleteById(id);
    }

    //SPECIFIC

    public List<RequestDTO> findAllByTitleContaining(String substr) {
        return requestRepository.findAllByTitleContaining(substr)
                .stream()
                .map(this::convertToRequestDTO)
                .collect(Collectors.toList());

    }



    public Request findByStudentId(long id) {
        return requestRepository.findByStudent_Id(id);
    }



    public Request findByLecturerId(long id) {
        return requestRepository.findByLecturer_Id(id);
    }


    /*
    public Request getRequest(long id) {
        //Optional<Request> request = requestRepository.findById(id);

        return requestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid request id: " + id));
    }



    public Request create(Request request) {
        return requestRepository.save(request);
    }



    public Request updateRequest(long id, Request request) {
        request.setId(id);
        return requestRepository.save(request);
    }



    public void deleteRequest(long id) {

        requestRepository.deleteById(id);
    }









    */
}
