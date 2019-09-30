package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.DmNhVtDTO;
import com.laptrinhjavaweb.model.DmNhVt;

@Component
public class DmNhVtConverter {

	public DmNhVt toEntity(DmNhVtDTO dmNhVtDTO) {

		DmNhVt dmNhVt = new DmNhVt();
		if (dmNhVt.getId() != -1) {
			dmNhVt.setId(dmNhVtDTO.getId());
		}

		dmNhVt.setMaNhVt(dmNhVtDTO.getMaNhVt());
		dmNhVt.setTenNhVt(dmNhVtDTO.getTenNhVt());
		dmNhVt.setMaNhVtParent(dmNhVtDTO.getMaNhVtParent());

		return dmNhVt;

	}

	public DmNhVtDTO toDTo(DmNhVt dmNhVt) {
		DmNhVtDTO dmNhVtDTO = new DmNhVtDTO();
		dmNhVtDTO.setId(dmNhVt.getId());
		dmNhVtDTO.setMaNhVt(dmNhVt.getMaNhVt());
		dmNhVtDTO.setTenNhVt(dmNhVt.getTenNhVt());
		dmNhVtDTO.setMaNhVtParent(dmNhVt.getMaNhVtParent());

		return dmNhVtDTO;
	}

	public DmNhVt toEntity(DmNhVt dmNhVt, DmNhVtDTO dmNhVtDTO) {
		if (dmNhVtDTO.getId() != -1) {
			dmNhVt.setId(dmNhVtDTO.getId());
		}

		dmNhVt.setMaNhVt(dmNhVtDTO.getMaNhVt());
		dmNhVt.setTenNhVt(dmNhVtDTO.getTenNhVt());
		dmNhVt.setMaNhVtParent(dmNhVtDTO.getMaNhVtParent());

		return dmNhVt;
	}

}
