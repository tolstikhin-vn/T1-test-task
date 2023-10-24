package ru.tolstikhin.testtaskt1.service;

import ru.tolstikhin.testtaskt1.api.request.CharFrequencyRequest;
import ru.tolstikhin.testtaskt1.api.response.CharFrequencyResponse;

public interface CharFrequencyService {

    /**
     * Вычисляет частоту каждого символа во входной строке и возвращает результат запроса
     *
     * @param request запрос с входной строкой
     * @return объект CharFrequencyResponse, содержащий список символов и их частоту
     */
    CharFrequencyResponse calculateCharacterFrequency(CharFrequencyRequest request);
}