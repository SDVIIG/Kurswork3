import dto.RoomPlayerDto;
import dto.RoomStatus;
import lombok.SneakyThrows;

import javax.swing.*;
import java.util.List;

public class UpdateRoom extends Thread {
    private final TicTacToeForm ticTacToeForm;
    private boolean update = true;

    public UpdateRoom(TicTacToeForm ticTacToeForm) {
        this.ticTacToeForm = ticTacToeForm;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (update) {
            try {
                ticTacToeForm.roomDto = ticTacToeForm.client.getRoom(ticTacToeForm.roomId, ticTacToeForm.nickName);
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(ticTacToeForm,
                        e.getMessage());
                update = false;
            }
            ticTacToeForm.repaint();

            if (ticTacToeForm.roomDto.getStatus() == RoomStatus.WIN) {
                List<RoomPlayerDto> players = ticTacToeForm.roomDto.getPlayers();

                for (RoomPlayerDto player : players) {
                    if (player.getNickname().equals(ticTacToeForm.nickName)) {
                        if (player.isWin()) {
                            JOptionPane.showMessageDialog(ticTacToeForm,
                                    "Вы выиграли");
                        } else {
                            JOptionPane.showMessageDialog(ticTacToeForm,
                                    "Вы проиграли");
                        }
                        update = false;
                    }
                }
            }
            sleep(2000);
        }
    }
}
