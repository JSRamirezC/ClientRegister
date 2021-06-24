package com.colfondos.pruebatecnicacol.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Parameter implements Serializable {

    @Id
    private String id;
    private String description;

}
