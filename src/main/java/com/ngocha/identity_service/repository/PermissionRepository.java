package com.ngocha.identity_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, string> {
}
