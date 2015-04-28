import java.lang.Runtime

class ProgressIndicator {
	
	static mb = 1024**2
	static runtime = new Runtime()

	def total
	def timestamp
	def last_percent
	def msgs = []
	def n

	def ProgressIndicator (t) {
		total = t
		timestamp = new Date ()
		last_percent = -1
		n = 0
	}

	boolean showProgress (boolean stdout = true) {
		int percent = (n++ / total) * 100
		if (percent != last_percent && (percent % 5 == 0)) {
			def last = timestamp
			timestamp = new Date ()
			use (groovy.time.TimeCategory) {
				def duration = timestamp - last
				def msg = "processing [${n}] (${percent}%) ${(int) runtime.freeMemory()/mb}M free ${duration}"
				if (stdout)
					println "$msg"
				msgs << msg
			}
			last_percent = percent
			return true
		}

		return false
	}
}
