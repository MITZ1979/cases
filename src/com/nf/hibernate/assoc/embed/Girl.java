package com.nf.hibernate.assoc.embed;

import javax.naming.Name;
import javax.persistence.*;
import javax.xml.ws.soap.Address;
@Entity
public class Girl {

    @Id @GeneratedValue
    private long id;

    @Embedded
    private Name name;
    //private String firstname;
    //private String lastname;

    @Embedded
    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
