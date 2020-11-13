package payroll.Manager;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    private final ManagerRepository repository;
    private ManagerModelAssembler assembler;
    
    ManagerController(ManagerRepository repository, ManagerModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
        
    }

    // Aggregate root

    @GetMapping("/Managers")
    CollectionModel<Manager> all() {
        List<Manager> Managers = new ArrayList<Manager>();
        repository.findAll().forEach(m-> Managers.add(m));


        return CollectionModel.of(Managers, linkTo(methodOn(ManagerController.class).all()).withSelfRel());
    }

    @PostMapping("/Managers")
    ResponseEntity<?> newManager(@RequestBody Manager newManager) {
        EntityModel<Manager> entityModel = assembler.toModel(repository.save(newManager));

        return ResponseEntity 
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) 
                .body(entityModel);
    }

    // Single item
    @GetMapping("/Managers/{id}")
    EntityModel<Manager> one(@PathVariable Long id) {

        Manager Manager = repository.findById(id) //
                .orElseThrow(() -> new ManagerNotFoundException(id));

        return assembler.toModel(Manager);
    }

    @PutMapping("/Managers/{id}")
    ResponseEntity<?> replaceManager(@RequestBody Manager newManager, @PathVariable Long id) {

        Manager updatedManager = repository.findById(id)
                .map(Manager -> {
                    Manager.setName(newManager.getName());
                    Manager.setRole(newManager.getRole());
                    return repository.save(Manager);
                })
                .orElseGet(() -> {
                    newManager.setId(id);
                    return repository.save(newManager);
                });
        
        EntityModel<Manager> entityModel = assembler.toModel(updatedManager);
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
        
    }

    @DeleteMapping("/Managers/{id}")
    ResponseEntity<?> deleteManager(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}