package com.raf.clientapplication;

import java.awt.*;

import javax.swing.*;

import com.raf.clientapplication.view.LoginView;
import com.raf.clientapplication.view.ReservationView;

public class ClientApplication extends JFrame {

	private String token;
	private LoginView loginView;
	private ReservationView secondaryView;

	private ClientApplication() throws IllegalAccessException, NoSuchMethodException {
		this.setTitle("Client Application");
		this.setSize(1200, 1200);
		this.setLayout(new BorderLayout());

		loginView = new LoginView();
		this.add(loginView, BorderLayout.NORTH);

		secondaryView = new ReservationView();
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

	public ReservationView getSecondaryView() {
		return secondaryView;
	}

	public void setSecondaryView(ReservationView secondaryView) {
		this.secondaryView = secondaryView;
	}

	public static ClientApplication getInstance() {
		return InstanceHolder.instance;
	}
}
