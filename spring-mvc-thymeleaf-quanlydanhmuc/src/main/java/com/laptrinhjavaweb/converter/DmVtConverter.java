package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.DmVtDTO;
import com.laptrinhjavaweb.model.DmVt;

@Component
public class DmVtConverter {

	public DmVt toEntity(DmVtDTO dmvtDTO) {
		DmVt dmvt = new DmVt();
		if (dmvtDTO.getId() != -1) {
			dmvt.setId(dmvtDTO.getId());
		}

		dmvt.setMaVt(dmvtDTO.getMaVt());
		dmvt.setTenVt(dmvtDTO.getTenVt());
		dmvt.setDvt1(dmvtDTO.getDvt1());		

		return dmvt;
	}

	public DmVtDTO toDTO(DmVt dmvt) {

		DmVtDTO dmvtDTO = new DmVtDTO();
		dmvtDTO.setId(dmvt.getId());
		dmvtDTO.setMaVt(dmvt.getMaVt());
		dmvtDTO.setTenVt(dmvt.getTenVt());
		dmvtDTO.setDvt1(dmvt.getDvt1());

		return dmvtDTO;
	}

	public DmVt toEntity(DmVt dmvt, DmVtDTO dmvtDTO) {

		if (dmvtDTO.getId() != -1) {
			dmvt.setId(dmvtDTO.getId());
		}

		dmvt.setMaVt(dmvtDTO.getMaVt());
		dmvt.setTenVt(dmvtDTO.getTenVt());
		dmvt.setDvt1(dmvtDTO.getDvt1());
		return dmvt;
	}

}
