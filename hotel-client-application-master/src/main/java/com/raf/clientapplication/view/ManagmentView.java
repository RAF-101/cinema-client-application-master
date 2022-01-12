package com.raf.clientapplication.view;

import com.raf.clientapplication.model.RoomTableModel;
import com.raf.clientapplication.restclient.ReservationServiceRestClient;
import com.raf.clientapplication.restclient.dto.MovieListDto;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ManagmentView extends JPanel {

	private JButton jButton;

	public ManagmentView() throws IllegalAccessException, NoSuchMethodException {
		super();
		this.setSize(400, 400);

		this.setLayout(new BorderLayout());

		jButton = new JButton("Create Order");
		this.add(jButton, BorderLayout.CENTER);

		jButton.addActionListener((event) -> {

		});

		setVisible(false);
	}

	public void init() throws IOException {
		this.setVisible(true);

	}
}
