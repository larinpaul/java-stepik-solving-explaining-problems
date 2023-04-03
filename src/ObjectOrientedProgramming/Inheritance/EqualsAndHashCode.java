package ObjectOrientedProgramming.Inheritance;

public class EqualsAndHashCode {

    // https://stepik.org/lesson/12769/step/9?unit=3117

    // 3.4. Наследование. Класс Object

    // Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так,чтобы equals() сравнивал экземпляры
    // ComplexNumber по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().

    // Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет

    // Пример
    // ComplexNumber a = new ComplexNumber(1, 1);
    // ComplexNumber b = new ComplexNumber(1, 1);
    // a.equals(b) must return true
    // a.hashCode() must be equal to b.hashCode()

    // Подсказка 1. Поищите в классе java.lang.Double статический метод, который поможет в решении задачи.

    // Подсказка 2. Можно позвать на помощь среду разработки, которая умеет сама генерировать equals() и hashCode().
    // Если вы воспользовались помощью IDE, то разберитесь, что было сгенерировано и почему оно выглядит именно так.
    // Когда вас на собеседовании попросят на бумажке реализовать equals() и hashCode()
    // для какого-нибудь простого класса, то среда разработки помочь не сможет.

}
