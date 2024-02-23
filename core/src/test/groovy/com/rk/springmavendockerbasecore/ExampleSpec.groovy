package com.rk.springmavendockerbasecore

import spock.lang.Specification

class ExampleSpec extends Specification {

    def "should run test with result #expectedResult"() {
        expect:
        a * b == expectedResult

        where:
        a   |   b   |  expectedResult
        1   |   1   |  1
        3   |   3   |  9
    }
}
