package com.rk.springmavendockerbasecore.rest

import com.rk.springmavendockerbasecore.rest.model.ApplicationProperties
import spock.lang.Specification

class BaseServiceSpec extends Specification {

    def "should return application version"() {
        given:
        def props = new ApplicationProperties(version: "4.8.1")

        when:
        def service = new BaseService(props)
        def version = service.getVersionFromProperties()

        then:
        version == "4.8.1"
    }
}
