package ge.ibsu.demo.controllers;


import ge.ibsu.demo.dto.AddActor;
import ge.ibsu.demo.dto.RequestData;
import ge.ibsu.demo.dto.Search;
import ge.ibsu.demo.entities.Actor;
import ge.ibsu.demo.entities.Customer;
import ge.ibsu.demo.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<Actor> getActors(){
        return actorService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Actor getActorByID(@PathVariable Long id){
        return actorService.getActorById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json"})
    public Actor addActor(@RequestBody AddActor addActor){
        return actorService.addEditActor(addActor, null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = {"application/json"})
    public Actor editActor(@RequestBody AddActor addActor, @PathVariable Long id){
        return actorService.addEditActor(addActor, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    public Boolean delete(@PathVariable Long id){
        return actorService.deleteActor(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = {"application/json"})
    public Page<Actor> search(@RequestBody RequestData<Search> rd) throws Exception{
        return actorService.search(rd.getData(), rd.getPaging());
    }

}
