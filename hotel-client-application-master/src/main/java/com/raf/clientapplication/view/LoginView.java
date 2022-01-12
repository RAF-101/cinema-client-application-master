package com.raf.clientapplication.view;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raf.clientapplication.ClientApplication;
import com.raf.clientapplication.restclient.UserServiceRestClient;

public class LoginView extends JPanel {

	private JPanel inputPanel;

	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameInput;
	private JPasswordField passwordInput;

	private JButton loginButton;
	private JButton registerUserButton;
	private JButton registerManagerButton;
	private JButton settingsButton;
	private JButton manageButton;

	private UserServiceRestClient userServiceRestClient = new UserServiceRestClient();

	private ObjectMapper objectMapper = new ObjectMapper();

	public LoginView() {

		super();
		this.setSize(400, 400);

		this.setLayout(new BorderLayout(50,10));

		initInputPanel();

		loginButton = new JButton("Login");
		this.add(loginButton, BorderLayout.EAST);
		loginButton.addActionListener((event) -> {

			try {
				String token = userServiceRestClient
					.login(usernameInput.getText(), String.valueOf(passwordInput.getPassword()));
				ClientApplication.getInstance().setToken(token);
				System.out.println(token);
				this.add(manageButton, BorderLayout.EAST);
				this.add(settingsButton, BorderLayout.WEST);
				loginButton.setVisible(false);
				registerUserButton.setVisible(false);
				registerManagerButton.setVisible(false);
				inputPanel.setVisible(false);
				((ReservationView) ClientApplication.getInstance().getSecondaryView()).init();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		registerUserButton = new JButton("Register User");
		this.add(registerUserButton, BorderLayout.WEST);
		registerUserButton.addActionListener((event) -> {

			//String token = userServiceRestClient
			//		.registerUser(usernameInput.getText(), String.valueOf(passwordInput.getPassword()));
			//ClientApplication.getInstance().setToken(token);
			//System.out.println(token);
			this.add(manageButton, BorderLayout.EAST);
			this.add(settingsButton, BorderLayout.WEST);
			loginButton.setVisible(false);
			registerUserButton.setVisible(false);
			registerManagerButton.setVisible(false);
			inputPanel.setVisible(false);
			//((ReservationView) ClientApplication.getInstance().getSecondaryView()).init();
		});

		registerManagerButton = new JButton("Register Manager");
		this.add(registerManagerButton, BorderLayout.CENTER);
		registerManagerButton.addActionListener((event) -> {

			//String token = userServiceRestClient
			//		.registerManager(usernameInput.getText(), String.valueOf(passwordInput.getPassword()));
			//ClientApplication.getInstance().setToken(token);
			//System.out.println(token);
			this.add(manageButton, BorderLayout.EAST);
			this.add(settingsButton, BorderLayout.WEST);
			loginButton.setVisible(false);
			registerUserButton.setVisible(false);
			registerManagerButton.setVisible(false);
			inputPanel.setVisible(false);
			//((ReservationView) ClientApplication.getInstance().getSecondaryView()).init();
		});

		settingsButton = new JButton("Settings");
		settingsButton.addActionListener((event) -> {

			try {
				ClientApplication.getInstance().getSecondaryView().setVisible(false);
				ClientApplication.getInstance().setSecondaryView(new ManagmentView());
				((ManagmentView) ClientApplication.getInstance().getSecondaryView()).init();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		manageButton = new JButton("Manage");
		manageButton.addActionListener((event) -> {

			try {
				ClientApplication.getInstance().getSecondaryView().setVisible(false);
				ClientApplication.getInstance().setSecondaryView(new ManagmentView());
				((ManagmentView) ClientApplication.getInstance().getSecondaryView()).init();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	private void initInputPanel() {

		inputPanel = new JPanel();

		usernameLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password: ");

		usernameInput = new JTextField(20);
		passwordInput = new JPasswordField(20);

		inputPanel.add(usernameLabel);
		inputPanel.add(usernameInput);

		inputPanel.add(passwordLabel);
		inputPanel.add(passwordInput);

		this.add(inputPanel, BorderLayout.PAGE_START);
	}
}
