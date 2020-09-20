package com.gb.cricscore.model.people;

import com.gb.cricscore.common.Contact;
import com.gb.cricscore.common.PersonalInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private PersonalInfo personalInfo;

    public Person(String name) {
        this.name = name;
    }

    private Contact contact;
}
