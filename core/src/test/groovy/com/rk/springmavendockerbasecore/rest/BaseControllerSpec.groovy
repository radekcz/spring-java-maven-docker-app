package com.rk.springmavendockerbasecore.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = BaseController)
// exclude security-configuration for tests
@AutoConfigureMockMvc(addFilters = false)
class BaseControllerSpec extends Specification {

    @Autowired
    MockMvc mvc

    @Unroll
    def "should set profile #profile"() {
        expect:
        mvc.perform(post("/api/v1/profile?profile=${profile}"))
                .andExpect(status().isOk())

        where:
        profile << ['DEV', 'QA', 'PROD', 'dev', 'qa', 'prod']
    }

    @Unroll
    def "set profile endpoint returns bad request when parameter profile does not match Profile-enum"() {
        expect:
        mvc.perform(post("/api/v1/profile?profile=${profile}"))
                .andExpect(status().is4xxClientError())
        where:
        profile << ['null', 'unknown', 'devprodqa']
    }

    def "set profile endpoint returns bad request when parameter profile is missing"() {
        expect:
        mvc.perform(post("/api/v1/profile"))
                .andExpect(status().is4xxClientError())
    }

    def "ping endpoint should return message"() {
        expect:
        mvc.perform(get("/api/v1/ping"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello from BaseService"))
    }
}
