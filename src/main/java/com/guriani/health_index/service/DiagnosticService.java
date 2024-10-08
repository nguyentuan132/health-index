package com.guriani.health_index.service;

import com.guriani.health_index.model.Pathology;
import java.util.ArrayList;
import java.util.List;

/**
 * Service de diagnostic pour déterminer les pathologies en fonction de l'index
 * de santé.
 */
public class DiagnosticService implements IDiagnosticService {

    /**
     * Diagnostique les pathologies basées sur l'index de santé fourni.
     * 
     * @param indexSante L'index de santé à évaluer.
     * @return Une chaîne de caractères représentant les unités médicales
     *         concernées,
     *         ou un message indiquant qu'aucune pathologie n'est détectée.
     */
    @Override
    public String diagnostiquer(int indexSante) {
        List<String> result = new ArrayList<>();

        // Parcourt toutes les pathologies et vérifie si l'index correspond
        for (Pathology pathology : Pathology.values()) {
            if (indexSante % pathology.getMultiple() == 0) {
                result.add(pathology.getDisplayName());
            }
        }

        // Retourne le résultat ou un message d'absence de pathologie
        return result.isEmpty() ? "Aucune pathologie détectée" : String.join(", ", result);
    }
}
