package ge.ibsu.demo.services;


import ge.ibsu.demo.dto.AddCity;
import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.repositories.CityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;


    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAll(){
        return cityRepository.findAll();
    }

    public City getCityById(Long id){
        return cityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("CITY_NOT_FOUND"));
    }

    @Transactional
    public City getCity(AddCity addCity){

        City city = cityRepository.findOneByCity(addCity.getCity());

        if(city != null){
            return city;
        }

        city = new City();

        city.setCity(addCity.getCity());

        return cityRepository.save(city);
    }

    public City addEditCity(AddCity addCity, Long id){

        City city = new City();

        city.setCity(addCity.getCity());

        return  cityRepository.save(city);

    }



}
