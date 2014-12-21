package com.example.pbiku;

public class ItemDetailsModel {

	private String nama;
	private int imageNumber;
	private int idProv;

	public ItemDetailsModel(int idProv, String nama, int imageNumber) {
		this.idProv = idProv;
		this.nama = nama;
		this.imageNumber = imageNumber;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getImageNumber() {
		return imageNumber;
	}

	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}

	public int getIdProv() {
		return idProv;
	}

	public void setIdProv(int idProv) {
		this.idProv = idProv;
	}

}
