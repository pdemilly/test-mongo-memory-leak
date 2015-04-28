import java.lang.Runtime

class LeakService {
	
	static transaction = false

	def runtime = new Runtime()
	def mongo
	def grailsApplication

	def leak () {
		
		def total = grailsApplication.config.'test_leak_sample_size'
		def p = new ProgressIndicator (total)

		println "sample size: $total"
		def list = mongo.getDB('leak-test').customers.find([:], [ customerNo: 1]).limit (total)

		list.eachWithIndex { rec, n ->
			def cust = Customer.findByCustomerNo (rec.customerNo)
			p.showProgress ()
		}

		p.showProgress ()
		return p.msgs
	}
}
