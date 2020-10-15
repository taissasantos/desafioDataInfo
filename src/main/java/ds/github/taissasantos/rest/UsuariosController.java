package ds.github.taissasantos.rest;


import ds.github.taissasantos.model.entity.Usuarios;
import ds.github.taissasantos.model.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuariosController {

    private final UsuariosRepository repository;

    @Autowired
    public UsuariosController(UsuariosRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios save( @RequestBody Usuarios usuarios){
        return repository.save(usuarios);
    }

    @GetMapping("{id}")
    public Usuarios findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @GetMapping()
    public List<Usuarios> list (){
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        repository.findById(id)
                .map( usuarios -> {
                    repository.delete(usuarios);
                    return Void.TYPE;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void update(@PathVariable @Valid Integer id, @RequestBody Usuarios usuariosAtualizados){
        repository.findById(id)
                .map( usuario -> {
                    usuariosAtualizados.setId(usuario.getId());
                    return  repository.save(usuariosAtualizados);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }


}
