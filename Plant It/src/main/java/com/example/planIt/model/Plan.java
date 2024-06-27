package com.example.planIt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Plans")
public class Plan {
    @Id
    @JsonIgnore
    String id;

    String user_id;
    @NotBlank(message = "Plan name is mandatory")
    String planName;

    @Size(min = 1, max = 5, message = "Plan must contain items between 1 and 5 ")
    List<String> planItems;
}
