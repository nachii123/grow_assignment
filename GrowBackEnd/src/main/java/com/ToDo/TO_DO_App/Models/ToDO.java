package com.ToDo.TO_DO_App.Models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Data // getter,setter,toString,required args constructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ToDO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    Boolean status = false; // Default is false (not completed)

    LocalDateTime createdAt = LocalDateTime.now();
}
