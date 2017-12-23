package client.vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.app.IClient;

public class SubmitPanel extends JPanel {

	private IClient client;
	private ActionListener controller;
	private JTextField txtItemName;
	private JTextField txtItemDescription;
	private JTextField txtItemPrice;
	private JTextField txtItemTime;
	private JButton btnItemSubmission;

	public SubmitPanel(IClient client, ActionListener controller) {
		super();
		this.client = client;
		this.controller = controller;
		this.txtItemName = new JTextField();
		this.txtItemDescription = new JTextField();
		this.txtItemPrice = new JTextField();
		this.txtItemTime = new JTextField();
		this.btnItemSubmission = new JButton("Soumettre");

		this.setLayout(new GridBagLayout());

		JLabel labelName = new JLabel("Nom : ");
		JLabel labelDescription = new JLabel("Description : ");
		JLabel labelPrice = new JLabel("Prix de base : ");
		JLabel labelTime = new JLabel("Date de fin : ");

		labelName.setPreferredSize(new Dimension(100, 40));
		txtItemName.setPreferredSize(new Dimension(300, 40));
		labelDescription.setPreferredSize(new Dimension(100, 150));
		txtItemDescription.setPreferredSize(new Dimension(300, 150));
		labelPrice.setPreferredSize(new Dimension(100, 40));
		txtItemPrice.setPreferredSize(new Dimension(300, 40));
		labelTime.setPreferredSize(new Dimension(100, 40));
		txtItemTime.setPreferredSize(new Dimension(300, 40));

		GridBagConstraints gbSubmission = new GridBagConstraints();

		gbSubmission.gridx = 0;
		gbSubmission.gridy = 0;
		gbSubmission.gridwidth = 1;
		gbSubmission.gridheight = 4;
		gbSubmission.insets = new Insets(5, 5, 5, 50);
		gbSubmission.insets = new Insets(0, 0, 0, 0);

		// Name
		gbSubmission.gridx = 1;
		gbSubmission.gridheight = 1;
		this.add(labelName, gbSubmission);

		gbSubmission.gridx = 2;
		this.add(txtItemName, gbSubmission);

		// Description
		gbSubmission.gridx = 1;
		gbSubmission.gridy = 2;
		gbSubmission.gridwidth = 1;
		gbSubmission.gridheight = 1;
		this.add(labelDescription, gbSubmission);

		gbSubmission.gridx = 2;
		this.add(txtItemDescription, gbSubmission);

		// Price
		gbSubmission.gridx = 1;
		gbSubmission.gridy = 3;
		this.add(labelPrice, gbSubmission);

		gbSubmission.gridx = 2;
		gbSubmission.gridy = 3;
		this.add(txtItemPrice, gbSubmission);

		// Time
		gbSubmission.gridx = 1;
		gbSubmission.gridy = 4;
		this.add(labelTime, gbSubmission);

		gbSubmission.gridx = 2;
		gbSubmission.gridy = 4;
		this.add(txtItemTime, gbSubmission);

		gbSubmission.gridx = 0;
		gbSubmission.gridy = 4;
		gbSubmission.insets = new Insets(5, 5, 5, 50);
		//this.add(btnPhoto, gbSubmission);
		gbSubmission.insets = new Insets(0, 0, 0, 0);

		// Separator
		/*
		 * mgbSubmission.gridx = 1; gbSubmission.gridy = 5; gbSubmission.gridwidth = 2;
		 * submissionPanel.add(separator, gbSubmission);
		 */

		// Button for submission
		gbSubmission.gridx = 2;
		gbSubmission.gridy = 6;
		btnItemSubmission.addActionListener(this.controller);
		this.add(btnItemSubmission, gbSubmission);
	}

}
