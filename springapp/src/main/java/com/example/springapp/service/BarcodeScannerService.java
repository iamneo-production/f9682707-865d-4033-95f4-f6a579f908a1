package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.BarcodeScanner;

public interface BarcodeScannerService {
	public List<BarcodeScanner> getBarcodeScanner();

	public void setBarcodeScanner(BarcodeScanner b);

	public void editBarcodeScanner(BarcodeScanner b);

	public void deleteBarcodeScanner(int id);
}
