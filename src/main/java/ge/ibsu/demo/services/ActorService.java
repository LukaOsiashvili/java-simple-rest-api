package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.AddActor;
import ge.ibsu.demo.dto.Paging;
import ge.ibsu.demo.dto.Search;
import ge.ibsu.demo.entities.Actor;
import ge.ibsu.demo.entities.Address;
import ge.ibsu.demo.entities.Customer;
import ge.ibsu.demo.repositories.ActorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;
    private final AddressService addressService;


    @Autowired
    public ActorService(ActorRepository actorRepository, AddressService addressService){
        this.actorRepository = actorRepository;
        this.addressService = addressService;
    }

    public List<Actor> getAll(){
        return  actorRepository.findAll();
    }

    public Actor getActorById(Long id){
        return actorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ACTOR_NOT_FOUND"));
    }

    @Transactional
    public Actor addEditActor(AddActor addActor, Long id){

        Actor actor = new Actor();

        if(id != null){
            actor = getActorById(id);
        }

        actor.setFirstName((addActor.getFirstName()));
        actor.setLastName((addActor.getLastName()));
        actor.setActive((addActor.getActive()));

        Address address = addressService.getByAddress(addActor.getAddress());
        actor.setAddress(address);

        return  actorRepository.save(actor);
    }

    @Transactional
    public Boolean deleteActor(Long id){
        Actor actor = getActorById(id);
        actorRepository.delete(actor);
        return true;
    }

    public Page<Actor> search(Search search, Paging paging){
        String searchText = search.getSearchText() != null ? "%" + search.getSearchText() + "%" : "";
        Pageable pageable = PageRequest.of(paging.getPage() - 1, paging.getSize(), Sort.by("id").ascending());
        return  actorRepository.search(search.getActive(), searchText, pageable);
    }

}
