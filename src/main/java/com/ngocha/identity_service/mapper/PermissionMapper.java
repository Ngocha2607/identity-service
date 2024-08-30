package com.ngocha.identity_service.mapper;

import com.ngocha.identity_service.dto.request.PermissionRequest;
import com.ngocha.identity_service.dto.response.PermissionResponse;
import com.ngocha.identity_service.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);

}
