package com.rk.springmavendockerbasecore.configuration

import com.rk.springmavendockerbasecore.rest.BaseService
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SecurityConfigurationSpec extends Specification {

    @Autowired
    private MockMvc mockMvc

    @SpringBean
    private BaseService baseService = Mock()

    def "allow access to unsecured endpoint"() {
        expect:
        mockMvc.perform(get("/actuator/health"))
                .andExpect(status().isOk())
    }

    def "should allow access to secured endpoint with auth-token"() {
        given:
        baseService.handlePing() >> "hurray"

        expect:
        mockMvc.perform(get("/api/v1/ping")
                .header(SecurityConfiguration.HEADER_X_AUTH_TOKEN, 'dummy-test-token'))
                .andExpect(status().isOk())
    }

    def "should deny access to secured endpoint with wrong auth-token"() {
        expect:
        mockMvc.perform(get("/api/v1/ping")
                .header(SecurityConfiguration.HEADER_X_AUTH_TOKEN, 'wrong-token'))
                .andExpect(status().is4xxClientError())
    }
}
