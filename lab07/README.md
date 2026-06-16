**Zadanie 1**

Podpiąć w zakładce przeglądarki [Jakarta Persistence 3.1](https://jakarta.ee/specifications/persistence/3.1/jakarta-persistence-spec-3.1). Znaleźć rozdział `2.11 Relationship Mapping Defaults`. Przeanalizować 7 przykłdów różnych związków opisanych w tym rozdziale.

**Zadanie 2**

Rozbudować projekt z poprzedniego laboratorium o 3 kolejne klasy z dziedziny. Dobrać tak klasy aby można było wymodelować 3 rodzaje związków - jeden do jednego, jeden do wielu, wiele do wielu. Uwaga: konieczne jest zrozumienie i uzasadnienie wyboru rodzaju relacji (dotyczy także kierunkowości i właścicielskości). Wykorzystać adnotacje `@OneToOne, @OneToMany/@ManyToOne, @ManyToMany`. Dla pary `@OneToMany/@ManyTo` wymodelować relację dwukierunkową (pamietać wówczas o parametrze w adnotacji - `mappedBy`).
