
# Compréhension du Problème

Le système doit traiter un index de santé afin de diagnostiquer des pathologies. Pour répondre à cette exigence, un microservice en Java a été développé.

## Spécifications Fonctionnelles

- **Entrée** : Un entier représentant l’index de santé.
- **Sortie** : Une chaîne de caractères indiquant les unités médicales concernées.

## Spécifications Exécutables

### Fonction : Diagnostic des pathologies

#### Scénario : Problème cardiaque
- **Étant donné** un index de santé de 33
- **Lorsque** je demande un diagnostic
- **Alors** le résultat doit être "Cardiologie"

#### Scénario : Fracture
- **Étant donné** un index de santé de 55
- **Lorsque** je demande un diagnostic
- **Alors** le résultat doit être "Traumatologie"

#### Scénario : Problèmes multiples
- **Étant donné** un index de santé de 15
- **Lorsque** je demande un diagnostic
- **Alors** le résultat doit être "Cardiologie, Traumatologie"

#### Scénario : Aucune pathologie
- **Étant donné** un index de santé de 7
- **Lorsque** je demande un diagnostic
- **Alors** le résultat doit être "Aucune pathologie détectée"

---

# Mise en œuvre avec TDD

L'approche Test Driven Development (TDD) est adoptée, ce qui signifie qu'il est nécessaire de rédiger d'abord les tests pour les fonctionnalités avant d'implémenter la logique nécessaire pour les valider.

## Rédaction des Tests

Voici les tests qui seront utilisés pour vérifier les différents scénarios :


```java
package com.guriani.health_index.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Classe de test pour le service de diagnostic.
 * Vérifie que la logique de diagnostic fonctionne comme prévu.
 */
public class DiagnosticServiceTest {

    private final IDiagnosticService diagnosticService = new DiagnosticService();

    /**
     * Test pour vérifier le diagnostic d'un problème cardiaque.
     * Un index de santé de 33 doit retourner "Cardiologie".
     */
    @Test
    void testCardiologie() {
        String result = diagnosticService.diagnostiquer(33);
        assertEquals("Cardiologie", result);
    }

    /**
     * Test pour vérifier le diagnostic d'une fracture.
     * Un index de santé de 55 doit retourner "Traumatologie".
     */
    @Test
    void testTraumatologie() {
        String result = diagnosticService.diagnostiquer(55);
        assertEquals("Traumatologie", result);
    }

    /**
     * Test pour vérifier le diagnostic de plusieurs pathologies.
     * Un index de santé de 15 doit retourner "Cardiologie, Traumatologie".
     */
    @Test
    void testMultiplePathologies() {
        String result = diagnosticService.diagnostiquer(15);
        assertEquals("Cardiologie, Traumatologie", result);
    }

    /**
     * Test pour vérifier qu'aucune pathologie n'est détectée.
     * Un index de santé de 7 doit retourner "Aucune pathologie détectée".
     */
    @Test
    void testAucunePathologie() {
        String result = diagnosticService.diagnostiquer(7);
        assertEquals("Aucune pathologie détectée", result);
    }
}
```

## Implémentation du Service

Après la définition des tests, la logique métier a été développée dans le service DiagnosticService. Ce service analyse l'index de santé pour déterminer les pathologies présentes en utilisant l'énumération Pathology.

```java
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
```

### Énumération des Pathologies
Une énumération Pathology a également été créée pour représenter les différentes pathologies avec leur multiple associé. Pour ajouter de nouvelles pathologies, il suffira de modifier uniquement ce fichier.

```java
package com.guriani.health_index.model;

/**
 * Enum représentant les différentes pathologies avec leur multiple associé.
 */
public enum Pathology {
    CARDIOLOGY("Cardiologie", 3),
    TRAUMATOLOGY("Traumatologie", 5);

    private final String displayName;
    private final int multiple;

    Pathology(String displayName, int multiple) {
        this.displayName = displayName;
        this.multiple = multiple;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getMultiple() {
        return multiple;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

---

## Exécution des Tests

Pour exécuter les tests, utilisez la commande suivante :

```bash
mvn test
```

---
