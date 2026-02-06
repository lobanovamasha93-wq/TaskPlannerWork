package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldMatchSimpleTaskExactQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить хлеб");
        boolean matches = simpleTask.matches("хлеб");
        Assertions.assertTrue(matches);
    }

    @Test
    public void shouldNotMatchSimpleTaskIncorrectQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить хлеб");
        boolean matches = simpleTask.matches("Молоко");
        Assertions.assertFalse(matches);
    }

    @Test
    public void shouldMatchEpicSubtask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);
        boolean matches = epic.matches("Яйца");
        Assertions.assertTrue(matches);
    }

    @Test
    public void shouldNotMatchEpicIncorrectQuery() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);
        boolean matches = epic.matches("Масло");
        Assertions.assertFalse(matches);
    }

    @Test
    public void shouldMatchMeetingTopic() {
        Meeting meeting = new Meeting(3, "Выкатка 3й версии", "Приложение НетоБанка", "Во вторник");
        boolean matches = meeting.matches("версии");
        Assertions.assertTrue(matches);
    }

    @Test
    public void shouldMatchMeetingProject() {
        Meeting meeting = new Meeting(3, "Выкатка 3й версии", "Приложение НетоБанка", "Во вторник");
        boolean matches = meeting.matches("НетоБанка");
        Assertions.assertTrue(matches);
    }

    @Test
    public void shouldNotMatchMeetingIncorrectQuery() {
        Meeting meeting = new Meeting(3, "Выкатка 3й версии", "Приложение НетоБанка", "Во вторник");
        boolean matches = meeting.matches("Среда");
        Assertions.assertFalse(matches);
    }
}
