package ru.tolstikhin.testtaskt1.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharFrequencyRequest {
    private String inputString;
}
