package com.graduation.services;


import com.graduation.data.entity.Approved;
import com.graduation.data.entity.Request;
import com.graduation.data.repository.ApprovedRepository;
import com.graduation.dto.ApprovedDTO;
import com.graduation.dto.RequestDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApprovedService {

    private final ApprovedRepository approvedRepository;
    private final ModelMapper modelMapper;



    public List<ApprovedDTO> getApproveds() {
        return approvedRepository.findAll().stream()
                .map(this::convertToApprovedDTO)
                .collect(Collectors.toList());
    }

    private ApprovedDTO convertToApprovedDTO(Approved approved) {
        return modelMapper.map(approved, ApprovedDTO.class);
    }

    private RequestDTO convertToRequestDTO(Request request) {
        return modelMapper.map(request, RequestDTO.class);
    }

    //SPECIFIC
    //Find all not yet approved requests
    public List<RequestDTO> findNotApproved() {
        return approvedRepository.findNotApproved().stream()
                .map(this::convertToRequestDTO).
                collect(Collectors.toList());
    }



    public Approved create(ApprovedDTO ApprovedDTO) {
        return approvedRepository.save(modelMapper.map(ApprovedDTO, Approved.class));
    }


    public List<ApprovedDTO> findByRequestLecturerId(long id) {
        return approvedRepository.findByRequest_Lecturer_Id(id).stream()
                .map(this::convertToApprovedDTO)
                .collect(Collectors.toList());
    }


    public List<ApprovedDTO> findByDateBetween(LocalDate date1, LocalDate date2) {
        return approvedRepository.findAllByDateBetween(date1, date2).stream()
                .map(this::convertToApprovedDTO)
                .collect(Collectors.toList());
    }


    /*
    DO I EVEN NEED THESE???
    public ApprovedDTO getApproved(long id) {
        return modelMapper.map(approvedRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid approved Id:" + id)), ApprovedDTO.class);
    }


    public Approved create(ApprovedDTO ApprovedDTO) {
        return approvedRepository.save(modelMapper.map(ApprovedDTO, Approved.class));
    }


    public Approved updateApproved(long id, ApprovedDTO approvedDTO) {
        Approved approved = modelMapper.map(approvedDTO , Approved.class);
        approved.setId(id);
        return approvedRepository.save(approved);
    }


    public void deleteApproved(long id) {
        approvedRepository.deleteById(id);
    }
     */



}
