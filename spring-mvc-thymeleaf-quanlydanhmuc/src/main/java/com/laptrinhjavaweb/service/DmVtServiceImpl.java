package com.laptrinhjavaweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.DmVtConverter;
import com.laptrinhjavaweb.dto.DmVtDTO;
import com.laptrinhjavaweb.model.DmVt;
import com.laptrinhjavaweb.repository.DmNhVtRepository;
import com.laptrinhjavaweb.repository.DmVtRepository;

@Service
public class DmVtServiceImpl implements DmVtService {

	@Autowired
	private DmVtRepository dmVtRepository;
	

	@Autowired
	private DmNhVtRepository dmNhVtRepository; 
	
	@Autowired
	private DmVtConverter dmVtConverter;

	@Override
	public DmVtDTO save(DmVtDTO dmvtDTO) {
		DmVt dmvt = new DmVt();		
		dmvt = dmVtConverter.toEntity(dmvtDTO);	
		dmvt.setNhomVt(dmNhVtRepository.getOne(dmvtDTO.getMaNhVtId()));
		dmvt = dmVtRepository.save(dmvt);		
		dmvtDTO = dmVtConverter.toDTO(dmvt);
		dmvtDTO.setMaNhVtId(dmvt.getNhomVt().getId());
		
		return dmvtDTO;
	}

	@Override
	public List<DmVtDTO> findAll() {
		List<DmVtDTO> listDTO = new ArrayList<>();
		List<DmVt> listEntity = dmVtRepository.findAll();		
		
		for (DmVt dmvt : listEntity) {
			DmVtDTO dmvtDTO = new DmVtDTO();
			dmvtDTO = dmVtConverter.toDTO(dmvt);
			dmvtDTO.setMaNhVtId(dmvt.getNhomVt().getId());
			listDTO.add(dmvtDTO);
		}
		return listDTO;
	}

	@Override
	public DmVtDTO findById(Integer id) {
		DmVtDTO dmvtDTO = new DmVtDTO();
		DmVt dmvt = new DmVt();
		dmvt = dmVtRepository.getOne(id);
		dmvtDTO = dmVtConverter.toDTO(dmvt);
		dmvtDTO.setMaNhVtId(dmvt.getNhomVt().getId());

		return dmvtDTO;
	}

	@Override
	public DmVtDTO deleteById(Integer id) {
		DmVt dmvt = new DmVt();
		dmvt = dmVtRepository.getOne(id);
		DmVtDTO dmvtDTO = dmVtConverter.toDTO(dmvt);
		dmvtDTO.setMaNhVtId(dmvt.getNhomVt().getId());
		dmVtRepository.deleteById(id);
		return dmvtDTO;
	}

}
