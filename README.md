# DeterminedIntegralsCorrect
Основной файл - integrator, там прописаны все методы от трапеций до Гаусса и Ньютона-Котса

В Main помечены фрагменты кода для каждого пункта задания (в конце выполнены методы гаусса и Ньютона), последние пункты также включают реализацию оценки погрешности по Ричардсону и скорости сходимости по Эйткину

Значение интеграла с особенностью на левой границе промежутка: 18.54041900016543

Значение интеграла без особенностей: 20.235344669491454

Требуемая погрешность: 10^-6

В файле function можно задать функцию для интегрирования, не считая особенности, но без причины менять не стоит (моменты в котсе и гауссе прописаны вручную в связи с аналитическим решением, так что при изменении функции менять придется и моменты)

В Resources можно найти информацию по методам интегрирования (выбранные длины для разбиений и полученное значение интеграла в приближении)

https://colab.research.google.com/drive/1Fz_z3AngzI5DRP_smDDcRK0b15K2agDd?usp=sharing - код на питоне для отображения графиков погрешности (права зрителя), в качестве эталонного значения взят интеграл-значение из сервиса Desmos
