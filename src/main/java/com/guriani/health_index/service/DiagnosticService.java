package com.guriani.health_index.service;

public class DiagnosticService implements IDiagnosticService {

    @Override
    public String diagnostiquer(int indexSante) {
        StringBuilder result = new StringBuilder();

        if (indexSante % 3 == 0) {
            result.append("Cardiologie");
        }

        if (indexSante % 5 == 0) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append("Traumatologie");
        }

        return result.length() > 0 ? result.toString() : "Aucune pathologie détectée";
    }
}
