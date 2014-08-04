package unittestfilters

class SomeFilters {

    SomeService someService

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                println "we are here"
                println params.checkSomeValue
                if (params.checkSomeValue) {
                    print "the value"
                    someService.serviceMethod(params.checkSomeValue)
                    redirect(controller: 'some', action: 'index')
                }
                return true
            }
        }
    }
}
