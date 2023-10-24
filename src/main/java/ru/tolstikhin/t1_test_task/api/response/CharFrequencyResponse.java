package ru.tolstikhin.testtaskt1.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.tolstikhin.testtaskt1.entity.CharFrequency;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharFrequencyResponse {
    private List<CharFrequency> charFrequencies;
}
