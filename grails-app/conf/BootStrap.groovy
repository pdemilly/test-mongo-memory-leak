import org.apache.commons.lang.RandomStringUtils

class BootStrap {

	def grailsApplication

	def init = { servletContext ->

		def total = grailsApplication.config.'test_leak_sample_size'
		if (Customer.count() >= total)
		   return

		def nosize = 10**7


		String numset = ('0'..'9').join()
		String alphaset = ('A'..'Z').join()

		def p = new ProgressIndicator (total)

		total.times { n -> 

			def custno = RandomStringUtils.random(7, numset.toCharArray())
			def name = new Name ()
			name.first = RandomStringUtils.random(10, alphaset.toCharArray())
			name.last = RandomStringUtils.random(10, alphaset.toCharArray())

			def cust = new Customer (customerNo: custno, name: name)
			def mode = p.showProgress ()
			cust.save(failOnError: false, validate: true, flush: mode)
		}
	}

	def destroy = {
	}
}
