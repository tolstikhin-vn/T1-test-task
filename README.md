# Тестовое задание
REST API, вычисляющее частоту встречи символов по заданной строке. Результат должен быть отсортирован по убыванию количества вхождений символа в заданную строку.

## Требования
Установлен Maven и его присутствие в PATH  
Java 11  

## Сборка и запуск
**Склонируйте репозиторий и перейдите в корень проекта:**
```bash
git clone https://github.com/tolstikhin-vn/T1-test-task.git
cd t1-test-task
```
**Упакуйте приложение в jar-файл:**
```bash
mvn package
```
**Соберите образ:**
```bash
docker build -t t1-test-task:0.0.1 .
```
**Запустите контейнер:**
```bash
docker run -d -p 8080:8080 -t t1-test-task:0.0.1
```
## API:
**Base URL:** localhost:8080  
**Endpoint (POST)** /api/calculate
## Формат входящих/исходящих параметров (пример)
**Входящие параметры ( Request body ):**  
```json
{  
    "inputString":"aaaaabcccc"  
}
```
**Исходящие параметры:**
```json
{
    "charFrequencies": [
        {
            "character": "a",
            "frequency": 5
        },
        {
            "character": "c",
            "frequency": 4
        },
        {
            "character": "b",
            "frequency": 1
        }
    ]
}
```
