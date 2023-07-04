package view_Author;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.AuthorControler;
import main.Main;
import model.Author;
import structure.System_to_run;

public class RemoveAuthor extends JDialog implements ActionListener {

	private JComboBox<Author> listAuthor;
	private Button cancel, accept;
	private JLabel name;

	private JPanel panel;

	public RemoveAuthor(JFrame owner, String title, boolean modal) {
		super(owner, title, modal);
		dialogInit();
	}

	public RemoveAuthor(JFrame owner, boolean modal, int height, int width) {
		this(owner, "Remove Author", modal);

		this.panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(215, 217, 224, 255));
		getContentPane().add(panel); // se crea esta linea en el JFrame

		this.name = new JLabel("Author: ");

		this.listAuthor = new JComboBox<Author>();

		this.cancel = new Button("Cancel");
		this.accept = new Button("Accept");

		cancel.addActionListener(this);
		accept.addActionListener(this);

		setSize(width, height);
		structureJPanel();

		// localizacion encima del jframe
		System_to_run miPc = new System_to_run();

		this.setLocation(miPc.widthCenterSystem() + 200, miPc.heighCenterSystem() / 2);
		// al poner +200 y /2 estamos desplazando el jpanel lo bastante para que cuando
		// lo creemos se siga viendo el jfram

		setVisible(true);

	}

	private void structureJPanel() {

		int fontSize = 20;
		int labelPaddingLeft = 20;
		int upBottonPadding = 20;
		int spaceUpButton = 80;

		int heightText = 30;
		int textPaddingLeft = labelPaddingLeft + 100;
		int upTextPadding = 25;
		int widthText = super.getWidth() - textPaddingLeft - labelPaddingLeft;

		int botonHeight = super.getHeight() / 5;
		int botonWidth = super.getWidth() / 5;
		
		System.out.println("*** BOTONESSSS "+botonHeight +"SSS"+botonWidth);

		name.setFont(new Font("Serif", Font.BOLD, fontSize));
		name.setBounds(labelPaddingLeft, upBottonPadding, 100, 40);

		listAuthor.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		for (int i = 0; i < Main.writers.size(); i++) {

			listAuthor.addItem(Main.writers.get(i));
		}

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;

		cancel.setBounds(textPaddingLeft, upTextPadding, botonWidth, botonHeight);
		accept.setBounds(textPaddingLeft + 300, upTextPadding, botonWidth, botonHeight);

		panel.add(name);
		panel.add(listAuthor);

		// Jbutton
		panel.add(cancel);
		panel.add(accept);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cancel) {

			// estaria bien poner un mensaje emerjente ue avise de que no se va a guardar la
			// informacion por el momento solo se cierra

			// this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			// borrar
			
			// llama a el proceso de windows y actua como si le diesemos a la X para cerra
			// la ventana
			dispose();
		}
		if (e.getSource() == accept) {

			AuthorControler ct = new AuthorControler(this);
			// se le envia por parametro el JDialog que lo llama para que sepa donde tiene
			// que aparecer en el caso de que captura un error
			int answer = JOptionPane.showConfirmDialog(null, "It will delete the Author . Are you sure?", "Confirm ",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (answer == JOptionPane.YES_OPTION) {
				ct.removeAuthor((Author)listAuthor.getSelectedItem());

				this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
				
			}
		
		}

	}

}
