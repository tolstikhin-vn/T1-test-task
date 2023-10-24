package ru.tolstikhin.testtaskt1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.tolstikhin.testtaskt1.api.request.CharFrequencyRequest;
import ru.tolstikhin.testtaskt1.api.response.CharFrequencyResponse;
import ru.tolstikhin.testtaskt1.entity.CharFrequency;
import ru.tolstikhin.testtaskt1.exception.NullInputStringException;
import ru.tolstikhin.testtaskt1.service.CharFrequencyService;
import ru.tolstikhin.testtaskt1.service.CharFrequencyServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CharFrequencyServiceImplTest {
    private CharFrequencyService charFrequencyService;

    @BeforeEach
    public void setUp() {
        charFrequencyService = new CharFrequencyServiceImpl();
    }

    /**
     * Тест метода {@link CharFrequencyServiceImpl#calculateCharacterFrequency(CharFrequencyRequest)}
     * Проверяет, возвращает ли метод правильный ответ на запрос
     */
    @Test
    @DisplayName("Проверка вычисления частоты встречи символов в непустой строке")
    public void testCalculateCharacterFrequency() {
        CharFrequencyRequest request = new CharFrequencyRequest("aaaaabcccc");
        CharFrequencyResponse response = charFrequencyService.calculateCharacterFrequency(request);

        List<CharFrequency> charFrequencies = response.getCharFrequencies();
        assertEquals(3, charFrequencies.size());

        assertEquals('a', charFrequencies.get(0).getCharacter());
        assertEquals(5, charFrequencies.get(0).getFrequency());

        assertEquals('c', charFrequencies.get(1).getCharacter());
        assertEquals(4, charFrequencies.get(1).getFrequency());

        assertEquals('b', charFrequencies.get(2).getCharacter());
        assertEquals(1, charFrequencies.get(2).getFrequency());
    }

    /**
     * Тест метода {@link CharFrequencyServiceImpl#calculateCharacterFrequency(CharFrequencyRequest)}
     * Проверяет, возвращает ли метод правильный ответ на запрос
     */
    @Test
    @DisplayName("Проверка вызова исключения в случае пустой строки")
    void testCalculateCharacterFrequencyWithEmptyInput() {
        CharFrequencyRequest request = new CharFrequencyRequest("");

        assertThrows(NullInputStringException.class, () -> {
            charFrequencyService.calculateCharacterFrequency(request);
        });
    }
}
