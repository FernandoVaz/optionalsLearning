import java.sql.SQLOutput;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Optional<Object> hello = Optional.ofNullable(null);
        Optional<Object> teste = Optional.of("Teste");
        Optional<Object> functionalTesting = Optional.ofNullable(null);

        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

        String world = hello
                .map(s -> s.toString().toUpperCase())
                .orElseGet(() -> {
                    // stuff
                    return "World";
                });
        System.out.println(world);

        Optional<String> anotherString = hello
                .map(s -> s.toString().toUpperCase())
                .or(() -> {
                    // stuff
                    return Optional.of("World");
                });
        System.out.println(anotherString);

//        String anotherError = teste
//                .map(s -> s.toString().toUpperCase())
//                .orElseThrow(IllegalAccessError::new);
//
//
//        System.out.println(anotherError);

        functionalTesting.ifPresentOrElse(word -> {
            System.out.println(word);
        }, () -> {
            System.out.println("World");
        });

        // This representation is the same as the one above;
        functionalTesting.ifPresentOrElse(System.out::println, () -> System.out.println("World"));


        Optional<Integer> number = Optional.ofNullable(null);


        number.isPresent();


        Person person = new Person("Abdul", "Abdul@jamal.com");
        Person person2 = new Person("Abdul", null);
        System.out.println(person.getEmail().map(String::toUpperCase).orElse("Email not available"));
        System.out.println(person2.getEmail().map(String::toUpperCase).orElse("Email not available"));
    }
}


class Person {
    private final String name;
    private final String email;

    Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}
