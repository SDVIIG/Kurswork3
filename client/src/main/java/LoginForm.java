import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    JTextField roomId;
    JTextField nickName;
    JButton button;
    Client client = new Client();

    public LoginForm() {
        super("TicTacToe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Создание текстовых полей
        roomId = new JTextField(15);
        nickName = new JTextField(15);

        button = new JButton("Create room");
        button.setBounds(50, 100, 95, 30);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (roomId.getText().equals("")) {
                    if (nickName.getText().equals("")) {
                        JOptionPane.showMessageDialog(LoginForm.this,
                                "Поле имени должно быть заполнено");
                    } else {
                        try {
                            String id = client.createRoom(nickName.getText());
                            roomId.setText(id);
                            button.setText("Join room");
                        } catch (RuntimeException error) {
                            JOptionPane.showMessageDialog(LoginForm.this,
                                    error.getMessage());
                        }
                    }
                } else {
                    if (nickName.getText().equals("")) {
                        JOptionPane.showMessageDialog(LoginForm.this,
                                "Поле имени должно быть заполнено");
                    } else {
                        try {
                            client.getRoom(roomId.getText(), nickName.getText());
                            startGame(roomId.getText(), nickName.getText());
                        } catch (RuntimeException error) {
                            JOptionPane.showMessageDialog(LoginForm.this,
                                    error.getMessage());
                        }
                    }
                }
            }
        });

        JPanel contents = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel l1 = new JLabel("Room ID");
        JLabel l2 = new JLabel("Nickname");

        contents.add(roomId);
        contents.add(l1);
        contents.add(nickName);
        contents.add(l2);
        contents.add(button);
        setContentPane(contents);
        setSize(400, 130);
        setVisible(true);
    }

    public void startGame(String roomId, String nickName) {
        JFrame window = new JFrame("TicTacToe");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setLayout(new BorderLayout());
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        TicTacToeForm game = new TicTacToeForm(roomId, nickName);
        window.add(game);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}