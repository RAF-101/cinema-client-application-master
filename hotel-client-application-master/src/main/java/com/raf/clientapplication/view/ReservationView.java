package com.raf.clientapplication.view;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import com.raf.clientapplication.model.RoomTableModel;
import com.raf.clientapplication.restclient.ReservationServiceRestClient;
import com.raf.clientapplication.restclient.dto.MovieListDto;

public class ReservationView extends JPanel {

	private RoomTableModel roomTableModel;
	private JTable roomTable;
	private ReservationServiceRestClient reservationServiceRestClient;
	private JButton jButton;

	public ReservationView() throws IllegalAccessException, NoSuchMethodException {
		super();
		this.setSize(400, 400);

		roomTableModel = new RoomTableModel();
		reservationServiceRestClient = new ReservationServiceRestClient();
		roomTable = new JTable(roomTableModel);
		this.setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(roomTable);
		this.add(scrollPane, BorderLayout.NORTH);

		jButton = new JButton("Create Order");
		this.add(jButton, BorderLayout.CENTER);

		jButton.addActionListener((event) -> {
			System.out.println(roomTableModel.getMovieListDto().getContent().get(roomTable.getSelectedRow()).getId());
		});

		setVisible(false);
	}

	public void init() throws IOException {
		this.setVisible(true);

		MovieListDto movieListDto = reservationServiceRestClient.getMovies();
		movieListDto.getContent().forEach(movieDto -> {
			System.out.println(movieDto);
			roomTableModel.addRow(new Object[]{movieDto.getTitle(), movieDto.getDescription(), movieDto.getId()});
		});
	}

	public RoomTableModel getRoomTableModel() {
		return roomTableModel;
	}

	public JTable getRoomTable() {
		return roomTable;
	}
}
