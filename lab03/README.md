**Zad 1.** Stwórz plik w formacie CSV zawierający dane kilkunastu osob. Dane (fake data) osób (kolumny pliku CSV): id (typu UUID4), imię, nazwisko, email, rok urodzenia 

Utwórz projekt w **SpringBoot** i dobierz odpowiednią bibliotekę do parsowania danych CSV, który będzie w sobie zawierał pakiet `domain` z klasą Person o właściwościach odpowiadających przedstawionym danym. Klasa ta ma mieć nadpisaną metodę toString, która będzie zwracać reprezentację klasy w postaci String. 

Następnie w pakiecie `service` utwórz klasę, która będzie wczytywać i parsować ww dane oraz zapisywać jest w postaci mapy z kluczem będącym `id` (założyć że pole `id` jest typu `String`).

Wszystkie klasy tworzymy w metodzie `main` podczas uruchamiania projektu. Aplikacja ma wypisać wszystkie utworzone osoby z klasy Person. 

**Uwaga** Nie należy korzystać z żadnych adnotacji tworzących komponenty Spring.

**Zad 2.** W nowym projekcie korzystającym z rozwiązań z zad. 1. (dokładniej: ładowania/tworzenia bazy osób z zewnętrznego zasobu URL/CSV) wykorzystaj różne sposoby tworzenia komponentów/beanów (plik `beans.xml`, `@Configuration\@Bean`, `@Component`) Następnie utwórz serwis (w **osobnym pakiecie**), który będzie wstrzykiwał w niego osoby w następujących funkcjach:

- prezes
- wiceprezes
- sekretarz

Wyżej wymienione osoby mają być utworzone jako Bean w klasie konfiguracyjnej serwisu.
Pozostałe osoby, mają być wpisane w postaci pliku .xml, który będzie wstrzyknięty z poziomu aplikacji.
Podczas uruchamiania aplikacji, aplikacja ma wypisać wszystkie utworzone Beany.
