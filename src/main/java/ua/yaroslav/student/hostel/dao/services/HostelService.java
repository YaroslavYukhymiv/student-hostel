package ua.yaroslav.student.hostel.dao.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ua.yaroslav.student.hostel.dao.entity.Hostel;
import ua.yaroslav.student.hostel.dao.repositories.HostelRepository;

import java.util.List;

@Service
public class HostelService {

//    @Autowired("HostelCustomRepository")
//    private HostelCustomRepository hostelCustomRepository;

    Logger logger = LoggerFactory.getLogger(HostelService.class);

    @Autowired
    private HostelRepository hostelRepository;

    public List<Hostel> hostelList() {
        logger.debug("Was found all hostels");
        return (List<Hostel>) hostelRepository.findAll();
    }
    public Hostel findByName(String name){
        logger.debug("Was found hostel: " + name);
        return hostelRepository.findByName(name);
    }
    public Hostel saveHostel(Hostel hostel){
        logger.debug("Was saved hostel: " + hostel);
        return hostelRepository.save(hostel);
    }


//    public List<Hostel> getHostelByName(String name){
//        return hostelRepository.hostelByName(name);
//    }
}
