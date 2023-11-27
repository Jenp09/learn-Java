import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Game extends JFrame {

	private JPanel contentPane;
	private JButton shuffleButton, solutionButton, enterButton, clrButton, resetButton;
	private JPanel lettersContainer;
	private JTextField input;
	List<String> words = new ArrayList<>(Arrays.asList("maternity", "Gentleman", "confident"));
	ArrayList<Character> wordLetters = new ArrayList<>();

	JButton[] lettersButtons = new JButton[9];
	Font myFont = new Font("Benne", Font.BOLD, 14);

	JButton letterButton1, letterButton2, letterButton3, letterButton4, letterButton5, letterButton6, letterButton7,
			letterButton8, letterButton9;

	boolean btn1Clickable, btn2Clickable, btn3Clickable, btn4Clickable, btn5Clickable, btn6Clickable, btn7Clickable,
			btn8Clickable, btn9Clickable;

	public static void main(String[] args) {
		Game wordsGame = new Game();
		wordsGame.setTitle("Word Game");
		Game frame = new Game();
		frame.setVisible(true);

	}

	public Game() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(creatTargetLabel());

		contentPane.add(lettersButtonsBox());

		contentPane.add(shuffleButton());
		contentPane.add(input());
		contentPane.add(enterButton());
		contentPane.add(clrButton());
		contentPane.add(solutionButton());
		contentPane.add(resetButton());

	}

	public JTextField input() {
		JTextField input = new JTextField();
		input.setBounds(220, 100, 359, 30);
		input.setLocation(140, 350);
		input.setFont(myFont);

		return input;

	}

	private JLabel creatTargetLabel() {
		JLabel target = new JLabel("Target");
		target.setFont(new Font("Tahoma", Font.PLAIN, 15));
		target.setHorizontalAlignment(SwingConstants.CENTER);
		target.setBounds(225, 23, 199, 50);
		return target;
	}

	private JPanel lettersButtonsBox() {
		lettersContainer = new JPanel(new GridLayout(3, 3, 0, 0));
		lettersContainer.setBounds(142, 92, 355, 234);

		for (int index = 0; index < lettersButtons.length; index++) {
			wordLetters.add(words.get(0).charAt(index));
			lettersButtons[index] = new JButton();
			lettersButtons[index].setFocusable(false);
			lettersButtons[index].setText((wordLetters.get(index) + "").toUpperCase());
			lettersButtons[index].addActionListener(new letterClickedListner());
			lettersContainer.add(lettersButtons[index]);

		}
		return lettersContainer;
	}

	private JButton enterButton() {
		enterButton = new JButton("Enter");
		enterButton.setBounds(500, 350, 70, 30);
		return enterButton;

	}

	private JButton resetButton() {
		resetButton = new JButton("Reset");
		resetButton.setBounds(350, 400, 80, 30);
		return resetButton;
	}

	private JButton clrButton() {
		clrButton = new JButton("Clear");
		clrButton.setBounds(200, 400, 80, 30);

		clrButton.addActionListener(e -> {

			input.setText("");

		});
		return clrButton;
	}

	private JButton solutionButton() {
		solutionButton = new JButton("Solution");
		solutionButton.setBounds(20, 190, 100, 30);
		return solutionButton;
	}

	private JButton shuffleButton() {

		shuffleButton = new JButton("Shuffle");
		shuffleButton.setFont(new Font("Benne", Font.BOLD, 12));
		shuffleButton.setBounds(20, 150, 100, 30);

		// contentPane.add(shuffleButton);

		shuffleButton.addActionListener(x -> {

			Collections.shuffle(wordLetters);

			for (int index = 0; index < lettersButtons.length; index++) {
				lettersButtons[index].setText((wordLetters.get(index) + "").toUpperCase());
				lettersContainer.add(lettersButtons[index]);

			}

		});
		return shuffleButton;

	}

	private class letterClickedListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent letter) {
			for (JButton lettersButton : lettersButtons) {
				shuffleButton.setEnabled(true);
				if (letter.getSource() == lettersButton) {
					lettersButton.setEnabled(false);
					input.setText(input.getText() + lettersButton.getText());
					// System.out.println(lettersButton.getText());

				}
			}
		}

	}
}
