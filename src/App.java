import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;

public class App {
    private JPanel panel_WTHR;
    private JToolBar toolbar_first;
    private JTextField search_text;
    private JButton findButton;
    private JLabel state_label;
    private JTextArea main_textarea;
    private JRadioButton bot_radioButton;
    private JRadioButton top_radioButton;

    public App() {
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//              Set the colors of the State label
                state_label.setForeground(Color.getColor("226,221,95"));
                state_label.setText("READY");


//              Set the chat & save previous chat records.
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                System.out.println("User input.." + search_text.getText());
                String history = main_textarea.getText() + "\n";
                String chatUser;


//              Print out the to the chat.
                if(bot_radioButton.isSelected() && top_radioButton.isSelected()){
                    System.out.println("Issue: Two users are currently selected; Only one user should be selected!");
//                    Send this error to the user in the GUI change state label.
                    state_label.setForeground(Color.getColor("226,53,54"));
                    state_label.setText("Only one user should be selected!");

                }
                else if(bot_radioButton.isSelected()){
                    chatUser = bot_radioButton.getText();
                    main_textarea.setText(history + chatUser +": [" + timestamp + "]: " + search_text.getText());
                    search_text.setText("");
                }
                else if(top_radioButton.isSelected()){
                    chatUser = top_radioButton.getText();
                    main_textarea.setText(history + chatUser +": [" + timestamp + "]: " + search_text.getText());
                    search_text.setText("");
                }
                else{
                    System.out.println("No User is selected!");
                }

            }
        });
        search_text.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                System.out.println("Action at search text");
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        search_text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent enter) {
                super.keyPressed(enter);

//                System.out.println("Enter key was pressed.");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DELETE THIS v2.0");
        frame.setContentPane(new App().panel_WTHR);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
