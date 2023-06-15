package com.design.machineManagement.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.design.machineManagement.pojo.Users;

import java.util.Calendar;

public class JwtUtils {
    //通过有效时间
    private static int days = 7;

    //密钥（需要后端严密保存）
    private static String SecretKey = "machineManagement";

    /**
     *  生成token header.payload.sing
     */
    public static String getToken(Users users){ //返回String 类型的数据 Users users 接受user对象参数
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,days);
        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        //payload
        builder.withClaim("id", users.getId());
        builder.withClaim("userName", users.getUserName());
        //生成token，头部默认jwt和Base64编码
        String token = builder.withExpiresAt(instance.getTime())   //设置过期时间
                .sign(Algorithm.HMAC256(SecretKey));		//加密算法和密钥
        return token;
    }

    /**
     * 验证 token 合法性
     */
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(SecretKey)).build().verify(token);
    }

}
