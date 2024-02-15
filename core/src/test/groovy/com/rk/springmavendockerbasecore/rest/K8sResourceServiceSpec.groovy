package com.rk.springmavendockerbasecore.rest

import spock.lang.Specification

class K8sResourceServiceSpec extends Specification {

    def "should list all pods"() {
        when:
        def service = new K8sResourceService()
        def pods = service.getPods(null)

        then:
        pods.size() == 10
    }

    def "should list pods for specific namespace"() {
        when:
        def service = new K8sResourceService()
        def pods = service.getPods("compute")

        then:
        pods.size() == 2
        pods.forEach {it -> it.contains("compute")}
    }
}
