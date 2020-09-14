package com.gb.cricscore.model;

import com.gb.cricscore.common.Contact;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private String email;
    private Contact contact;
}
