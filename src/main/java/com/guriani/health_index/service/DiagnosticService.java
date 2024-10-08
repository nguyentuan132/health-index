package com.guriani.health_index.service;

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
        StringBuilder result = new StringBuilder();

        // Vérifie si l'index de santé indique un problème cardiaque
        if (indexSante % 3 == 0) {
            result.append("Cardiologie");
        }

        // Vérifie si l'index de santé indique une fracture
        if (indexSante % 5 == 0) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append("Traumatologie");
        }

        // Retourne le résultat ou un message d'absence de pathologie
        return result.length() > 0 ? result.toString() : "Aucune pathologie détectée";
    }
}
