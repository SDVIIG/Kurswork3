import dto.KostilDto;
import dto.RoomDto;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class TicTacToeForm extends JComponent {

    public Client client = new Client();
    public RoomDto roomDto;
    public String roomId;
    public String nickName;

    public TicTacToeForm(String roomId, String nickName) {
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        this.roomId = roomId;
        this.nickName = nickName;
        Thread thread = new UpdateRoom(this);
        thread.start();
    }

    @Override
    protected void processMouseEvent(MouseEvent mouseEvent) {
        super.processMouseEvent(mouseEvent);
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
            int x = mouseEvent.getX();
            int y = mouseEvent.getY();

            int i = (int) ((float) x / getWidth() * 3);
            int j = (int) ((float) y / getHeight() * 3);

            int index = antiKostil(i, j);

            if (roomDto.getTable().get(index) == null) {
                try {
                    client.setTable(roomId, nickName, index);
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(TicTacToeForm.this,
                            e.getMessage());
                }
            }
            repaint();
        }
    }

    void drawXO(Graphics graphics) {
        for (int i = 0; i < roomDto.getTable().size(); i++) {

            if (roomDto.getTable().get(i) == null) {
                continue;
            }

            KostilDto kostilDto = kostil(i);
            switch (roomDto.getTable().get(i)) {
                case O:
                    drawO(kostilDto.getI(), kostilDto.getJ(), graphics);
                    break;
                case X:
                    drawX(kostilDto.getI(), kostilDto.getJ(), graphics);
                    break;
                default:
                    break;
            }
        }
    }

    private int antiKostil(int i, int j) {
        switch (i) {
            case 0:
                switch (j) {
                    case 0:
                        return 0;
                    case 1:
                        return 3;
                    case 2:
                        return 6;
                }
            case 1:
                switch (j) {
                    case 0:
                        return 1;
                    case 1:
                        return 4;
                    case 2:
                        return 7;
                }
            case 2:
                switch (j) {
                    case 0:
                        return 2;
                    case 1:
                        return 5;
                    case 2:
                        return 8;
                }
        }
        return 666;
    }

    private KostilDto kostil(int i) {
        switch (i) {
            case 0:
                return new KostilDto(0, 0);
            case 1:
                return new KostilDto(1, 0);
            case 2:
                return new KostilDto(2, 0);
            case 3:
                return new KostilDto(0, 1);
            case 4:
                return new KostilDto(1, 1);
            case 5:
                return new KostilDto(2, 1);
            case 6:
                return new KostilDto(0, 2);
            case 7:
                return new KostilDto(1, 2);
            case 8:
                return new KostilDto(2, 2);
            default:
                return null;
        }
    }

    void drawX(int i, int j, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        int dw = getWidth() / 3;
        int dh = getHeight() / 3;
        int x = i * dw;
        int y = j * dh;

        graphics.drawLine(x, y, x + dw, y + dh);
        graphics.drawLine(x, y + dh, x + dw, y);
    }

    void drawO(int i, int j, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        int dw = getWidth() / 3;
        int dh = getHeight() / 3;
        int x = i * dw;
        int y = j * dh;

        graphics.drawOval(x + 5 * dw / 100, y, dw * 9 / 10, dh);
    }

    @SneakyThrows
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.clearRect(0, 0, getWidth(), getHeight());
        try {
            roomDto = client.getRoom(roomId, nickName);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(TicTacToeForm.this,
                    e.getMessage());
        }
        gradGrid(graphics);
        drawXO(graphics);
    }

    void gradGrid(Graphics graphics) {
        int w = getWidth();
        int h = getHeight();
        int dw = w / 3;
        int dh = h / 3;
        graphics.setColor(Color.BLUE);
        for (int i = 1; i < 3; i++) {
            graphics.drawLine(0, dh * i, w, dh * i);
            graphics.drawLine(dw * i, 0, dw * i, h);
        }
    }
}
