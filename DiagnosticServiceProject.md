
# Compréhension du Problème

Le système doit traiter un index de santé pour diagnostiquer des pathologies. Nous allons développer un microservice en Java qui répond à cette exigence.

## Spécifications Fonctionnelles

- **Input**: Un entier représentant l’index de santé.
- **Output**: Une chaîne de caractères représentant les unités médicales concernées.

## Spécifications Exécutables

### Fonction: Diagnostic des pathologies

#### Scenario: Problème cardiaque
- **Given** un index de santé de 33
- **When** je demande un diagnostic
- **Then** le résultat doit être "Cardiologie"

#### Scenario: Fracture
- **Given** un index de santé de 55
- **When** je demande un diagnostic
- **Then** le résultat doit être "Traumatologie"

#### Scenario: Problèmes multiples
- **Given** un index de santé de 15
- **When** je demande un diagnostic
- **Then** le résultat doit être "Cardiologie, Traumatologie"

#### Scenario: Aucune pathologie
- **Given** un index de santé de 7
- **When** je demande un diagnostic
- **Then** le résultat doit être "Aucune pathologie détectée"

---

# Mise en œuvre avec TDD

Nous suivons l'approche **Test Driven Development (TDD)**. Cela signifie que nous allons d'abord écrire les tests pour nos fonctionnalités, puis implémenter la logique qui les fait passer.

## Écriture des Tests

Voici les tests que nous allons utiliser pour vérifier les différents scénarios :

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiagnosticServiceTest {

    private final DiagnosticService diagnosticService = new DiagnosticService();

    @Test
    void testCardiologie() {
        String result = diagnosticService.diagnostiquer(33);
        assertEquals("Cardiologie", result);
    }

    @Test
    void testTraumatologie() {
        String result = diagnosticService.diagnostiquer(55);
        assertEquals("Traumatologie", result);
    }

    @Test
    void testMultiplePathologies() {
        String result = diagnosticService.diagnostiquer(15);
        assertEquals("Cardiologie, Traumatologie", result);
    }

    @Test
    void testAucunePathologie() {
        String result = diagnosticService.diagnostiquer(7);
        assertEquals("Aucune pathologie détectée", result);
    }
}
```

## Implémentation du Service

Après avoir défini les tests, développons la logique métier dans le service **DiagnosticService**. Ce service va analyser l'index de santé pour déterminer quelles pathologies sont présentes.

```java
public class DiagnosticService {

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
```

---

## Comment exécuter les tests

1. Assurez-vous d'avoir configuré un projet Maven ou Gradle avec JUnit pour les tests unitaires.
2. Placez les fichiers `DiagnosticServiceTest.java` et `DiagnosticService.java` dans leur répertoire approprié.
3. Exécutez les tests à partir de votre IDE ou via la ligne de commande avec Maven/Gradle :

### Pour Maven :
```bash
mvn test
```

### Pour Gradle :
```bash
gradle test
```

Les tests doivent passer avec succès, ce qui confirme que la fonctionnalité est correctement implémentée.
