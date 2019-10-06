package com.laptrinhjavaweb.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.RoleConverter;
import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.model.Role;
import com.laptrinhjavaweb.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleConverter roleConverter;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<RoleDTO> findAll() {
		List<RoleDTO> listRoleDTO = new ArrayList<>();
		List<Role> listRole = new ArrayList<>();
		listRole = roleRepository.findAll();

		for (Role role : listRole) {
			RoleDTO roleDTO = new RoleDTO();
			roleDTO = roleConverter.toDTO(role);
			listRoleDTO.add(roleDTO);
		}

		return listRoleDTO;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<RoleDTO> findAllByUsername(String username){		
		StoredProcedureQuery findAllByUsername = em.createNamedStoredProcedureQuery("getAllRoleByUserName");
		findAllByUsername.setParameter("Username", username);
		findAllByUsername.execute();
		List<Role> listRole = findAllByUsername.getResultList();
		List<RoleDTO> list = new ArrayList<>();
		for(Role role:listRole) {
			RoleDTO roleDTo = new RoleDTO();
			roleDTo = roleConverter.toDTO(role);
			list.add(roleDTo);
		}
		
		return list;		
	}
}
