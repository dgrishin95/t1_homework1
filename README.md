# T1 Homework 1

С помощью аннотаций @TrackTime и @TrackAsyncTime можно синхронно и асинхронно отслеживать
время выполнения методов, которыми они помечены.

В качестве тестов были помечены методы testTrackTimeAnnotation и testAsyncTrackTimeAnnotation,
имеющие одинаковый функционал.

Реализован механизм анализа данных для получения статистики по времени выполнения методов:
- Среднее время выполнения для методов, помеченных аннотацией @TrackTime;
- Среднее время выполнения для методов, помеченных аннотацией @TrackAsyncTime;
- Общее время выполнения для методов, помеченных аннотацией @TrackTime;
- Общее время выполнения для методов, помеченных аннотацией @TrackAsyncTime.