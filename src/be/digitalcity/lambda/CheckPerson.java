package be.digitalcity.lambda;

import be.digitalcity.lambda.Person;

@FunctionalInterface
public interface CheckPerson {
    boolean test(Person p);
}
