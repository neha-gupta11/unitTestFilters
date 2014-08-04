package unittestfilters

import grails.transaction.Transactional

@Transactional
class SomeService {

    def serviceMethod(String check) {
        println "this is the Service Method "+check
    }
}
