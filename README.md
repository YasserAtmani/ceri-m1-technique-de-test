[![CircleCI](https://circleci.com/gh/YasserAtmani/ceri-m1-technique-de-test/tree/master.svg?style=svg)](https://circleci.com/gh/YasserAtmani/ceri-m1-technique-de-test/tree/master)
[![codecov](https://codecov.io/gh/YasserAtmani/ceri-m1-technique-de-test/branch/master/graph/badge.svg?token=1M4UOO0P5E)](https://codecov.io/gh/YasserAtmani/ceri-m1-technique-de-test)
![Checkstyle](target/site/badges/checkstyle-result.svg)

# UCE Génie Logiciel Avancé : Techniques de tests

ATMANI Yasser, M1 ILSEN Classique Groupe 1

## Javadoc

Lien de la javadoc [ici](https://yasseratmani.github.io/ceri-m1-technique-de-test/fr/univavignon/pokedex/api/package-summary.html).

## Rapport RocketPokemonFactory

- Checkstyle trouve 21 erreurs
- Un pokemon peut être crée même si l'index est en dehors de l'ensemble [0,150] , aucune exception n'est levée
- Les IV récupérés ne sont pas les bons car ils ne sont pas calculés et gérés comme il faudrait à la création