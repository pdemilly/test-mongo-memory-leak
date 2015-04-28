import java.lang.Runtime

class LeakService {
	
	static transaction = false

	def mongo
	def grailsApplication

	def db
	def total
	def progress
	def runtime

	private init () {
		db = mongo.getDB('leak-test')
		total = grailsApplication.config.'test_leak_sample_size'
		progress = new ProgressIndicator (total)
		runtime = new Runtime()
		println "sample size: $total"
	}

	def leak () {
		
		init()

		sampleData.eachWithIndex { rec, n ->
			def cust = Customer.findByCustomerNo (rec.customerNo)
			progress.showProgress ()
		}

		progress.showProgress ()
		return progress.msgs
	}

	def noleak () {
		
		init()

		sampleData.eachWithIndex { rec, n ->
			def cust = db.customers.findOne (customerNo: rec.customerNo)
			progress.showProgress ()
		}

		progress.showProgress ()
		return progress.msgs
	}

	def getSampleData () {
		// let's make sure we have enough memory for our test list
		return db.customers.find([:], [ customerNo: 1]).limit (total).collect { it }
	}
}
