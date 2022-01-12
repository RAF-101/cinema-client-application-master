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
	private JButton addDiscountButton;

	private JPanel inputPanel;

	private JLabel usernameLabel;
	private JTextField usernameInput;

	private JLabel discountLabelName;
	private JTextField discountInputName;
	private JLabel discountLabelValue;
	private JTextField discountInputValue;
	private JLabel discountLabelDiscount;
	private JTextField discountInputDiscount;




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

		discountLabelName = new JLabel("Ime Ranga: ");
		discountLabelValue = new JLabel("Vrednost : ");
		discountLabelDiscount = new JLabel("Popust : ");

		discountInputName = new JTextField(20);
		discountInputValue = new JTextField(20);
		discountInputDiscount = new JTextField(20);

		addDiscountButton = new JButton("Dodaj Rang");

		inputPanel.add(discountLabelName);
		inputPanel.add(discountInputName);
		inputPanel.add(discountLabelValue);
		inputPanel.add(discountInputValue);
		inputPanel.add(discountLabelDiscount);
		inputPanel.add(discountInputDiscount);
		inputPanel.add(addDiscountButton);

		this.add(inputPanel, BorderLayout.NORTH);
		this.setVisible(true);
	}
}
