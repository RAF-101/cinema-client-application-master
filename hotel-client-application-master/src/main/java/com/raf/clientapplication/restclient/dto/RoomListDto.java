package com.raf.clientapplication.restclient.dto;

import java.util.ArrayList;
import java.util.List;

public class RoomListDto {

	private List<RoomDto> content = new ArrayList<>();

	public RoomListDto() {

	}

	public RoomListDto(List<RoomDto> content) {
		this.content = content;
	}

	public List<RoomDto> getContent() {
		return content;
	}

	public void setContent(List<RoomDto> content) {
		this.content = content;
	}
}
