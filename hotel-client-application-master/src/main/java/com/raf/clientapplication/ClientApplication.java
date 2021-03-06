package com.raf.clientapplication;

import java.awt.*;

import javax.swing.*;

import com.raf.clientapplication.view.LoginView;
import com.raf.clientapplication.view.ManagmentView;
import com.raf.clientapplication.view.ReservationView;

public class ClientApplication extends JFrame {

	private String token;
	private LoginView loginView;
	private JPanel secondaryView;

	private ClientApplication() throws IllegalAccessException, NoSuchMethodException {
		this.setTitle("Client Application");
		this.setSize(1200, 1200);
		this.setLayout(new BorderLayout());

		loginView = new LoginView();
		this.add(loginView, BorderLayout.NORTH);

		secondaryView = new ManagmentView();
		this.add(secondaryView, BorderLayout.CENTER);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static class InstanceHolder {
		private static ClientApplication instance;

		static {
			try {
				instance = new ClientApplication();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LoginView getLoginView() {
		return loginView;
	}

	public void setLoginView(LoginView loginView) {
		this.loginView = loginView;
	}

	public JPanel getSecondaryView() {
		return secondaryView;
	}

	public void setSecondaryView(JPanel secondaryView) {
		this.secondaryView = secondaryView;
		this.add(this.secondaryView, BorderLayout.CENTER);
	}

	public static ClientApplication getInstance() {
		return InstanceHolder.instance;
	}
}
