package com.example.springhelloworld;

import com.example.springhelloworld.exception.JsonSerializationException;
import com.example.springhelloworld.model.Employee;
import com.example.springhelloworld.services.ObjectToJsonConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnnotationTest {
    @Test
    public void givenObjectSerializedThenTrueReturned() throws JsonSerializationException {
        Employee person = new Employee("soufiane", "cheouati", "34");
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String jsonString = serializer.convertToJson(person);
        assertEquals(
                "{\"personAge\":\"34\",\"firstName\":\"Soufiane\",\"lastName\":\"Cheouati\"}",
                jsonString);
    }
}
