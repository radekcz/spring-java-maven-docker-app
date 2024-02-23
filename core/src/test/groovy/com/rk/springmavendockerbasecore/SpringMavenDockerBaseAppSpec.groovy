package com.rk.springmavendockerbasecore

import com.rk.springmavendockerbasecore.rest.BaseService
import com.rk.springmavendockerbasecore.rest.model.Profile
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SpringMavenDockerBaseAppSpec extends Specification {

    @Autowired
    private MockMvc mockMvc

    @SpringBean
    private BaseService baseService = Mock()

    def "application should start and should response to health-check"() {
        expect:
        mockMvc.perform(MockMvcRequestBuilders
                .get("/actuator/health"))
                .andExpect(status().isOk())
    }

    def "should mock the particular service returing #profile when the appropriate controller is called for entire Spring context"() {
        given:
        baseService.getProfile() >> profile

        expect:
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/profile"))
                .andExpect(status().isOk())
                .andExpect(content().string("\"${profile}\""))
        where:
        profile << [Profile.QA, Profile.DEV, Profile.PROD]
    }
}
