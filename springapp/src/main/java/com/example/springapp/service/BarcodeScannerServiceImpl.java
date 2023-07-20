package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.BarcodeScanner;
import com.example.springapp.repository.BarcodescannerRepository;

@Service
public class BarcodeScannerServiceImpl implements BarcodeScannerService {
	@Autowired
	BarcodescannerRepository barcode;

	@Override
	public List<BarcodeScanner> getBarcodeScanner() {
		return barcode.findAll();
	}

	@Override
	public void setBarcodeScanner(BarcodeScanner b) {
		barcode.save(b);

	}

	@Override
	public void editBarcodeScanner(BarcodeScanner b) {
		barcode.save(b);

	}

	@Override
	public void deleteBarcodeScanner(int id) {
		barcode.deleteById(id);

	}
}
