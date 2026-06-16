**Zadanie 1**

W projekcie z poprzednich zajęć dodać warstwę repozytoriów czyli interfejsów rozszerzających `CRUDRepository<T, ID>`. W metodzie szkoleniowej `setUpApp` w komponencie `CommandLineRunner` i serwisie (por. przykład z wykładu) wykonuj opreacje typu CRUD zdefiniowane w tym interfejsie. Do kolejnych zadań usunąć powiazania między encjami (uzupełnimy to na kolejnym wykładzie). Kontrakt/interfejs [JpaRepository<T, ID>](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)


**Zadanie 2**

Dodać warstwę kontrolerów, które będą wykorzystywały nowy serwis (wykorzystujący Repozytorium) i zaimplementować metod dodawania nowej encji, wyszukiwania po id i usuwania po id, w sposób anaologiczny jak robiliśmy to z implementacją serwisu 'inMemory'
