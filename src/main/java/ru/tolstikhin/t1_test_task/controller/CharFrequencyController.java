package ru.tolstikhin.t1_test_task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.tolstikhin.t1_test_task.api.request.CharFrequencyRequest;
import ru.tolstikhin.t1_test_task.api.response.CharFrequencyResponse;
import ru.tolstikhin.t1_test_task.service.CharFrequencyService;

/**
 * Контроллер, отвечающий за обработку HTTP-запросов для вычисления частоты встречи символов в строке
 */
@RestController
public class CharFrequencyController {

    private final CharFrequencyService charFrequencyService;

    public CharFrequencyController(CharFrequencyService charFrequencyService) {
        this.charFrequencyService = charFrequencyService;
    }

    /**
     * Обрабатывает POST-запрос для вычисления частоты символов в переданном тексте
     *
     * @param request запрос с текстом, для которого нужно вычислить частоту символов
     * @return ResponseEntity с результатом вычисления частоты символов и статусом ответа
     */
    @PostMapping("/api/calculate")
    public ResponseEntity<CharFrequencyResponse> calculateFrequency(@RequestBody CharFrequencyRequest request) {
        CharFrequencyResponse response = charFrequencyService.calculateCharacterFrequency(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
