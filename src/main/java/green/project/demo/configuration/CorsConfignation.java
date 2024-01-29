package green.project.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfignation {


	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();

		config.setAllowCredentials(true);
		config.addAllowedOriginPattern("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);

		return new CorsFilter(source);
	}
	// @Bean
	// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	//
	//
	// 	return http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class)
	// 		//              csrf 공격에 대한 옵션 꺼두기
	// 		.cors(Customizer.withDefaults())
	// 		.csrf(AbstractHttpConfigurer::disable)
	// 		.httpBasic(httpSecurityHttpBasicConfigurer -> {
	// 			httpSecurityHttpBasicConfigurer.disable();
	// 		})
	// 		.sessionManagement(httpSecuritySessionManagementConfigurer -> {
	// 			httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	// 		}).
	//
	// 		//                토큰방식을 사용하기 때문에 세션방식 사용하지 않도록 설정
	// 			authorizeHttpRequests((authorizaRequests) -> {
	// 			//                    /요청은 모든 사용자가 이용가능
	// 			//
	// 			authorizaRequests.requestMatchers("/api/**","/member/**","/vendor/join","/API/validateByRegion","/vendor/info","/reviews/**","/logout","/test-api-local.com/api/swagger-ui/index.html","/auth/**","/API/**","/API/dongJak/DongJakData","/API/gangseogu/GangseoguData","/API/dongdaemun/DongdaemunData","/auth2/**","/swagger/index.html",
	// 				"/API/gyeonggi/GyeonggiData","/API/gangNam/GangNamData","/API/dobonggu/DobongguData","/API/dongJak/validateDongJak","/API/dobonggu/**","/API/gangNam/validateGangNam","/API/gyeonggi/validateGyeonggi","/API/dongdaemun/**","/API/gangseogu/validateGangseo","/API/dongJak/NoRyangJin","/app/users/auth2/google/login/callback","/api/callback","/app/users/auth2/GOOGLE/login/callback","/app/users/auth2/**","/swagger-ui.html").permitAll();
	// 			authorizaRequests.requestMatchers("/board/**", "/menu/**", "/cart/**", "/reviews/**", "/orders/**","/upload/**","/api/**","/refresh","/myPage/**","/refresh/**","/favorite-Test/**","/businessApi/**","/payment/**").hasAnyAuthority("ROLE_VENDOR","ROLE_BASIC");
	// 			authorizaRequests.requestMatchers("/vendor/**").hasAnyAuthority("ROLE_VENDOR","ROLE_BASIC");
	//
	// 			authorizaRequests.anyRequest().authenticated();
	//
	//
	//
	// 			//
	// 		.build();
	//
	// }

}

