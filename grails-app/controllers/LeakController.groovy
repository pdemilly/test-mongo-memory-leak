class LeakController {
	
	def leakService

	def index () {
		def result = leakService.leak ()
		render result.join ('<br>')
	}
}
