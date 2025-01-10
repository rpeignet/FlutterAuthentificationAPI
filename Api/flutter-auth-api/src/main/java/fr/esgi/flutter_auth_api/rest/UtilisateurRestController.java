package fr.esgi.flutter_auth_api.rest;

import fr.esgi.flutter_auth_api.business.Utilisateur;
import fr.esgi.flutter_auth_api.dto.response.UtilisateurResponseDTO;
import fr.esgi.flutter_auth_api.mapper.UtilisateurMapper;
import fr.esgi.flutter_auth_api.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurRestController {
    private final UtilisateurService utilisateurService;
    private final UtilisateurMapper utilisateurMapper;

    public UtilisateurRestController(UtilisateurService utilisateurService, UtilisateurMapper utilisateurMapper) {
        this.utilisateurService = utilisateurService;
        this.utilisateurMapper = utilisateurMapper;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UtilisateurResponseDTO create(@RequestBody Utilisateur utilisateur){
        return utilisateurMapper.toResponseDTO(this.utilisateurService.create(utilisateur));
    }

    @GetMapping
    @ResponseStatus(code=HttpStatus.OK)
    public List<UtilisateurResponseDTO> findAll(){
        return utilisateurService.findAll().stream().map(utilisateurMapper::toResponseDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code=HttpStatus.OK)
    public UtilisateurResponseDTO findById(@PathVariable Long id) throws Exception {
        return utilisateurMapper.toResponseDTO(utilisateurService.findById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(code=HttpStatus.OK)
    public UtilisateurResponseDTO update(@PathVariable Long id, @RequestBody Utilisateur utilisateur){
        return utilisateurMapper.toResponseDTO(utilisateurService.update(id, utilisateur));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        utilisateurService.delete(id);
    }
}
