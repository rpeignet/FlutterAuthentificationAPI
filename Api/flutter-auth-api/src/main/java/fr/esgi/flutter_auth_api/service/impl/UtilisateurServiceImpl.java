package fr.esgi.flutter_auth_api.service.impl;

import fr.esgi.flutter_auth_api.business.Utilisateur;
import fr.esgi.flutter_auth_api.repository.UtilisateurRepository;
import fr.esgi.flutter_auth_api.service.UtilisateurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository repository;

    public UtilisateurServiceImpl(UtilisateurRepository repository) {
        this.repository = repository;
    }

    @Override
    public Utilisateur create(Utilisateur utilisateur) {
        return this.repository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Utilisateur findById(Long id){
        Optional<Utilisateur> utilisateur = repository.findById(id);
        if(utilisateur.isPresent()){
            return  utilisateur.get();
        }else{
            throw new RuntimeException("Pas d'utilisateur trouvé");
        }
    }

    @Override
    public Utilisateur update(Long id, Utilisateur utilisateurUpdated) {
        Utilisateur utilisateur = findById(id);
        utilisateur.setEmail(utilisateurUpdated.getEmail());
        utilisateur.setPassword(utilisateurUpdated.getPassword());
        utilisateur.setFirstName(utilisateurUpdated.getFirstName());
        utilisateur.setLastName(utilisateurUpdated.getLastName());
        utilisateur.setRole(utilisateurUpdated.getRole());
        return repository.save(utilisateur);
    }

    @Override
    public void delete(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new RuntimeException("Pas d'utilisateur trouvé");
        }
    }
}
