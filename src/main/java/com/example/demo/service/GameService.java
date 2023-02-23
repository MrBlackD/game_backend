package com.example.demo.service;

import com.example.demo.dto.Round;
import com.example.demo.entity.Game;
import com.example.demo.entity.Question;
import com.example.demo.entity.Screen;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class GameService {
    private List<Game> games = new ArrayList<>();
    static Integer TIMER = 30000;
    static String ROUND = "round";
    static String QUESTION = "question";
    static String ANSWER = "answer";
    static String RESULTS = "results";

    public GameService() {
        Game game = new Game(
                UUID.randomUUID().toString(),
                "Новая игра",
                Arrays.asList(
                        // первый раунд
                        Question.builder().questionType("video").text("Что было дальше?").video("IzjoDZ_vb9E").start(0).duration(26).answerVariants(List.of("Холодненькая", "Заебись вода", "А где Вован?")).rightAnswer("Заебись вода").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("IzjoDZ_vb9E").start(26).duration(22).answerVariants(List.of("Холодненькая", "Заебись вода", "А где Вован?")).rightAnswer("Заебись вода").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что было дальше?").video("siJDYhunYbM").start(208).duration(28).answerVariants(List.of("Никогда не разучишься", "Я в порядке", "Вы видели? Эта тачка вылетела на меня из ниоткуда")).rightAnswer("Никогда не разучишься").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("siJDYhunYbM").start(236).duration(5).answerVariants(List.of("Никогда не разучишься", "Я в порядке", "Вы видели? Эта тачка вылетела на меня из ниоткуда")).rightAnswer("Никогда не разучишься").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что было дальше?").video("siJDYhunYbM").start(742).duration(105).answerVariants(List.of("Это было круто", "Все таки один мячик уронил", "Ни одного мячика не уронил")).rightAnswer("Ни одного мячика не уронил").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("siJDYhunYbM").start(847).duration(3).answerVariants(List.of("Это было круто", "Все таки один мячик уронил", "Ни одного мячика не уронил")).rightAnswer("Ни одного мячика не уронил").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что было дальше?").video("wLCfkCkDMlw").start(322).duration(43).answerVariants(List.of("Снимет штаны", "Обкардет всех", "Все останутся без штанов")).rightAnswer("Снимет штаны").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("wLCfkCkDMlw").start(365).duration(19).answerVariants(List.of("Снимет штаны", "Обкардет всех", "Все останутся без штанов")).rightAnswer("Снимет штаны").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что было дальше?").video("W1NgTYCnwVM").start(56).duration(6).answerVariants(List.of("За вами", "Домой", "Воевать")).rightAnswer("Домой").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("W1NgTYCnwVM").start(62).duration(2).answerVariants(List.of("За вами", "Домой", "Воевать")).rightAnswer("Домой").type(ANSWER).build(),

                        Screen.builder().type(RESULTS).build(),

                        Question.builder().questionType("video").text("Что было дальше?").video("ggzMrfuCik8").start(39).duration(7).answerVariants(List.of("Сердце хочет поздравить, а душа нет", "Хочется поздравить, но кто бы поздравил меня", "Поздавляю конечно их, но не от всего сердца")).rightAnswer("Поздавляю конечно их, но не от всего сердца").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("ggzMrfuCik8").start(46).duration(33).answerVariants(List.of("Сердце хочет поздравить, а душа нет", "Хочется поздравить, но кто бы поздравил меня", "Поздавляю конечно их, но не от всего сердца")).rightAnswer("Поздавляю конечно их, но не от всего сердца").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что было дальше?").video("N7SklXvhxMc").start(0).duration(52).answerVariants(List.of("Дождик-хуеждик", "Мишура-хуера", "Шарики-хуярики")).rightAnswer("Дождик-хуеждик").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("N7SklXvhxMc").start(52).duration(6).answerVariants(List.of("Дождик-хуеждик", "Мишура-хуера", "Шарики-хуярики")).rightAnswer("Дождик-хуеждик").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что было дальше?").video("DhLLF6cAn-s").start(0).duration(34).answerVariants(List.of("Я слово вам даю что будет 27го", "Ну что вы пристали с этой дорогой", "Я обещание дал, значит я его сдержу")).rightAnswer("Ну что вы пристали с этой дорогой").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("DhLLF6cAn-s").start(34).duration(16).answerVariants(List.of("Я слово вам даю что будет 27го", "Ну что вы пристали с этой дорогой", "Я обещание дал, значит я его сдержу")).rightAnswer("Ну что вы пристали с этой дорогой").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что было дальше?").video("BEEv9Am3ytI").start(47).duration(17).answerVariants(List.of("Алло Руслан подъедь пожалуйста", "Мам забери меня", "Русик, позвони Паше ФСБшнику пусть подъедет")).rightAnswer("Алло Руслан подъедь пожалуйста").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("BEEv9Am3ytI").start(64).duration(10).answerVariants(List.of("Алло Руслан подъедь пожалуйста", "Мам забери меня", "Русик, позвони Паше ФСБшнику пусть подъедет")).rightAnswer("Алло Руслан подъедь пожалуйста").type(ANSWER).build(),

                        Screen.builder().type(RESULTS).build(),

                        Question.builder().questionType("video").text("Что было дальше?").video("YSsKw8gRVlY").start(0).duration(5).answerVariants(List.of("Смотреть не все лишь только могут", "Вернее не все могут смотреть", "Вернее смотреть могут не только лишь все")).rightAnswer("Вернее смотреть могут не только лишь все").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("YSsKw8gRVlY").start(5).duration(5).answerVariants(List.of("Смотреть не все лишь только могут", "Вернее не все могут смотреть", "Вернее смотреть могут не только лишь все")).rightAnswer("Вернее смотреть могут не только лишь все").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что было дальше?").video("TVwvcGajoQg").start(0).duration(41).answerVariants(List.of("Я никогда не поеду в Китай какать на огороды", "Ты втираешь мне какую-то дичь", "Я не поеду срать в Китай")).rightAnswer("Я никогда не поеду в Китай какать на огороды").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("TVwvcGajoQg").start(41).duration(4).answerVariants(List.of("Я никогда не поеду в Китай какать на огороды", "Ты втираешь мне какую-то дичь", "Я не поеду срать в Китай")).rightAnswer("Я никогда не поеду в Китай какать на огороды").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что было дальше?").video("FJO_iCgftZk").start(0).duration(7).answerVariants(List.of("Успешный район, город Мечта, улица Счастливая дом 7", "Тоскливый район, город Грусть, проспекты Разочарования дом 13", "проспект Несбывшихся-надежд, город Судьба, улица Печальная 13/13")).rightAnswer("Тоскливый район, город Грусть, проспекты Разочарования дом 13").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("FJO_iCgftZk").start(7).duration(13).answerVariants(List.of("Успешный район, город Мечта, улица Счастливая дом 7", "Тоскливый район, город Грусть, проспекты Разочарования дом 13", "проспект Несбывшихся-надежд, город Судьба, улица Печальная 13/13")).rightAnswer("Тоскливый район, город Грусть, проспекты Разочарования дом 13").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что было дальше?").video("eh0gRBbALYk").start(0).duration(7).answerVariants(List.of("КГБ", "Полиция", "Аллах")).rightAnswer("КГБ").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("eh0gRBbALYk").start(0).duration(7).answerVariants(List.of("КГБ", "Полиция", "Аллах")).rightAnswer("КГБ").type(ANSWER).build(),

                        Screen.builder().type(RESULTS).build()



                     /*   Round.builder().title("Откуда трек?").type(ROUND).timer(TIMER).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("TtFqkLyR4TQ").start(813).answerVariants(List.of("Атака титанов", "Ведьмак", "Унесенные призраками", "Ходячий замок")).rightAnswer("Атака титанов").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("TtFqkLyR4TQ").start(813).answerVariants(List.of("Атака титанов", "Ведьмак", "Унесенные призраками", "Ходячий замок")).rightAnswer("Атака титанов").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("gw5vAd5icAg").start(41).answerVariants(List.of("Убить Билла", "Криминальное чтиво", "Однажды в Голливуде", "Бешеные псы")).rightAnswer("Убить Билла").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("gw5vAd5icAg").start(41).answerVariants(List.of("Убить Билла", "Криминальное чтиво", "Однажды в Голливуде", "Бешеные псы")).rightAnswer("Убить Билла").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("p5ezdOieb2c").start(0).answerVariants(List.of("Ведьмак", "Игра престолов", "Дом дракона", "Skyrim")).rightAnswer("Ведьмак").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("p5ezdOieb2c").start(0).answerVariants(List.of("Ведьмак", "Игра престолов", "Дом дракона", "Skyrim")).rightAnswer("Ведьмак").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("-uEc8_dcYUc").start(20).answerVariants(List.of("Терминатор", "Cyberpunk 2077", "Бегущий по лезивю", "Battlefield")).rightAnswer("Battlefield").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("-uEc8_dcYUc").start(20).answerVariants(List.of("Терминатор", "Cyberpunk 2077", "Бегущий по лезивю", "Battlefield")).rightAnswer("Battlefield").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("MV_3Dpw-BRY").start(10).answerVariants(List.of("Драйв", "Hotline Miami", "Перевозчик", "Need for Speed")).rightAnswer("Драйв").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("MV_3Dpw-BRY").start(10).answerVariants(List.of("Драйв", "Hotline Miami", "Перевозчик", "Need for Speed")).rightAnswer("Драйв").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("ubWL8VAPoYw").start(0).answerVariants(List.of("Need for Speed", "Форсаж", "GTA", "Такси")).rightAnswer("Need for Speed").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("ubWL8VAPoYw").start(0).answerVariants(List.of("Need for Speed", "Форсаж", "GTA", "Такси")).rightAnswer("Need for Speed").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("prvAdHXUvbs").start(0).answerVariants(List.of("Ведьмак", "Игра престолов", "Викинги", "God of War")).rightAnswer("Ведьмак").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("prvAdHXUvbs").start(0).answerVariants(List.of("Ведьмак", "Игра престолов", "Викинги", "God of War")).rightAnswer("Ведьмак").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("yBm4K00SMEk").start(0).answerVariants(List.of("Лучше звоните Солу", "Во все тяжкие", "Бешеные псы", "Большой Лебовски")).rightAnswer("Лучше звоните Солу").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("yBm4K00SMEk").start(0).answerVariants(List.of("Лучше звоните Солу", "Во все тяжкие", "Бешеные псы", "Большой Лебовски")).rightAnswer("Лучше звоните Солу").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("CHENRaquRHo").start(0).answerVariants(List.of("Cyberpunk 2077", "Матрица", "Призрак в доспехах", "Бегущий по лезвию")).rightAnswer("Cyberpunk 2077").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("CHENRaquRHo").start(0).answerVariants(List.of("Cyberpunk 2077", "Матрица", "Призрак в доспехах", "Бегущий по лезвию")).rightAnswer("Cyberpunk 2077").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("pFS4zYWxzNA").start(0).answerVariants(List.of("Матрица", "Cyberpunk 2077", "Заводной апельсин", "Бегущий по лезвию")).rightAnswer("Матрица").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("pFS4zYWxzNA").start(0).answerVariants(List.of("Матрица", "Cyberpunk 2077", "Заводной апельсин", "Бегущий по лезвию")).rightAnswer("Матрица").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("1hLIXrlpRe8").start(0).answerVariants(List.of("Криминальное чтиво", "Убить Билла", "Форсаж", "Джанго освобожденный")).rightAnswer("Криминальное чтиво").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("1hLIXrlpRe8").start(0).answerVariants(List.of("Криминальное чтиво", "Убить Билла", "Форсаж", "Джанго освобожденный")).rightAnswer("Криминальное чтиво").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("pWO718iy5mY").start(20).answerVariants(List.of("GTA", "Крестный Отец", "Mafia", "Ирландец")).rightAnswer("GTA").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("pWO718iy5mY").start(20).answerVariants(List.of("GTA", "Крестный Отец", "Mafia", "Ирландец")).rightAnswer("GTA").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("AVy7YPNP_zI").start(10).answerVariants(List.of("Skyrim", "God of War", "Викинги", "Властелин Колец")).rightAnswer("Skyrim").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("AVy7YPNP_zI").start(10).answerVariants(List.of("Skyrim", "God of War", "Викинги", "Властелин Колец")).rightAnswer("Skyrim").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("FSVHx23ByhM").start(8).answerVariants(List.of("Медичи", "Assassin's Creed", "Игра престолов", "Ведьмак")).rightAnswer("Assassin's Creed").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("FSVHx23ByhM").start(8).answerVariants(List.of("Медичи", "Assassin's Creed", "Игра престолов", "Ведьмак")).rightAnswer("Assassin's Creed").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("CnQm2_cAZvo").start(8).answerVariants(List.of("Терминатор", "Cyberpunk 2077", "Бегущий по лезивю", "Battlefield")).rightAnswer("Терминатор").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("CnQm2_cAZvo").start(8).answerVariants(List.of("Терминатор", "Cyberpunk 2077", "Бегущий по лезивю", "Battlefield")).rightAnswer("Терминатор").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("А что по Кубрику?").video("FfHrryY5UL0").start(8).answerVariants(List.of("Заводной апельсин", "Сияния", "Космическая Одиссея 2001", "С широко закрытыми глазами")).rightAnswer("Заводной апельсин").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("А что по Кубрику?").video("FfHrryY5UL0").start(8).answerVariants(List.of("Заводной апельсин", "Сияния", "Космическая Одиссея 2001", "С широко закрытыми глазами")).rightAnswer("Заводной апельсин").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда трек?").video("QK-Z1K67uaA").start(0).answerVariants(List.of("Леон", "Таксист", "Амели", "500 дней лета")).rightAnswer("Леон").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда трек?").video("QK-Z1K67uaA").start(0).answerVariants(List.of("Леон", "Таксист", "Амели", "500 дней лета")).rightAnswer("Леон").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Аниме, пацаны?").video("3bBpiHJm3t0").start(0).answerVariants(List.of("Sailor Moon", "Атака Титанов", "Наруто", "Токийский Гуль")).rightAnswer("Sailor Moon").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Аниме, пацаны?").video("3bBpiHJm3t0").start(0).answerVariants(List.of("Sailor Moon", "Атака Титанов", "Наруто", "Токийский Гуль")).rightAnswer("Sailor Moon").type(ANSWER).build(),

                        Screen.builder().type(RESULTS).build(),

                        Round.builder().title("Hans Zimmer Time").type(ROUND).timer(TIMER).build(),

                        Question.builder().questionType("audio").text("Откуда саундтрек?").video("UDVtMYqUAyw").start(21).answerVariants(List.of("Interstellar", "Начало", "Темный Рыцарь", "Crysis")).rightAnswer("Interstellar").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда саундтрек?").video("UDVtMYqUAyw").start(21).answerVariants(List.of("Interstellar", "Начало", "Темный Рыцарь", "Crysis")).rightAnswer("Interstellar").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда саундтрек?").video("RxabLA7UQ9k").start(0).answerVariants(List.of("Interstellar", "Начало", "Помни", "Crysis")).rightAnswer("Начало").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда саундтрек?").video("RxabLA7UQ9k").start(0).answerVariants(List.of("Interstellar", "Начало", "Помни", "Crysis")).rightAnswer("Начало").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда саундтрек?").video("iGx5a1ifSDs").start(43).answerVariants(List.of("Interstellar", "Начало", "Престиж", "Темный рыцарь")).rightAnswer("Темный рыцарь").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда саундтрек?").video("iGx5a1ifSDs").start(43).answerVariants(List.of("Interstellar", "Начало", "Престиж", "Темный рыцарь")).rightAnswer("Темный рыцарь").type(ANSWER).build(),

                        Question.builder().questionType("audio").text("Откуда саундтрек?").video("Iy4iQvJo24U").start(0).answerVariants(List.of("Interstellar", "Начало", "Crysis", "Темный рыцарь")).rightAnswer("Crysis").type(QUESTION).build(),
                        Question.builder().questionType("audio").text("Откуда саундтрек?").video("Iy4iQvJo24U").start(0).answerVariants(List.of("Interstellar", "Начало", "Crysis", "Темный рыцарь")).rightAnswer("Crysis").type(ANSWER).build(),

                        Screen.builder().type(RESULTS).timer(TIMER).build(),

                        Round.builder().title("Что было дальше?").type(ROUND).timer(TIMER).build(),

                        Question.builder().questionType("video").text("Что было дальше?").video("WREgLyUWZLk").start(20).duration(19).answerVariants(List.of("Машина", "Велосипеды", "Скутеры", "Ничего")).rightAnswer("Скутеры").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("WREgLyUWZLk").start(39).duration(7).answerVariants(List.of("Машина", "Велосипеды", "Скутеры", "Ничего")).rightAnswer("Скутеры").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что сказал Уолтер Вайт?").video("LhKJrWfflfM").start(140).duration(24).answerVariants(List.of("Это не мет", "Я не один", "Это лучше, чем мет", "Это могу делать только я")).rightAnswer("Это не мет").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что сказал Уолтер Вайт?").video("LhKJrWfflfM").start(164).duration(10).answerVariants(List.of("Это не мет", "Я не один", "Это лучше, чем мет", "Это могу делать только я")).rightAnswer("Это не мет").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Как же называют в Европе четвертьфунтовый с сыром?").video("N8uc_D_4KCI").start(60).duration(14).answerVariants(List.of("Биг мак", "Чизбургер", "Рояль с сыром", "Гамбургер с сыром")).rightAnswer("Рояль с сыром").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Как же называют в Европе четвертьфунтовый с сыром?").video("N8uc_D_4KCI").start(74).duration(86).answerVariants(List.of("Биг мак", "Чизбургер", "Рояль с сыром", "Гамбургер с сыром")).rightAnswer("Рояль с сыром").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что скажет Оби-Ван?").video("bSyaeyGg8Rc").start(129).duration(21).answerVariants(List.of("Я стою выше тебя", "Я сильнее тебя", "Сила течет во мне и я един с силой", "Ты недооцениваешь мою мощь")).rightAnswer("Я стою выше тебя").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что скажет Оби-Ван?").video("bSyaeyGg8Rc").start(150).duration(15).answerVariants(List.of("Я стою выше тебя", "Я сильнее тебя", "Сила течет во мне и я един с силой", "Ты недооцениваешь мою мощь")).rightAnswer("Я стою выше тебя").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что скажет Гендальф?").video("11CjihGZIOU").start(86).duration(43).answerVariants(List.of("Бегите", "Не прошел", "Спасите", "Помогите")).rightAnswer("Бегите").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что скажет Гендальф?").video("11CjihGZIOU").start(129).duration(5).answerVariants(List.of("Бегите", "Не прошел", "Спасите", "Помогите")).rightAnswer("Бегите").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Как звучит это непростительное заклинание?").video("t-dEtCBeu4g").start(222).duration(30).answerVariants(List.of("Круциатус", "Империус", "Авада Кедавра")).rightAnswer("Авада Кедавра").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Как звучит это непростительное заклинание?").video("t-dEtCBeu4g").start(252).duration(15).answerVariants(List.of("Круциатус", "Империус", "Авада Кедавра")).rightAnswer("Авада Кедавра").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что было дальше?").video("b_53by55uLA").start(29).duration(23).answerVariants(List.of("ДТП", "Выстрел", "Вопрос о божественном вмешательстве", "Наезд на человека")).rightAnswer("Выстрел").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что было дальше?").video("b_53by55uLA").start(52).duration(11).answerVariants(List.of("ДТП", "Выстрел", "Вопрос о божественном вмешательстве", "Наезд на человека")).rightAnswer("Выстрел").type(ANSWER).build(),

                        Question.builder().questionType("video").text("Что же это?").video("ojhXYcmTq7c").start(113).duration(6).answerVariants(List.of("Это рисунок ключика", "Карта", "Ключ к сундуку Дэйви Джонса", "То, что нужно открыть")).rightAnswer("Это рисунок ключика").type(QUESTION).build(),
                        Question.builder().questionType("video").text("Что же это?").video("ojhXYcmTq7c").start(113).duration(6).answerVariants(List.of("Это рисунок ключика", "Карта", "Ключ к сундуку Дэйви Джонса", "То, что нужно открыть")).rightAnswer("Это рисунок ключика").type(ANSWER).build(),

                        Round.builder().title("Финальные результаты").type(ROUND).timer(TIMER).build(),
                        Screen.builder().type(RESULTS).timer(TIMER).build()*/
                )
        );
        this.games = List.of(
                game
        );
    }

    public Game addGame(Game game) {
        this.games.add(game);
        return game;
    }

    public Game getGame(String id) {
        return this.games.stream().filter(i -> i.getId().equals(id)).findFirst().get();
    }

    public List<Game> list() {
        return this.games;
    }

}
