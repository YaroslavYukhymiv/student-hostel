package ua.yaroslav.student.hostel.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.yaroslav.student.hostel.entity.Hostel;
import ua.yaroslav.student.hostel.repositories.HostelRepository;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HostelServiceTest {

    @Mock
    private HostelRepository hostelRepository;
    @InjectMocks
    private HostelService hostelService;

    @Test
    public void hostelListTest() {
        hostelService.hostelList();
        verify(hostelRepository).findAll();
    }

    @Test
    public void findByNameTest() {
        hostelService.findByName(anyString());
        verify(hostelRepository).findByName(anyString());
    }

    @Test
    public void saveHostelTest() {
        Hostel hostel = new Hostel();
        hostelService.saveHostel(hostel);
        verify(hostelRepository, times(1)).save(hostel);
    }
}