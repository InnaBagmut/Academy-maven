@LoginProfile
Feature: Тестируем страницу авторизации
  As an employee of the company
  I want to login my employee profile using my credentials
  In order to collaborate with my colleagues

  Scenario: Успешная авторизация
    Given Я нахожусь на домашней странице
    Then Я нажимаю ссылку signIn
    When Ввожу логин '<логин>'
    And Ввожу пароль '<пароль>'
    And нажимаю отправить
    Then Я ожидаю увидеть 'Oleg Afanasiev' link
    Then Нажимаю logout