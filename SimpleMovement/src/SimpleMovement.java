import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class SimpleMovement extends JPanel implements ActionListener, KeyListener{
    private BufferedImage image; // object
    private int xPosition = 10; // start x position
    private int yPosition = 10; // start y position


    public SimpleMovement() {
        try {
            image = ImageIO.read(new File("C:\\Users\\New\\Downloads\\grass.jpg"));
        } catch (IOException e) {
            System.out.println(e);
        }

        // Добавляем слушателя для клавиатуры
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public void keyPressed(KeyEvent e) {
        // Проверяем, какая клавиша была нажата
        boolean isShiftPressed = e.isShiftDown(); // Проверяем, нажата ли клавиша Shift

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                // для одиночного нажатия
                //                if (!wPressed) {  Если 'W' ещё не нажата
                //                    increaseYPosition();
                //                    wPressed = true;  Устанавливаем флаг
                if (isShiftPressed) {
                    increaseYPosition();
                    increaseYPosition();
                } else
                    increaseYPosition();
                break;
            case KeyEvent.VK_A:
                if (isShiftPressed) {
                   decreaseXPosition();
                   decreaseXPosition();
                } else
                    decreaseXPosition();
                break;
            case KeyEvent.VK_S:
                if (isShiftPressed) {
                   decreaseYPosition();
                   decreaseYPosition();
                } else
                    decreaseYPosition();
                break;
            case KeyEvent.VK_D:
                if (isShiftPressed) {
                   increaseXPosition();
                   increaseXPosition();
                } else
                    increaseXPosition();
                break;
            default:
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
//        case KeyEvent.VK_W:
//        wPressed = false; // Сбрасываем флаг 'W'
//        break;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Этот метод можно оставить пустым, если не требуется дополнительной обработки
    }
    @Override

    public void actionPerformed(ActionEvent e) {
        // Метод для обработки событий действий (но он не используется в текущем контексте)
    }

    // Метод для отрисовки изображения
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, xPosition, yPosition, this);
    }

    // Увеличение позиции по X
    public void increaseXPosition() {
        if (xPosition < getWidth()-50)
            xPosition += 50;
        else
            xPosition = 0;
        repaint();
    }

    // Уменьшение позиции по X
    public void decreaseXPosition() {
        if (xPosition > 50)
            xPosition -= 50;
        else
            xPosition = getWidth()-50;
        repaint();
    }

    // Увеличение позиции по Y
    public void increaseYPosition() {
        if (yPosition > 50)
            yPosition -= 50;
        else
            yPosition = getHeight()-50;
        repaint();
    }

    // Уменьшение позиции по Y
    public void decreaseYPosition() {
        if (yPosition < getHeight()-50)
            yPosition += 50;
        else
            yPosition = 0;
        repaint();
    }

}
