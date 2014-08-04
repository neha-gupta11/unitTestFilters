package unittestfilters

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@Mock([SomeFilters, SomeService])
@TestFor(SomeController)
class SomeFiltersSpec extends Specification {

    void "test the filter"() {
        setup:
        defineBeans {
            someService(MockedSomeService)
        }
        //mock other methods and variables here

        when:
        params.checkSomeValue = 'checkSomeValue'
        withFilters(controller: "*", action: "*") {
            controller.index()
        }

        then:
        assert response.status == 302
        assert response.redirectedUrl == "/some/index"
    }
}


class MockedSomeService extends SomeService {
    @Override
    def serviceMethod(String check) {
        println "this is the Service Method " + check
    }
}