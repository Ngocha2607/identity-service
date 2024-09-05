package com.ngocha.identity_service.service;

import com.ngocha.identity_service.dto.request.PermissionRequest;
import com.ngocha.identity_service.dto.request.RoleRequest;
import com.ngocha.identity_service.dto.response.PermissionResponse;
import com.ngocha.identity_service.dto.response.RoleResponse;
import com.ngocha.identity_service.entity.Permission;
import com.ngocha.identity_service.entity.Role;
import com.ngocha.identity_service.mapper.PermissionMapper;
import com.ngocha.identity_service.mapper.RoleMapper;
import com.ngocha.identity_service.repository.PermissionRepository;
import com.ngocha.identity_service.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;
    public RoleResponse create(RoleRequest request) {
        Role role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());

        role.setPermissions(new HashSet<>(permissions));
        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }
    public List<RoleResponse> getAll() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }
    public void delete(String role) {
        roleRepository.deleteById(role);
    }
}
