package ru.tolstikhin.testtaskt1.service;

import org.springframework.stereotype.Service;
import ru.tolstikhin.testtaskt1.api.request.CharFrequencyRequest;
import ru.tolstikhin.testtaskt1.api.response.CharFrequencyResponse;
import ru.tolstikhin.testtaskt1.entity.CharFrequency;
import ru.tolstikhin.testtaskt1.exception.NullInputStringException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Сервис для вычисления частоты символов во входной строке
 */
@Service
public class CharFrequencyServiceImpl implements CharFrequencyService {
    /**
     * {@inheritDoc}
     */
    @Override
    public CharFrequencyResponse calculateCharacterFrequency(CharFrequencyRequest request) {
        String inputString = request.getInputString();

        if (inputString.isEmpty()) {
            throw new NullInputStringException("Заданная строка не должна быть пустой.");
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : inputString.toCharArray()) {
            // Обновляем частоту символа в мапе
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Преобразуем результат в список объектов CharFrequency и отсортируем по убыванию частоты вхождения
        List<CharFrequency> charFrequencies = frequencyMap.entrySet()
                .stream()
                .map(entry -> new CharFrequency(entry.getKey(), entry.getValue()))
                .sorted((a, b) -> b.getFrequency() - a.getFrequency())
                .collect(Collectors.toList());

        return new CharFrequencyResponse(charFrequencies);
    }
}
