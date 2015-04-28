import org.bson.types.ObjectId

class Customer {
	static mapWith = 'mongo'

	ObjectId id
	String customerNo
	Name name
	

	static constraints = {
		customerNo nullable: false, blank: false, minSize: 7, index: true, unique: true
		name nullable: false, index: true
	}

	static embedded = [ 'name' ]

	static mapping = {
		database 'leak-test'
		collection 'customers'
		customerNo index: true, unique: true, dropDups: true
		name index: true
	}
}
