package org.zhaoxuan.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zhaoxuan.auth.biz.AuthBiz;
import org.zhaoxuan.pojo.request.auth.LoginRequest;
import org.zhaoxuan.pojo.request.auth.LogoutRequest;
import org.zhaoxuan.pojo.response.auth.LoginInfoResponse;
import org.zhaoxuan.pojo.response.auth.LoginResponse;
import org.zhaoxuan.pojo.response.auth.VerifyCodeResponse;

@Tag(name = "鉴权服务")
@RestController()
@RequestMapping("/auth")
@SuppressWarnings("unused")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class AuthController {

    private final AuthBiz authBiz;

    @Operation(description = "获取验证码")
    @PostMapping("/code")
    public VerifyCodeResponse verifyCode() {
        return authBiz.verifyCode();
    }

    @Operation(description = "用户登录")
    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
        return authBiz.login(request);
    }

    @Operation(description = "用户登出")
    @DeleteMapping("/logout")
    public void logout(@RequestBody @Validated LogoutRequest request) {
        authBiz.logout(request);
    }

    @Operation(description = "获取用户登录信息")
    @GetMapping("/info")
    public LoginInfoResponse info() {
        return authBiz.info();
    }

}
