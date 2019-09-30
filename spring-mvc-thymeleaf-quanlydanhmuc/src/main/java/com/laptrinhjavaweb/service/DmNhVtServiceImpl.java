package com.laptrinhjavaweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.DmNhVtConverter;
import com.laptrinhjavaweb.dto.DmNhVtDTO;
import com.laptrinhjavaweb.model.DmNhVt;
import com.laptrinhjavaweb.repository.DmNhVtRepository;

@Service
public class DmNhVtServiceImpl implements DmNhVtService {

	@Autowired
	private DmNhVtRepository dmNhVtRepository;

	@Autowired
	DmNhVtConverter dmNhVtConverter;

	@Override
	public List<DmNhVtDTO> findAll() {
		List<DmNhVtDTO> listDTO = new ArrayList<>();
		List<DmNhVt> listEntity = new ArrayList<>();
		listEntity = dmNhVtRepository.findAll();
		for (DmNhVt dmNhVt : listEntity) {
			DmNhVtDTO dmNhVtDTO = new DmNhVtDTO();
			dmNhVtDTO = dmNhVtConverter.toDTo(dmNhVt);
			listDTO.add(dmNhVtDTO);
		}

		return listDTO;
	}
}
