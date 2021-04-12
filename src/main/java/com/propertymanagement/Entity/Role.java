package com.propertymanagement.Entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  ROLE_ADMIN, ROLE_CLIENT,ROLE_USERS;

  public String getAuthority() {
    return name();
  }

}
