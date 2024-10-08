**Zadanie 1**

Napisz program, który wyświetli wiadomość: **Witaj w świecie Java!!!**. Skompiluj ten program z poziomu konsoli za pomocą narzędzia **javac**.

---

**Zadanie 2**

**Liczba Armstronga** to taka liczba, która jest sumą potęg cyfr służących do jej zapisu.

Liczba 9 jest liczbą Armstronga, ponieważ \\( 9 = 9^1 \\)

Liczba 10 nie jest liczbą Armstronga, ponieważ \\( 10 \\neq 1^2 + 0^2 = 1 \\).

Napisz program, który będzie sprawdzał czy liczba \\( n \\) jest liczbą Armstronga.

Jako wyjścia program powinien wyświetlić wartość true, jeżeli liczba \\( n \\) jest liczbą Armstronga lub false w przeciwnym przypadku.

---

**Zadanie 3**

Jeżeli podamy wiek w sekundach, to jest możliwość obliczenia ile osoba ta ma lat na ziemi.

Kula ziemska przechodzi przez własną orbitę przez 365,25 dnia, które wynosi równo 31557600 sekund.

A więc jeżeli osoba ma 1000000000 sekund to łatwo można policzyć, że 1000000000/31557600 = 31,69 lat (w przybliżeniu do drugiego miejsca po przecinku).

Teraz rozpatrzmy metodę, która będzie przyjmowała wiek w sekundach oraz planetę którą chcemy obliczyć.

Napisz program, który będzie zawierał tę metodę uwzględniając poniższe dane dotyczące innych planet:

*   Obrót Merkurego podczas własnej orbity wynosi 0.2408467 lat ziemskich
*   Obrót Wenus podczas własnej orbity wynosi 0.61519726 lat ziemskich
*   Obrót Marsa podczas własnej orbity wynosi 1.8808158 lat ziemskich
*   Obrót Jowisza podczas własnej orbity wynosi 11.862615 lat ziemskich
*   Obrót Saturna podczas własnej orbity wynosi 29.447498 lat ziemskich
*   Obrót Uranu podczas własnej orbity wynosi 84.016846 lat ziemskich
*   Obrót Neptuna podczas własnej orbity wynosi 164.79132 lat ziemskich

**Zadanie 4**

Napisz program, który dla liczby naturalnej \\( n \\) wypisze poniższe wzory (jeden pod drugim). Poniżej jest przykład dla n=3.

W przypadku niepoprawnych danych program ma ponownie je wczytać.

**Zakładamy, że na końcu linii jest wyłącznie znak nowej linii.**

x\
xx\
xxx\
xxx\
xx\
x\
xxx\
&nbsp;&nbsp;xx\
&nbsp;&nbsp;&nbsp;x\
&nbsp;&nbsp;&nbsp;x\
&nbsp;&nbsp;xx\
xxx

---

**Zadanie 5**

Zgodnie z zasadami programowania obiektowego utwórz klasę o nazwie Author, która będzie zawierała następujące pola:

*   name jako String
*   email jako String
*   gender jako Enum

Klasa powinna zawierać konstruktor Author(name, email, gender) oraz następujące metody:

*   getName()
*   getEmail()
*   setEmail(email)
*   getGender()
*   toString(), który będzie zwracał obiekt w postaci: "Author\[name=?,email=?,gender=?\]"

Następnie utwórz klasę Book, który będzie zawierał następujące pola:

*   name jako String
*   author jako Author
*   price jako double
*   qty jako int (domyślnie wartość zero)

Klasa Book ma posiadać następujące konstruktory Book(name, price, author),  Book(name, price, author, qty) oraz następujące metody:

*   getName()
*   getAuthor()
*   getPrice()
*   setPrice(price)
*   getQty()
*   setQty()
*   toString() który będzie zwracał obiekt w postaci: "Book\[name=?,author=Author\[name=?,email=?,gender=?\],price=?,qty=?\]"

Przetestuj te klasy za pomocą funkcji **main**.

---

**Zadanie 6 **Modyfikacja/Uszczegółowienie** ** 

Napisz klasę **Hello.java** (wyświetlającą w metodzie *main* na konsoli komunikat *Hello World*) w **dedykowanym** pakiecie (obowiązkowo). Zbuduj plik **myapp.jar**, który uruchomi kod klasy Hello (inaczej: klasa Hello jest głowną archiwum). Zadanie jest zaliczone jeśli plik *myapp.jar* będziesz mógł uruchomić z dowlnego katalogu w systemie (za pomocą komendy > java -jar myapp.jar). Sposób postępownia (komendy) opisać w pliku w formacie markdown i umieścić jako rozwiązanie zadania.
