**Projekt zaliczeniowy i zasady zaliczenia**

1. Warunkiem przystąpienia do uzyskania pozytywnej oceny jest zaliczenie laboratoriów. Grupy 1. i 2. - *wszystkie* zadania wykonane prawidłowo i umieszczone w repozytorium, oceniane na egzaminie 

3. Zaliczenie polega na obronie projektu zaliczeniowego. Student sam wybiera poziom trudności, skomplikowania projektu, przestrzegania zasad clean code, zgodności z wzoracmi projektowymi i architektonicznymi oraz staranności w implementacji projektu. Pytania na egzaminie co do zasady będą dotyczyć projektu zaliczeniowego choć mogą dotyczyć wszystkich poruszanych zagadnień. Student ma obowiązek znajomości wszystkich rozwiązań i kostrukcji, technologii które wykorzysta w projekcie egzaminacynym

4. Każda osoba zakłada w swoim repo katalog o nazwie 'projekt' i tam umieszcza kod projektu.

5. Tematyka projektu ustalona z prowadzącymi na laboratoriach

6. Wymagania projektu zaliczeniowego

Wcielamy sie w rolę dostawcy serwisu - backendu, do którego inny zespół tworzy frontend w aplikacji wg worca SPA (np. React/Angular/Vue). Naszym zadaniem jest
* zaprojektowanie, zaimplementowanie i przetestowanie HTTP API wg wzorca REST
* dostarczenie wybranych widoków (np. dla roli Administrator) w technologii Spring MVC

* dziedzina obejmuje min. 4 powiązane klasy domenowe. Wystąpić muszą jedno i dwukierunkowe powiązania z wykorzystaniem różnych wartości trybutów CascadeType i FetchType
* repozytoria wg potrzeb
* serwisy - (min. 2 serwisy dla dwóch klas dziedzinowych głównej i wybranej pobocznej) 
   * dla klasy głównej i jednej pobocznej implementujemy rozbudowaną logikę biznesową, która wykorzystuje 2 lub więcej repozytoriów
   * zaprojektować metody biznesowe tak aby były implementowane przy wykorzystaniu
      * konwencji `findBy`
      * zapytań w języku JPQL z użyciem `JOIN`, agregujace (na min. ocenę dobrą) z wykorzystaniem `GROUP BY`, itp.
      * zaptyań typu native query (dla celów poznwczych) (na min. ocenę dobrą) 
* kontrolery - wszystkie operacje biznesowe mają odzwierciedlenie w kontrolerach (pamietać o prawidłowej obsłudze żądań HTTP z uwzględnieniem semantyki HTTP i wzroca REST, response code odpowiednim do sytuacji)
* w sposób szczególny projektujemy i implementujem endpoint obsługujący wielokryteriową wyszukiwarke. Zakładamy, że frontend będzie posiadał formularz do wyszukiwania z polami tekstowymi i różnymi komponentami typu checkbox, select itp. Ponadto endpoint ten ma obsługiwać paginację i sortowanie (na min. ocenę dobrą)
* wszystkie operacje biznesowe/kontrolery/wyszukiwarka należy pokryć testami z wykorzystaniem POSTMana (lub analogicznego narzędzia) - kolekcje testów dołączamhy do repo