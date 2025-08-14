package com.kunalgupte.buddyrental.dto;

import com.kunalgupte.buddyrental.entities.Wallet;

public record UserDto(
        Long id,
        String name,
        String email,
        String phone,
        Wallet wallet
) {}

