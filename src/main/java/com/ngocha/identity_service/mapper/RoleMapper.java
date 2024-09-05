package com.ngocha.identity_service.mapper;

import com.ngocha.identity_service.dto.request.RoleRequest;
import com.ngocha.identity_service.dto.request.UserCreationRequest;
import com.ngocha.identity_service.dto.request.UserUpdateRequest;
import com.ngocha.identity_service.dto.response.RoleResponse;
import com.ngocha.identity_service.dto.response.UserResponse;
import com.ngocha.identity_service.entity.Role;
import com.ngocha.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse(Role role);

}
