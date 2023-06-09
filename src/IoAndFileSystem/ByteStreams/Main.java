package IoAndFileSystem.ByteStreams;


// https://stepik.org/lesson/12783/step/9?unit=3130

// По историческим причинам на разных платформах принят разный способ обозначения конца строки в текстовом файле.
// На Unix-системах конец строки обозначается символом с кодом 10 ('\n'),
// На Windows - двумя последовательными символами с кодами 13 и 10 ('\r' '\n').

// Напишите программу, которая будет преобразовывать переводы строк из формата Windows в формат Unix.
// Данные в формате Windows подаются программе в System.in, преобразованные данные должны выводиться в System.out.
// На этот раз вам надо написать программу полностью, т.е. объявить класс (с именем Main -
// таково ограничение проверяющей системы), метод main, прописать все improt'ы.

// Требуется заменить все вхождения пары символов '\r' и '\n' на один символ '\n'.
// Если на входе встречается одиночный символ '\r', за которым не следует '\n', то символ '\r' выводится без изменения.

// Кодировка входных данных такова, что символ '\n' представляется байтом 10, а символ '\r' - байтом 13.
// Поэтому программа может осуществлять фильтрацию на уровне двоичных данных, не преобразуя байты в символы.

// Из-за буферизации в System.out в конце вашей программы надо явно вызвать System.out.flush().
// Иначе часть выведенных вами данных не будет видна проверяющей системе.

// Пример
// Из System.in зачитаны следующие байты: 65 13 10 10 13. Внимание! Это не строка "65 13 10 10 13",
// а последовательность чисел, возвращаемая методом System.in.read().

// В System.out должны быть выведены байты: 65 10 10 13

// Максим Ремыга:
// Проще всего задача решилась с помощью такого рассуждения:
// 1) читаем новый байт из потока и запоминаем его в переменную prev
// 2) если prev не -1, входим в цикл и читаем следующий байт из потока в переменную next, иначе переходим к пункту (6)
// 3) если prev != 13 или next != 10, выводим prev
// 4) "передвигаем" очередь путём присвоения prev = next
// 5) переходим к пункту (2)
// 6) делаем flush.
// Результат: 15 строк кода и оценка сложности 7.81

// Dmitry Knyazev:
// Очень удобно тестироваться (без подключения нормальны юнит тестов), как советовали коллеги ниже,
// если задать входной поток заранее сформированным входным массивом т.о.:
//byte[] arr = {65, 66, 13, 13, 10, 10, 13, 67, 13, 13};
//ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
//System.setIn(inputStream);
// и смотреть что на выходы. Для данного входного массива, выходной д.б. 65, 66, 13, 10, 10, 13, 67, 13, 13
// Для проверки вывода, write можно временно заменить на print (или выводить в массив для печати)

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Считываем первый байт из потока ввода и сохраняем его в prev
        int next = 0;
        int prev = System.in.read();
        // Итерируется, пока prev не станет -1 (EOF)
        while (prev != -1) {
            // Считываем следующий байт и сохраняем его в next
            next = System.in.read();
            // Если prev не является возвратом каретки (13)
            // или следующий байт не является символом перевода строки (10),
            // выводим prev, т.е. пишем его в стандартный поток вывода
            if (prev != 13 || next != 10) {
                System.out.write(prev);
            }
            // Присваиваем next значение prev для следующей итерации
            prev = next;
        }
        // Вызываем flush(), чтобы очистить буфер стандартного потока вывода
        System.out.flush();
    }
}
