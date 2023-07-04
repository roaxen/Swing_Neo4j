package view_Author;

import javax.swing.*;

import color.GrisMetal;
import main.Main;
import model.Author;
import structure.System_to_run;

import java.awt.*;
import java.awt.event.*;

public class ModifyAuthor extends JDialog implements ActionListener {
    
    private JLabel selectLabel, nameLabel, surnameLabel, surname2Label, contryLabel;
    private JComboBox<Author> listAuthor;
    private JTextField nameField, surnameField, surname2Field, contryField;
    private Button cancelButton, acceptButton, loadButton;
    private Author selectAuthor;
    private JPanel panel;
    
	public ModifyAuthor(JFrame owner, String title, boolean modal) {
		super(owner, title, modal);
		dialogInit();
	}

	public ModifyAuthor(JFrame owner, boolean modal, int height, int width) {
		
		this(owner, "***********", modal);
		
		this.panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new GrisMetal());
		getContentPane().add(panel); 
		
		
        // Componentes para la selección de autor
        selectLabel = new JLabel("Selecciona un autor:");
        listAuthor = new JComboBox<Author>();
        loadButton = new Button("Cargar");
     
        // Componentes para la modificación de autor
        nameLabel = new JLabel("Name:");
        surnameLabel = new JLabel("Surname:");
        surname2Label = new JLabel("Second Surname: ");
        contryLabel = new JLabel("Contry:");
        
        nameField = new JTextField();
        surnameField = new JTextField();
        surname2Field = new JTextField();
        contryField = new JTextField();
        
        // Componentes para los botones de acción
        cancelButton = new Button("Cancelar");
        acceptButton = new Button("Aceptar");
        
        
        cancelButton.addActionListener(this);
        acceptButton.addActionListener(this);
        loadButton.addActionListener(this);
        
    	setSize(width, height);
    	structureJPanel();
        
    	System_to_run miPc = new System_to_run();
    	this.setLocation(miPc.widthCenterSystem() + 200, miPc.heighCenterSystem() / 2);
//        for (int i = 0; i < Main.writers.size(); i++) {
//
//			listAuthor.addItem(Main.writers.get(i));
//		}
        
        // Crear paneles para organizar los componentes
      
        
        // Configurar la ventana
//        pack();
        //setLocationRelativeTo(parent);
//        setResizable(false);
        setVisible(true);
    }
    
	
	
	public void structureJPanel() {
		int fontSize = 20;
		int labelPaddingLeft = 20;
		int upBottonPadding = 20;
		int spaceUpButton = 80;

		int heightText = 30;
		int textPaddingLeft = labelPaddingLeft + 200;
		int upTextPadding = 25;
		int widthText = super.getWidth() - textPaddingLeft - labelPaddingLeft;
		int botonHeightLoad = 40;
		int botonWidthLoad = 70;
		
		int botonHeight = super.getHeight() / 10;
		int botonWidth = super.getWidth() / 10;
		
		selectLabel.setFont(new Font("Serif", Font.BOLD, fontSize));
		selectLabel.setBounds(labelPaddingLeft, upBottonPadding, 200, 40);
		
		listAuthor.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		for (int i = 0; i < Main.writers.size(); i++) {

			listAuthor.addItem(Main.writers.get(i));
		}
		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;
		
		loadButton.setBounds(textPaddingLeft + 200, 70, botonWidthLoad, botonHeightLoad);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;
		
		
		nameLabel.setFont(new Font("Serif", Font.BOLD, fontSize));
		nameLabel.setBounds(labelPaddingLeft, upBottonPadding, 100, 40);
		
		nameField.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;

		// ------------------ tercera FILA ****************************************
		surnameLabel.setFont(new Font("Serif", Font.BOLD, fontSize));
		surnameLabel.setBounds(labelPaddingLeft, upBottonPadding, 160, 40);
				// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		surnameField.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;
				
		// ------------------ SEGUNDA FILA ****************************************
		surname2Label.setFont(new Font("Serif", Font.BOLD, fontSize));
		surname2Label.setBounds(labelPaddingLeft, upBottonPadding, 200, 40);
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		surname2Field.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;
		
		
		// ------------------ cuarta FILA ****************************************
		contryLabel.setFont(new Font("Serif", Font.BOLD, fontSize));
		contryLabel.setBounds(labelPaddingLeft, upBottonPadding, 160, 40);
		// author.setForeground(Color.GREEN); // PARA DARLE COLOR

		contryField.setBounds(textPaddingLeft, upTextPadding, widthText, heightText);

		upBottonPadding += spaceUpButton;
		upTextPadding += spaceUpButton;


		cancelButton.setBounds(textPaddingLeft, upTextPadding, botonWidth, botonHeight);
		acceptButton.setBounds(textPaddingLeft + 300, upTextPadding, botonWidth, botonHeight);

		

//		  JPanel selectPanel = new JPanel(new GridLayout(2, 2));
		  panel.add(selectLabel);
		  panel.add(listAuthor);
		  panel.add(loadButton);
	        
//	        JPanel modifyPanel = new JPanel(new GridLayout(5, 2));
	        panel.add(nameLabel);
	        panel.add(nameField);
	        panel.add(surnameLabel);
	        panel.add(surnameField);
	        panel.add(surname2Label);
	        panel.add(surname2Field);
	        panel.add(contryLabel);
	        panel.add(contryField);
	        
//	        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        panel.add(cancelButton);
	        panel.add(acceptButton);
	        
	        // Agregar los paneles a la ventana
//	        Container contentPane = getContentPane();
//	        contentPane.add(selectPanel, BorderLayout.NORTH);
//	        contentPane.add(modifyPanel, BorderLayout.CENTER);
//	        contentPane.add(buttonPanel, BorderLayout.SOUTH);
//		
	
	        
	        
	        //*********************************************
//
//		  JPanel selectPanel = new JPanel(new GridLayout(2, 2));
//	        selectPanel.add(selectLabel);
//	        selectPanel.add(listAuthor);
//	        selectPanel.add(loadButton);
//	        
//	        JPanel modifyPanel = new JPanel(new GridLayout(5, 2));
//	        modifyPanel.add(nameLabel);
//	        modifyPanel.add(nameField);
//	        modifyPanel.add(surnameLabel);
//	        modifyPanel.add(surnameField);
//	        modifyPanel.add(Surname2Label);
//	        modifyPanel.add(surname2Field);
//	        modifyPanel.add(contryLabel);
//	        modifyPanel.add(contryField);
//	        
//	        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//	        buttonPanel.add(cancelButton);
//	        buttonPanel.add(acceptButton);
//	        
//	        // Agregar los paneles a la ventana
//	        Container contentPane = getContentPane();
//	        contentPane.add(selectPanel, BorderLayout.NORTH);
//	        contentPane.add(modifyPanel, BorderLayout.CENTER);
//	        contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadButton) {
        	
            // Obtener la posición seleccionada del JComboBox y cargar los valores
//            int selectedPosition = listAuthor.getSelectedIndex();
            selectAuthor = (Author)listAuthor.getSelectedItem();
            nameField.setText(selectAuthor.getName());
            surnameField.setText(selectAuthor.getSurname());
            surname2Field.setText(selectAuthor.getSurname2());
            contryField.setText(selectAuthor.getCountry());
            
        }  else if (e.getSource() == acceptButton) {
        	
        	if (selectAuthor != null) {
        	String name = nameField.getText();
        	String surname =surnameField.getText();
        	String surname2= surname2Field.getText();
        	String country =  contryField.getText();
        	
        	Author authorModify = new Author(name, surname, surname2, country);
        	
          
        	Main.dao.updateAutor(selectAuthor, authorModify);
        	dispose();
        	}else {
        		JOptionPane.showConfirmDialog(null, "Tienes que cargar la información de algún autor", "Error",
        		        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);

        	}
        	
            
            
            
        }else if (e.getSource() == cancelButton) {
            // Cerrar la ventana si se presiona el botón de cancelar
            dispose();
        }
    }
    
   
}
