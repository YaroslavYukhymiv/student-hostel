package ua.yaroslav.student.hostel.dao.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ua.yaroslav.student.hostel.dao.entity.Hostel;
import ua.yaroslav.student.hostel.dao.repositories.HostelRepository;

import java.util.List;

@Service
public class HostelService {

//    @Autowired("HostelCustomRepository")
//    private HostelCustomRepository hostelCustomRepository;

    @Autowired
    private HostelRepository hostelRepository;

    public List<Hostel> hostelList() {
        return (List<Hostel>) hostelRepository.findAll();
    }
    public Hostel findByName(String name){
        return hostelRepository.findByName(name);
    }
    public Hostel saveHostel(Hostel hostel){
        return hostelRepository.save(hostel);
    }


//    public List<Hostel> getHostelByName(String name){
//        return hostelRepository.hostelByName(name);
//    }
}
