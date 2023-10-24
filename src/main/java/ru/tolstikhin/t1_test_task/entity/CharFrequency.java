package ru.tolstikhin.testtaskt1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CharFrequency {

    private char character;
    private int frequency;
}
