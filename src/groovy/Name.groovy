class Name {

	String first
	String middle
	String last

	static constraints = {
		first blank: false, nullable: false
		middle blank: true, nullable: true
		last blank: false, nullable: false
	}
}
