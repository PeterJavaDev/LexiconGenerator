Lexicon Generator

To bardzo prosta aplikacja w Java 17, Spring Boot. <br />
Budowana przy pomocy Maven:

```
mvn clean install
```
<br />

Do uruchomienia można użyć Spring Boot Plugin:

```
mvn spring-boot:run
```

Jest jedna metoda:

Generate <br />
POST http://localhost:8080/generate <br />
Przyjmuje tekst jako ciało, z którego generuje listę słów. W przypadku takiej samej ilości wystąpień danego słowa nadawane są kolenje numery w ranking.
Walidacja Spring'a jest nadpisana umyślnie aby spełnić wymaganie zwracania kodu 500.
