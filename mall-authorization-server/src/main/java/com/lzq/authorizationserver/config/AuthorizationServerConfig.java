package com.lzq.authorizationserver.config;

import com.lzq.authorizationserver.security.RbacUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // 配置client认证客户端
                .withClient("client_1")
                .secret("123456")
                .resourceIds("order")
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("select")
                .authorities("client")
                .and()
                // 配置password认证客户端
                .withClient("client_2")
                .secret("123456")
                .resourceIds("order")
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("select")
                .authorities("client")
                .and()
                // 配置authorization_code认证客户端
                .withClient("client_3")
                .secret("123456")
//                .resourceIds("order")
                .scopes("select")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .authorities("user");

    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 必须设置AuthenticationManager才会设置Password模式下的AuthorityGranter, 否则无法进行oauth2 password类型的授权
        endpoints.authenticationManager(authenticationManager);
        endpoints.tokenStore(tokenStore());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer server) throws Exception {
        // 如果开启了allowFormAuthenticationForClients，
        // 那么就在BasicAuthenticationFilter之前添加ClientCredentialsTokenEndpointFilter，
        // 使用ClientDetailsUserDetailsService来进行client端登录的验证
        server.allowFormAuthenticationForClients();
    }


}
