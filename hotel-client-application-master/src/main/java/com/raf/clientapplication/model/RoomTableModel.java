package com.raf.clientapplication.model;

import javax.swing.table.DefaultTableModel;

import com.raf.clientapplication.restclient.dto.RoomDto;
import com.raf.clientapplication.restclient.dto.RoomListDto;

public class RoomTableModel extends DefaultTableModel {


	public RoomTableModel() throws IllegalAccessException, NoSuchMethodException {
		super(new String[]{"Broj", "Tip"}, 0);
	}

	private RoomListDto roomListDto = new RoomListDto();

	@Override
	public void addRow(Object[] row) {
		super.addRow(row);
		RoomDto dto = new RoomDto();
		dto.setTitle(String.valueOf(row[0]));
		dto.setDescription(String.valueOf(row[1]));
		dto.setId(Long.valueOf(String.valueOf(row[2])));
		roomListDto.getContent().add(dto);
	}

	public RoomListDto getMovieListDto() {
		return roomListDto;
	}

	public void setMovieListDto(RoomListDto roomListDto) {
		this.roomListDto = roomListDto;
	}
}
