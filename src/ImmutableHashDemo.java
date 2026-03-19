import java.util.*;

/**
 * demonstrates why hash codes should be immutable.
 */
public class ImmutableHashDemo {

    public static void main(String[] args) {

        try {

            Map<Person, String> phoneBook = new HashMap<>();
            Set<Person> personsOfInterest = new HashSet<>();

            // create a new person named Rob
            Person rob = new Person("Rob");

            // put it in a map and a set
            phoneBook.put(rob, "111-222-3333");
            personsOfInterest.add(rob);

            // change Rob's name, disaster ensues
            rob.setName("Tim");

            // the phone number is now orphaned in the map. there is no way to retrieve it.

            // cannot find it in the map using original person object.
            System.out.println("Looking under " + rob.getName() + " finds " + phoneBook.get(rob));

            // cannot find it in the map using a new Rob object.
            Person rob0 = new Person("Rob");
            System.out.println("Looking under " + rob0.getName() + " finds " + phoneBook.get(rob0));

            // add rob to the set again.
            // because it is a duplicate, set should not keep it.
            personsOfInterest.add(rob);

            // and yet the set has 2 entries.
            System.out.println("Set has " + personsOfInterest.size() + " members");

            // obtain the two entries.
            Iterator<Person> iter = personsOfInterest.iterator();
            Person a = iter.next();
            Person b = iter.next();

            // Sets defining property is that it does contain duplicates.
            // and yet we now have a set with a duplicate.

            if(a.equals(b))
                System.out.println("set members are equal with equals method");

            if(a == b)
                System.out.println("set members are equal with equals operator");

        } catch(Exception exc) {
            exc.printStackTrace();
        }
    }

}
