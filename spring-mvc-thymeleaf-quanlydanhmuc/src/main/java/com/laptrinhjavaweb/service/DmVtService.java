package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.DmVtDTO;

public interface DmVtService {

	DmVtDTO save(DmVtDTO dmvtDTO);
	List<DmVtDTO> findAll();
	DmVtDTO findById(Integer id);
	DmVtDTO deleteById(Integer id);
	
}
