package ru.geekbrains.alexkrasnova.javalevelone.lesson8.version2.game.ui;

import ru.geekbrains.alexkrasnova.javalevelone.lesson8.version2.game.GuessNumberGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicsUI extends JFrame implements UI {

    private final JTextArea textArea = new JTextArea();

    private final JTextField answerField = new JTextField();

    private volatile boolean waitingForAnswer = false;

    @Override
    public int getNumberFromUser() {
        waitingForAnswer = true;
        //Ждем, пока пользователь нажмет на кнопку Ответить
        while (waitingForAnswer) {

        }
        //Потом забираем из поля answerField значение
        return Integer.parseInt(answerField.getText());
    }

    @Override
    public void showMessage(String message) {
        textArea.setText(message);
    }

    public GraphicsUI() {

        setBounds(300, 100, 400, 250);
        setTitle("Игра \"Угадай число\"");
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        add(topPanel, BorderLayout.NORTH);

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

        centralPanel.add(answerField);

        JButton loadAnswerButton = new JButton("Ответить");
        centralPanel.add(loadAnswerButton);

        loadAnswerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                waitingForAnswer = false;
            }
        });

        JButton newGameButton = new JButton("Новая игра");
        centralPanel.add(newGameButton);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> new GuessNumberGame(GraphicsUI.this, 10, 0, 9).play()).start();
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

        new Thread(() -> new GuessNumberGame(GraphicsUI.this).play()).start();
    }
}
