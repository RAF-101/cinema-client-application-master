package com.raf.clientapplication.view;

import com.raf.clientapplication.model.RoomTableModel;
import com.raf.clientapplication.restclient.ReservationServiceRestClient;
import com.raf.clientapplication.restclient.dto.MovieListDto;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ManagmentView extends JPanel {

	private JButton jButton;
	private JButton banButton;
	private JButton unbanButton;

	private JPanel inputPanel;

	private JLabel usernameLabel;
	private JTextField usernameInput;

	public ManagmentView() throws IllegalAccessException, NoSuchMethodException {
		super();
		this.setSize(400, 400);

		this.setLayout(new BorderLayout());

	}

	public void init() throws IOException {
		inputPanel = new JPanel();

		usernameLabel = new JLabel("Username: ");
		usernameInput = new JTextField(20);

		banButton = new JButton("Ban User");
		unbanButton = new JButton("Unban User");

		inputPanel.add(usernameLabel);
		inputPanel.add(usernameInput);
		inputPanel.add(banButton);
		inputPanel.add(unbanButton);


		this.add(inputPanel, BorderLayout.NORTH);
		this.setVisible(true);
	}
}
