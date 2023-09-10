import com.google.gson.Gson;

public class GsonExample {
    public static void main(String[] args) {
        // Create a Gson object
        Gson gson = new Gson();

        // Serialize a Java object to JSON
        Person person = new Person("John", 30);
        String json = gson.toJson(person);
        System.out.println("Serialized JSON: " + json);

        // Deserialize JSON to a Java object
        Person deserializedPerson = gson.fromJson(json, Person.class);
        System.out.println("Deserialized Person: " + deserializedPerson.getName() + ", " + deserializedPerson.getAge());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
