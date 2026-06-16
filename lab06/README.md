**Zadanie 1**

Na podstawie przykładu z wykładów (03_springboot_mvc_jpa), utwórz nowy projekt dla bieżących laboratoriów zawierający dodatkowy katalog `./db` z silnikiem bazy danych oraz plik `application.properties`. Uruchom bazę danych, jej graficznego klienta i po upewnieniu się że połączenie jest nawiązane uruchom projekt. 

**Zadanie 2**

Dodaj do tego projektu podpakiet `domain` a w nim klasę główną ze swojej dziedziny z adnotacjami `@Entitty, @Id, @GeneratedValue`. Po restarcie projektu zaobserwuj w kliencie bazy utworzoną tabelę. Dobierz do klasy głównej kolejną klasę z dziedziny (która pozostaje z klasą główną w związku jeden-do-jeden) i połącz ją adnotacją `OneToOne`. Zaobserwuj efekt "złączenia" na poziomie bazy danych.

**Zadanie 3 (opcjonalne)**

Eksperymentalnie spróbuj podłączyć się do bazy Postgres zamiast HSQLDB (można uruchomić za pomocą np. Docker). Zaobserwuj analogiczny efekt (na przykład korzystająć z polecenia > psql w kontenerze)
