package ru.geekbrains.alexkrasnova.javalevelone.lesson8.version1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessNumberGameForm extends JFrame {

    int rightAnswer;
    int userAnswer;
    int maxTryCount = 3;
    int tryCount;

    GuessNumberGameForm() {
        setBounds(300, 100, 400, 250);
        setTitle("Игра \"Угадай число\"");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        add(topPanel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        topPanel.add(textArea);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        add(rightPanel, BorderLayout.EAST);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        add(leftPanel, BorderLayout.WEST);

        JPanel centralPanel = new JPanel(new GridLayout(2, 2, 5, 0));
        centralPanel.setBackground(Color.WHITE);
        add(centralPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        add(bottomPanel, BorderLayout.SOUTH);

        JTextField answerField = new JTextField();
        centralPanel.add(answerField);

        JButton loadAnswerButton = new JButton("Ответить");
        centralPanel.add(loadAnswerButton);

        loadAnswerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userAnswer = Integer.parseInt(answerField.getText());
                if (tryCount <= maxTryCount) {
                    handleNewTry(textArea);
                }
            }
        });

        JButton newGameButton = new JButton("Новая игра");
        centralPanel.add(newGameButton);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame(textArea);
            }
        });

        JButton quitButton = new JButton("Выйти");
        centralPanel.add(quitButton);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });


        setVisible(true);

        startGame(textArea);
    }

    public void changeTextAreaText(JTextArea textArea, String text) {
        textArea.setText(text);
    }

    public void startGame(JTextArea textArea) {
        tryCount = 1;
        rightAnswer = new Random().nextInt(10);
        changeTextAreaText(textArea, "Привет, давай сыграем в игру \"Угадай число\". \nЯ загадал тебе число от 0 до 9, попробуй его угадать.\nМаксимальное число попыток: " + maxTryCount + ".\nВведи целое число от 0 до 9:");
    }

    public void handleNewTry(JTextArea textArea) {

        if (userAnswer == rightAnswer) {
            textArea.setText("Поздравляю, ты угадал!");
            tryCount = maxTryCount + 1;
            return;
        } else if (tryCount >= maxTryCount) {
            textArea.setText("Ты проиграл. Правильный ответ: " + rightAnswer + ".");
            return;
        } else if (userAnswer < rightAnswer) {
            textArea.setText("Ты ввел слишком маленькое число, попробуй еще раз. \nОсталось попыток: " + (maxTryCount - tryCount) + ".");
        } else {
            textArea.setText("Ты ввел слишком большое число, попробуй еще раз. \nОсталось попыток: " + (maxTryCount - tryCount) + ".");
        }
        tryCount++;
    }
}
