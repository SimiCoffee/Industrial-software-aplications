**Zadanie 1**

W zapytaniach wykorzystaj parametr `fetch`  ustawiając jego wartość na 'LAZY' i 'EAGER'. Dodaj adnotację `@Transactional` w serwisie i obserwuj różnice w pobieraniu encji przy adnotacjach `@OneToMany` i `@ManyToMany`. Zdefiniuj i przetestuj różne rodzaje kaskadowości za pomocą parametru `cascade`. 


**Zadanie 2**

W projekcie z poprzednich zajęć uzupełnić repozytoria o metody 'findBy' z wykorzystaniem słów kluczowych '...And...', '...Or...'. 
Zapoznać się z [przykładami zapytań w języku JPQL](https://en.wikibooks.org/wiki/Java_Persistence/JPQL) i zdefiniować własne.

**Zadanie 3**

Dodać warstwę kontrolerów i wykorzystać metody serwisu do obsłgui logiki biznesowej (metod CRUD). Napisać testy do HTTP REST API w Postmanie.
