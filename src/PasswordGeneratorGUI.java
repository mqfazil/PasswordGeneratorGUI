import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//frontend of the code
public class PasswordGeneratorGUI extends JFrame {
    private PasswordGenerator passwordGenerator;

    public PasswordGeneratorGUI() {
        //title
        super("Password Generator");

        //size of GUI
        setSize(440,570);

        //set perm size
        setResizable(false);

        //set layout to null
        setLayout(null);

        //terminate program when closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //center GUI to screen
        setLocationRelativeTo(null);

        //init password generator
        passwordGenerator = new PasswordGenerator();

        //render GUI
        addGUIComponents();
    }
    public void addGUIComponents() {
        //title text
        JLabel titleLabel = new JLabel("Password Generator");

        //title bold/font size
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));

        //center text
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //set x,y coordinates and width/height values
        titleLabel.setBounds(0, 45, 440, 39);

        //add to GUI
        add(titleLabel);

        //result text area
        JTextArea passwordOutput = new JTextArea();

        //prevent editing of text area
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));

        //add scroll in case output is long
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25,97,379,70);

        //border around area
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.black));
        add(passwordOutputPane);

        //password length label
        JLabel passwordLengthLabel = new JLabel("Password Length:");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        passwordLengthLabel.setBounds(25,215,372,39);
        add(passwordLengthLabel);

        //password length input
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 20));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.black));
        passwordLengthInputArea.setBounds(210,215,192,39);
        add(passwordLengthInputArea);


        //toggle buttons
        //uppercase letter toggle
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 20));
        uppercaseToggle.setBounds(25,302,180,60);
        add(uppercaseToggle);

        //lowercase letter toggle
        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 20));
        lowercaseToggle.setBounds(225,302,180,60);
        add(lowercaseToggle);

        //numbers toggle
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 20));
        numbersToggle.setBounds(25,373,180,60);
        add(numbersToggle);

        //symbols toggle
        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 20));
        symbolsToggle.setBounds(225,373,180,60);
        add(symbolsToggle);

        //generate button
        JToggleButton generateButton = new JToggleButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        generateButton.setBounds(125,443,180,60);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passwordLengthInputArea.getText().length() <= 0) return;
                boolean anyToggleSelected = lowercaseToggle.isSelected() || uppercaseToggle.isSelected()
                        || numbersToggle.isSelected() || symbolsToggle.isSelected();

                //generate password
                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                if(anyToggleSelected) {
                    String generatedPassword = passwordGenerator.generatePassword(passwordLength,
                            uppercaseToggle.isSelected(), lowercaseToggle.isSelected(),
                            numbersToggle.isSelected(), symbolsToggle.isSelected());

                    //display password back to user
                    passwordOutput.setText(generatedPassword);
                }
            }
        });
        add(generateButton);


    }
}













