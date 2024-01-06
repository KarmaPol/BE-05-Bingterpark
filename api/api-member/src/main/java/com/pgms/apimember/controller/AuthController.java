package com.pgms.apimember.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgms.apimember.dto.request.LoginRequest;
import com.pgms.apimember.dto.response.LoginResponse;
import com.pgms.apimember.service.AuthService;
import com.pgms.coredomain.response.ApiResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	/**
	 * 로그인, 토큰 발급
	 */
	@PostMapping("/admin/login")
	public ResponseEntity<ApiResponse<LoginResponse>> adminLogin(@Valid @RequestBody LoginRequest request) {
		LoginResponse response = authService.login(request, "admin");
		return ResponseEntity.ok(ApiResponse.ok(response));
	}

	@PostMapping("/members/login")
	public ResponseEntity<ApiResponse<LoginResponse>> memberLogin(@Valid @RequestBody LoginRequest request) {
		// TODO: 나중에 enum으로..?
		LoginResponse response = authService.login(request, "member");
		return ResponseEntity.ok(ApiResponse.ok(response));
	}

	/**
	 * TODO 토큰 재발급
	 */

}
