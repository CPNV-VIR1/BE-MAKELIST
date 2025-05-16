# Task 002 - New feature - date of birth

## Objectif

Il s'agit d'enrichir fonctionnellement la ressource "employee" en lui ajoutant
une date de naissance ainsi que son âge.

---

## Part I - Date of birth

Il vous est demandé d'ajouter la notion de date de naissance à un employé.

Cet attribut est :
* Obligatoire dès la création de l'employée (et non nul).
* Persistant durant tout le cycle de vie de l'objet.
* Une modification de cette date n'est pas possible.
* Doit être pris en compte pour garder une cohérence de données dans différentes méthodes de la classe.
* [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html) : importer ce type pour voir gérer le type date simplement
* Constructeur : prend en paramètre un *string* formaté ainsi "yyyy-MM-dd". Voici la signature à implémenter:

```plantuml
    + Employee(name:string, role:string, birthdate:string){}
```

* LoadDataBase : voici comment créer un employé lors du lancement de l'application :

```java
    log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar", "2000-06-30")));
```

* Le *setter* sera responsable de convertir le "dateString" en date. Voici le corps de la méthode à implémenter :

```java
    this.birthDate = LocalDate.parse(stringDate);
```

## Etat final recherché

```json
  {
    "id": 1,
    "name": "Bilbo Baggins",
    "role": "BURGLAR",
    "birthDate": "2000-06-30"
  }
```

* Optionnel

Si vous n'arrivez pas à implémenter cette fonctionnalité, vous pourrez pour la suite du développement "hard coded" la
date de naissance de l'employé comme suit :

```java
    LocalDate localDate = LocalDate.of(2000,4,30);
```

---

## Part II - Age

Il vous est demandé d'ajouter la notion d'âge à un employé.

Cet attribut est :

* Obligatoire et non nul
* Doit être calculé qu'à la demande (computed property).
* La signature du "getter" retournant la date est la suivante :
```plantuml
    + <get>age():int
```

* La méthode à utiliser pour obtenir l'âge actuel de votre employé

```java
    return Period.between(this.birthDate, LocalDate.now()).getYears();
```

## Etat final recherché

Le résultat attendu est le suivant :

```
  {
    "id": 1,
    "name": "Bilbo Baggins",
    "role": "BURGLAR",
    "birthDate": "2000-06-30",
    "age": 24                                       --> new feature
  }
```