#Lab04

**Zadanie 1**

Wybrać unikalną dziedzinę (plik TematykaDziedzina na Teamsach, katalog Documents). W nowym projekcie, który będzie wykorzystywał wybraną dziedzinę, utwórz kontroler typu `REST` w którym:

*   Wyświetlisz wszystkie encje w formacie JSON
*   Wyświetlisz konkretną encję w formacie JSON po polu ID (ID: String, UUID)
*   Dodasz encję do bazy encji
*   Dokonasz edycji encji z bazy
*   Usuniesz encję z bazy encji

Baza danych w postaci List<T> lub Map<String, T >. Dokonać inicjalizacji bazy (kilka encji na start poprzez `CommandLineRunner`). Obsłużyć prawidłowe `response code` przy wykorzystaniu [Best Practices](https://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api) i gdzie potrzeba ustawic nagłówek `Location` (metoda POST). Wykorzystać własny `Exception` do obsługi sytuacji wyjątkowych (np. próba pobrania nieistniejąceog zasobu). 

**Zadanie 2**
Do endpointów z zad1. utworzyć kolekcję testów POSTMAN i dołączyć ją do projektu w katalogu  `/src/test/resources`

#Lab05
**Zadanie 0 (Pre warunek)**

Zmodyfikować dziedzinę (wybraną tematykę) tak aby klasa główna spełniała następujące warunki:

 * Klasa posiada min. 4 właściwości
 * Właściwości są 4 róznych typów, które musza podlegać walidacji:
    * liczbowy (całkowito lub zmiennopozycyjny)
    * boolean
    * String - walidacja typu regexp
    * Date (por. [java time API](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/package-summary.html)) - walidacja: data przyszła/przeszła, nie starszy niż itp.
 * walidacja pól wymaganych


**Zadanie 1**

W ustalonym projekcie (przypominam: każdy student prowadzi projekt w swojej dziedzinie) z poprzednich laboratoriów dodaj następujące widoki (Spring MVC, Thymeleaf) 

*   Zbiorcza prezentacja wszystkich elementów dziedziny (np. wszystkich osób, samochodów, zależnie od dziedziny) 
*   Prosty formularz (z podstawową walidacją, obsługą błędów)  dodawania nowego elementu  
*   Akcja usunięcia elementu (link z widoku zbiorczego)
*   Akcja edycji elementu (link z widoku zbiorczego)

Baza danych ma być w postaci listy (lub mapy) obiektów z dziedziny.

**Zadanie 2**

Dodać kolekcję Postman testującą obsługę formularzy (uwaga na format przekazywanych danych przy obsłudze tradycyjnych formularzy). Wyeksportowane pliki z Postmana należy dodać do drzewa projektu w `src/test/resources`