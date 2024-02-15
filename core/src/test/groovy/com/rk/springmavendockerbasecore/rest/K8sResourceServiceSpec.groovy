package com.rk.springmavendockerbasecore.rest

import com.rk.springmavendockerbasecore.rest.model.ApplicationProperties
import spock.lang.Specification

class K8sResourceServiceSpec extends Specification {

    def "should return application version"() {
        when:
        def service = new K8sResourceService()
        def pods = service.getPods()

        then:
        pods.size() == 3
    }
}
