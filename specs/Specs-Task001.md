# Task 001 - Bug fix

## Objectif
Forcer la valeur du rôle en majuscule dans le retour JSON de l'api.

## Etat actuel

Dans le retour JSON présenté ci-dessous, nous observons un attribut "role".

La valeur qui est mentionnée, selon le Cdc, devait être en majuscule. Il s'agit donc d'une erreur de notre part.

## Etat final recherché

Voici le résultat attendu après correction :

```
[
    {
        "id": 1,
        "name": "Bilbo Baggins",
        "role": "BURGLAR"                    --> fix
    },
    {
        "id": 2,
        "name": "Frodo Baggins",
        "role": "THIEF"                      --> fix
    }
]
```