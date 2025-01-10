package fr.esgi.flutter_auth_api.mapper;

import fr.esgi.flutter_auth_api.business.Utilisateur;
import fr.esgi.flutter_auth_api.dto.request.UtilisateurRequestDTO;
import fr.esgi.flutter_auth_api.dto.response.UtilisateurResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface UtilisateurMapper {
    public Utilisateur toEntity(UtilisateurRequestDTO utilisateurRequestDTO);
    public UtilisateurResponseDTO toResponseDTO(Utilisateur utilisateur);
}
