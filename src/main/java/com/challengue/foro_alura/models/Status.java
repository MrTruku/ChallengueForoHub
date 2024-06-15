package com.challengue.foro_alura.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "status")
@Entity
@Getter
@NoArgsConstructor
public class Status
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private String description;
}
