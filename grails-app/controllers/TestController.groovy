class TestController {
	
	def leakService

	def index () {
		return leak ()
	}

	def leak () {
		def result = leakService.leak ()
		render result.join ('<br>')
	}

	def noleak () {
		def result = leakService.noleak ()
		render result.join ('<br>')
	}
}
